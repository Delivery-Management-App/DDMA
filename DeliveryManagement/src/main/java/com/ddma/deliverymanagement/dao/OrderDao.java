package com.ddma.deliverymanagement.dao;
import com.ddma.deliverymanagement.entity.db.Order;

import com.ddma.deliverymanagement.entity.db.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceException;

@Repository
public class OrderDao {
    @Autowired
    private SessionFactory sessionFactory;
    // make a order
    public boolean makeOrder(Order order) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            User user = session.get(User.class, order.getUserId());
            user.getOrders().add(order);
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (PersistenceException | IllegalStateException ex) {

            ex.printStackTrace();
            session.getTransaction().rollback();
            return false;
        } finally {
            if (session != null) session.close();
        }
        return true;
    }
    // cancel a order
    public void unsetFavoriteItem(String userId, String ordernum) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            User user = session.get(User.class, userId);
            Order order = session.get(Order.class, ordernum);
            user.getOrders().remove(order);
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) session.close();
        }
    }
}
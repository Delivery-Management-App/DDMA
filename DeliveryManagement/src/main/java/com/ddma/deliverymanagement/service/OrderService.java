package com.ddma.deliverymanagement.service;

import com.ddma.deliverymanagement.dao.OrderDao;
import com.ddma.deliverymanagement.entity.db.Order;
import com.ddma.deliverymanagement.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    public boolean makeOrder(Order order) throws IOException {
        return orderDao.makeOrder(order);
    }

    public boolean unsetFavoriteItem(String userId, String ordernum) throws IOException {
        return orderDao.unsetFavoriteItem(userId, ordernum);
    }
}

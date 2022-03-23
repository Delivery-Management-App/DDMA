package com.ddma.deliverymanagement.service;

import com.ddma.deliverymanagement.dao.RegisterDao;
import com.ddma.deliverymanagement.entity.db.User;
import com.ddma.deliverymanagement.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class RegisterService {

    @Autowired
    private RegisterDao registerDao;

    public boolean register(User user) throws IOException {
        user.setPassword(Util.encryptPassword(user.getUserId(), user.getPassword()));
        return registerDao.register(user);
    }
}


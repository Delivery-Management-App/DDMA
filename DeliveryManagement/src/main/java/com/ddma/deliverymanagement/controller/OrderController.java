package com.ddma.deliverymanagement.controller;

import com.ddma.deliverymanagement.entity.db.Order;
import com.ddma.deliverymanagement.entity.request.LoginRequestBody;
import com.ddma.deliverymanagement.entity.response.LoginResponseBody;
import com.ddma.deliverymanagement.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping(value = "/makeOrder", method = RequestMethod.POST)
    public void makeOrder(@RequestBody LoginRequestBody requestBody, HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean order = orderService.makeOrder(requestBody.getOrder());

    }
}

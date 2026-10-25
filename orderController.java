package com.jsp.ai.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.ai.Entity.OrderEntity;
import com.jsp.ai.Service.Order_Service;

@RestController
public class orderController {

    @Autowired
    private Order_Service orderService;

    @PostMapping("/createorder")
    public String createorder(@RequestBody OrderEntity orderEntity) {
        return orderService.processCreateOrder(orderEntity);
    }

    @GetMapping("/status/{orderId}")
    public String getorderstatus(
            @PathVariable("orderId") BigInteger orderId) {
        return orderService.processorderstatus(orderId);
    }
}

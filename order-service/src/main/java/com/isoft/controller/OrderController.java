package com.isoft.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @GetMapping("/order")
    public String placeOrder(){
        return "已下单";
    }

}

package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by avatarion on 3/21/16.
 */
@Controller
public class OrderController {
    @RequestMapping(value = "/order")
    public String getNew() {
        return "order";
    }
}

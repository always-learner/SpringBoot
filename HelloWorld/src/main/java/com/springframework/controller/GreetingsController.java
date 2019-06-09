package com.springframework.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sam on 9/6/19.
 */
@RestController
public class GreetingsController {

    @RequestMapping("/")
    public String sayHello(){
        return "Hello user";
    }
}

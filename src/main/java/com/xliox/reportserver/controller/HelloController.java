package com.xliox.reportserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by 一初 on 2019-11-20
 */
@RestController
public class HelloController {

    @RequestMapping("/hello1")
    public String hello() throws Exception {
        return "Hello Spring Boot!";
    }
}

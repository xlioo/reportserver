package com.xliox.reportserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by 一初 on 2019-11-20
 * 尝试获取html页面
 */
@Controller
public class HtmlController {
    @RequestMapping("/{hello}")
    public String hello(@PathVariable String hello) throws Exception {
        return hello;
    }

}

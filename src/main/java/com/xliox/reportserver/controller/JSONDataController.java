package com.xliox.reportserver.controller;

import com.alibaba.fastjson.JSONObject;
import com.xliox.reportserver.units.JDBCTest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by 一初 on 2019-11-20
 */
@RestController
public class JSONDataController {
    @RequestMapping(value = "/JSONData", method={RequestMethod.GET})
    @ResponseBody
    public JSONObject hello() throws Exception {
        JDBCTest jdbcTest = new JDBCTest();

        return jdbcTest.getData();
    }
}

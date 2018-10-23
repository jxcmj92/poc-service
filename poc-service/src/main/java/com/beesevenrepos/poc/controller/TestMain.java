package com.beesevenrepos.poc.controller;

import com.beesevenrepos.poc.Api.TestApi;
import com.beesevenrepos.poc.dao.mysql.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Auther: chenmingjian
 * @Date: 18-10-22 17:49
 */

@RestController
public class TestMain implements TestApi {

    @Autowired
    private TestMapper testMapper;


    @Override
    public String test() {
        System.out.println(testMapper.test());
        return testMapper.test002();
    }
}

package com.beesevenrepos.poc.Api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Auther: chenmingjian
 * @Date: 18-10-22 17:55
 */
@RequestMapping("/poc")
public interface TestApi {

    @GetMapping("/test")
    public String test();
}

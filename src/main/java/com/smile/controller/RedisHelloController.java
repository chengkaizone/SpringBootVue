package com.smile.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 测试此类必须启动redis-server
 */
@RestController
public class RedisHelloController {

    @Value("${server.port}")
    String port;

    @PostMapping("/redissave")
    public String saveName(String name, HttpSession session) {
        session.setAttribute("name", name);
        return port;
    }

    @GetMapping("/redisget")
    public String getName(HttpSession session) {
        return port + ":" + session.getAttribute("name");
    }

}

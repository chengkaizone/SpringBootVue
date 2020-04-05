package com.smile.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@RestController
public class HelloController {

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("index");
        return view;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello spring boot";
    }

    @GetMapping("/hello2")
    public void hello2(Model model) {
        Map<String, Object> map = model.asMap();
        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Object value = map.get(key);
            System.out.println("key:" + key + " v: " + value);
        }
    }

    @GetMapping("/helloerr")
    public String helloerr() {
        int i = 1 / 0;
        return "error";
    }

}

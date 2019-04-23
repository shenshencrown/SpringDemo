package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/log")
public class LogController {

    @RequestMapping("/demo")
    public String logTest() {
        log.info("测试{}，输出{}", "demo1", "info level log");
        return "测试成功";
    }
}

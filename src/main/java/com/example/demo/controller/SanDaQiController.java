package com.example.demo.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.demo.config.MyHttpSessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SanDaQiController {

    private final Logger logger = LoggerFactory.getLogger(SanDaQiController.class);

    @Value("${application.message:Hello World}")
    private String message ;

    //@GetMapping是一个组合注解 是@RequestMapping(method = RequestMethod.GET)的缩写
    //在路由中定义变量规则后，通常我们需要在处理方法（也就是@RequestMapping注解的方法）中获取这个URL的具体值，并根据这个值（例如用户名）做相应的操作，SpringMVC提供的@PathVariable可以帮助我们
    @GetMapping("/asd/{name}")
    @ResponseBody
    public String welcome(@PathVariable String name,Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", this.message);
        model.put("name","zhangsan");
        return "welcome";
    }

    @RequestMapping("/login")
    @ResponseBody
    public Object foo() {
        logger.info("打印日志----------------------");
        return  "login";
    }

    @RequestMapping("/index")
    @ResponseBody
    public Object index(HttpServletRequest request) {
        //true代表创建sesson，false代表不创建，而是从request中获取
        HttpSession  session = request.getSession(true);
        session.setAttribute("zxc", "zxc");
        return  "index";
    }

    @RequestMapping("/logout")
    @ResponseBody
    public Object logout(HttpServletRequest request) {
        //true代表创建sesson，false代表不创建，而是从request中获取
        HttpSession  session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("zxc");
            session.invalidate();
        }
        return  "logout success";
    }

    @RequestMapping("/online")
    @ResponseBody
    public Object online() {
        return  "当前在线人数：" + MyHttpSessionListener.online + "人";
    }
}
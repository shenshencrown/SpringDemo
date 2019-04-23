package com.example.demo.controller;

import com.example.demo.entity.Per;
import com.example.demo.service.PerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**自动返回的是json格式数据***/
@RestController
public class PerController {
    @Autowired
    private PerService perService;

    @RequestMapping("getPer")
    public List<Per> getPers() {
        List<Per> result= perService.findAllPer();
        System.out.println(result);
        return result;
    }
}

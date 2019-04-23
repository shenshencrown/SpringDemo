package com.example.demo.service.impl;

import com.example.demo.dao.PerMapper;
import com.example.demo.entity.Per;
import com.example.demo.service.PerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PerServiceImpl implements PerService {

    @Autowired
    private PerMapper perMapper;
    @Override
    public List<Per> findAllPer() {
        return perMapper.findall();
    }
}

package com.example.demo.service;

import com.example.demo.entity.Per;

import java.util.List;

public interface PerService {
    /**
     * 查询表中全部数据
     * @return
     */
    public List<Per> findAllPer();
}

package com.example.demo.dao;

import com.example.demo.entity.Per;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PerMapper {
    public List<Per> findall();
}

package com.example.demo.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.model.Hoge;

@Mapper
public interface HogeMapper {
	
	List<Hoge> getHoge();

}

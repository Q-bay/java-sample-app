package com.example.demo.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.model.Hoge;
import com.example.demo.domain.repository.HogeMapper;

@Service
public class HogeServiceImpl implements HogeService{
	
	@Autowired
	HogeMapper repository;

	public List<Hoge> getHoge(){
		
		return repository.getHoge();
	
	};
}

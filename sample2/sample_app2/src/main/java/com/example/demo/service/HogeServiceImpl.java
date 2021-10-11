package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.model.HogeOutput;
import com.example.demo.domain.repository.HogeMapper;

@Service
public class HogeServiceImpl implements HogeService{

	@Autowired
	HogeMapper hogeMapper;
	
	public HogeOutput getHoge() {
		System.out.println("2222222222222222");
		return new HogeOutput(hogeMapper.selectHoge());
	}
}

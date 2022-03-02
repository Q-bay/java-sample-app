package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.model.entity.HogeEntity;
import com.example.demo.domain.repository.HogeMapper;

@Service
public class HogeServiceImpl implements HogeService{
	
	@Autowired
	HogeMapper mapper;

	public List<HogeEntity> getHoges(){
		
		return mapper.getHoges();
	}


}

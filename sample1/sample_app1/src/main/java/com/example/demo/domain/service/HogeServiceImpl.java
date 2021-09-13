package com.example.demo.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.model.FindHogeInput;
import com.example.demo.domain.model.FindHogeOutput;
import com.example.demo.domain.model.InsertHogeInput;
import com.example.demo.domain.model.InsertHogeOutput;
import com.example.demo.domain.repository.HogeRepository;
import com.example.demo.repository.entity.HogeEntity;

import lombok.NonNull;

@Service
public class HogeServiceImpl implements HogeService {
	
	@Autowired
	HogeRepository hogeRepository;
	
	@Override
	public FindHogeOutput findHoge(@NonNull FindHogeInput findHogeInput) {
				
		HogeEntity hogeEntity = hogeRepository.findById(findHogeInput.getId());
		
		FindHogeOutput findHogeOutput = new FindHogeOutput(hogeEntity);
		
		return findHogeOutput;
	};
	
	@Override
	public InsertHogeOutput insertHoge(@NonNull InsertHogeInput insertHogeInput) {
		
		HogeEntity hogeEntity = hogeRepository.findById(insertHogeInput.getId());
		InsertHogeOutput insertHogeOutput = new InsertHogeOutput(hogeEntity);
		
		return insertHogeOutput;
	};
}

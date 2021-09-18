package com.example.demo.domain.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.kms.model.NotFoundException;
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
	public FindHogeOutput findHoge(@NonNull FindHogeInput findHogeInput) throws NotFoundException {
				
		HogeEntity hogeEntity = hogeRepository.findById(findHogeInput.getId(), findHogeInput.getName());
		
		FindHogeOutput findHogeOutput = new FindHogeOutput(hogeEntity);
		
		return findHogeOutput;
	};
	
	@Override
	public InsertHogeOutput insertHoge(@NonNull InsertHogeInput insertHogeInput) {
		
		hogeRepository.insert(insertHogeInput.getHogeEntity());
		return new InsertHogeOutput(insertHogeInput.getHogeEntity());
		
	};
}

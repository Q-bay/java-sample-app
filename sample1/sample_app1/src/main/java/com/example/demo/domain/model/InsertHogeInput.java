package com.example.demo.domain.model;

import com.example.demo.repository.entity.HogeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class InsertHogeInput {
	
	private HogeEntity hogeEntity;
}

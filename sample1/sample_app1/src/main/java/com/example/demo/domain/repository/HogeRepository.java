package com.example.demo.domain.repository;

import com.example.demo.repository.entity.HogeEntity;

public interface HogeRepository {

	HogeEntity insert(HogeEntity hoge);
	
	HogeEntity findById(String id);
}

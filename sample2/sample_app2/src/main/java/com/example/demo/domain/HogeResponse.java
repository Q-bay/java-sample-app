package com.example.demo.domain;

import java.util.List;

import com.example.demo.domain.model.entity.HogeEntity;

import lombok.Data;

@Data
public class HogeResponse {

	private List<HogeEntity> hogeList;
}

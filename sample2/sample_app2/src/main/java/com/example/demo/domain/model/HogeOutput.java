package com.example.demo.domain.model;

import java.util.List;

import com.example.demo.domain.model.entity.HogeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HogeOutput {

	private List<HogeEntity> hogeEntityList;
}

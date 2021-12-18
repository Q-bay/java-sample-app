package com.example.demo.models.entity;

import lombok.Data;

@Data
public class CompanyEntity extends BaseEntity{

	private Integer companyId;
	
	private String companyName;
	
	private String companyType;
	
	private String companyOverview;
}

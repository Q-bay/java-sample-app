package com.example.demo.models.entity;

import lombok.Data;

@Data
public class EmployeeEntity extends BaseEntity{

	private Integer employeeId;
	
	private String employeeName;
	
	private Integer affiliatedCompanyId;
	
	private String affiliatedCompany;
	
	private String positionName;
}

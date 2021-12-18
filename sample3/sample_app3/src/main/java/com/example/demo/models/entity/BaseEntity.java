package com.example.demo.models.entity;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseEntity {

	private String created_by;
	
	private Timestamp created_at;
	
	private String updated_by;
	
	private Timestamp updated_at;

}

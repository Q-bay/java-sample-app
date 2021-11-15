package com.example.demo.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class PostRequest {

	@NotBlank(message = "番号は入力必須です。")
	String no;
	
	@NotBlank(message = "名前は入力必須です。")
	String name; 
	
	@Email(message = "Eメール形式でお願いします。")
	String mailAdress;
}

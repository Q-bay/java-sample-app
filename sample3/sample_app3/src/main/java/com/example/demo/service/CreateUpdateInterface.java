package com.example.demo.service;

public interface CreateUpdateInterface<T1, T2>{

	T1 create(T2 request);
	T1 update(T2 request);
}

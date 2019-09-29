package com.jhansun.sampleapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jhansun.sampleapp.model.ProductCategory;

public interface ProductRespository extends CrudRepository<ProductCategory, Integer> {
	List<ProductCategory> findAll();
}

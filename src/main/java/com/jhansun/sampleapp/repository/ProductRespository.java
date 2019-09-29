package com.jhansun.sampleapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.jhansun.sampleapp.model.ProductCategory;

public interface ProductRespository extends CrudRepository<ProductCategory, Integer> {

}

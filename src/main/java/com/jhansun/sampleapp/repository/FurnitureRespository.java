package com.jhansun.sampleapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jhansun.sampleapp.model.Furniture;

public interface FurnitureRespository extends CrudRepository<Furniture, Integer> {
	List<Furniture> findAll();
}

package com.jhansun.sampleapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jhansun.sampleapp.model.Kids;

public interface KidsRepository extends CrudRepository<Kids, Integer> {
	List<Kids> findAll();
}
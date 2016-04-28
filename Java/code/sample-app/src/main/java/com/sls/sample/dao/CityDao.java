package com.sls.sample.dao;

import java.util.List;

import com.sls.sample.entity.City;

public interface CityDao {

	City findById(Integer id);
	
	List<City> findAll();
	
	void insert(City city);
	
	void update(City city);
	
	void delete(City city);
}

package com.sls.sample.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sls.sample.dao.CityDao;
import com.sls.sample.entity.City;
import com.sls.sample.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Resource
	private CityDao cityDao;

	public List<City> findAll() {
		List<City> list = cityDao.findAll();
		list.add(new City());
		return list;
	}

}

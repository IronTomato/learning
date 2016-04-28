package com.sls.test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.type.JdbcType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.sls.sample.dao.CityDao;
import com.sls.sample.dao.impl.CityDaoImpl;
import com.sls.sample.entity.City;

@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestCityDao extends AbstractJUnit4SpringContextTests {

	@Autowired
	CityDao dao = new CityDaoImpl();

	@Test
	public void testFindById() {
		City city = dao.findById(455);
		assertEquals(city.getId().intValue(), 455);
		System.out.println(city);
		for(byte b : city.getName().getBytes()){
			System.out.format("%02X ", b);
		}
	}

//	@Test
	public void testFindAll() {
		List<City> list = dao.findAll();
		assertEquals(list.size(), 100);
	}

	// @Test
	public void testAdd() {
		City city = new City();
		city.setId(5000);
		city.setName("SkyCity");
		city.setDistrict("Sky");
		city.setPopulation(2);
		dao.add(city);
	}

	// @Test
	public void testUpdate() {
		City city = dao.findById(5000);
		city.setName("qwertyu");
		dao.update(city);
	}

	// @Test
	public void testDelete() {
		City city = dao.findById(5000);
		dao.delete(city);
	}

}

package com.sls.test.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.mockito.InjectMocks;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.sls.sample.dao.CityDao;
import com.sls.sample.entity.City;
import com.sls.sample.service.CityService;

import org.junit.Before;
import org.junit.Test;

@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class CityServiceTest extends AbstractJUnit4SpringContextTests {

	@InjectMocks
	@Resource
	private CityService cityService;

	@Mock
	private CityDao cityDao;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		City city = new City();
		city.setName("Hangzhou");
		when(cityDao.findAll()).thenReturn(new ArrayList<City>(Arrays.asList(new City[] { city })));
	}

	@Test
	public void testFindAll() {
		assertEquals(cityService.findAll().size(), 2);
		assertEquals(cityService.findAll().get(0).getName(), "Hangzhou");
		System.out.println(cityService.findAll().get(0));
	}

}

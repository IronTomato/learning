package com.sls.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.sls.sample.entity.City;

@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class UseSpringTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private City city;
	
//	@Autowired
//	private CityDao cityDao;
//	@Rule
//	public TestRule rule = new ExcuteTime();

	@Test
	public void test() {
//		assertEquals(city.getId().intValue(), 1111);
//		System.out.println(city);
		
//		City city = cityDao.findById(1);
		System.out.println(city);
	}
	
}

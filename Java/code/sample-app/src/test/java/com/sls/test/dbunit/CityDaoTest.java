package com.sls.test.dbunit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sls.sample.dao.CityDao;
import com.sls.sample.entity.City;

public class CityDaoTest extends BaseDaoTest {

	private final String tableName = "city";

	@Autowired
	private CityDao cityDao;

	@Test
	public void testIsInited() {
		assertNotNull(cityDao);
	}

	@Before
	public void setup() throws Exception {
		clearTable(tableName);
	}

	@After
	public void teardown() throws Exception {
		clearTable(tableName);
	}

	@Test
	public void testSave() throws Exception {

		City city = new City();
		city.setId(1);
		city.setName("Kabul");
		city.setCountryCode("AFG");
		city.setDistrict("Kabol");
		city.setPopulation(1780000);
		cityDao.insert(city);
		verifyTable("dbunit/city-copy.xml", tableName);
	}

	@Test
	public void testEmpty() throws Exception {
		verifyEmpty("city");
	}

}

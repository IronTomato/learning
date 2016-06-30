package com.wnb.test.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.wnb.dao.CityDao;
import com.wnb.entity.City;

@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@TransactionConfiguration(defaultRollback = true)
public class TestCityDao extends AbstractJUnit4SpringContextTests {

    @Autowired
    private CityDao dao;

    @Test
    public void testFindById() {
        City city = dao.findById(1);
        assertEquals(city.getId().intValue(), 1);
        System.out.println(city);

    }

}

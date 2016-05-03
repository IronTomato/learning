package org.wnb.test.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.wnb.dao.CityDao;
import org.wnb.dao.impl.CityDaoImpl;
import org.wnb.entity.City;

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

package org.wnb.test.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.wnb.dao.CityDao;
import org.wnb.dao.impl.CityDaoImpl;
import org.wnb.entity.City;

public class TestCityDao {

    CityDao dao = new CityDaoImpl();
    
    @Test
    public void testFindById() {
        City city = dao.findById(1);
        assertEquals(city.getId().intValue(), 1);
        System.out.println(city);
    }

}

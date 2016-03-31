package org.wnb.test.service;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.wnb.dao.CityDao;
import org.wnb.entity.City;
import org.wnb.service.CityService;

@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestCityService extends AbstractJUnit4SpringContextTests{

    @InjectMocks
    @Resource
    private CityService service;
    
    @Mock
    private CityDao cityDao;
    
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        when(cityDao.findAll()).thenThrow(RuntimeException.class);
    }
    
    @Test(expected=RuntimeException.class)
    public void testFindAll() {
        when(cityDao.findAll()).thenReturn(Arrays.asList(new City(),new City()));
        
        List<City> list = service.findAll();
        assertNotNull(list);
        assertEquals(100,list.size());
    }

}

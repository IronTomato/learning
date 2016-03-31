package org.wnb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wnb.dao.CityDao;
import org.wnb.entity.City;
import org.wnb.service.CityService;

@Service
public class CityServiceImpl implements CityService {

    @Resource
    private CityDao cityDao;
    
    @Override
    public List<City> findAll() {
        return cityDao.findAll();
    }

}

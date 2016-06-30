package com.wnb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.wnb.dao.CityDao;
import com.wnb.entity.City;
import com.wnb.service.CityService;

@Service
public class CityServiceImpl implements CityService {

    @Resource
    private CityDao cityDao;
    
    @Override
    public List<City> findAll() {
        return cityDao.findAll();
    }

}

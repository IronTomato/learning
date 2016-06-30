package com.wnb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.wnb.dao.CityDao;
import com.wnb.entity.City;

@Repository
public class CityDaoImpl extends BaseDaoImpl<City,Integer> implements CityDao {

    @Override
    protected String namespace() {
        return "mybatis.mapper.CityMapper";
    }
    
    @Override
    public List<City> findAll(){
        System.out.println("real method called");
        return super.findAll();
    } 

}

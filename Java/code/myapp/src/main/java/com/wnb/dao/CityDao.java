package com.wnb.dao;

import java.util.List;

import com.wnb.entity.City;

public interface CityDao extends BaseDao<City, Integer>{

    City findById(Integer id);

    List<City> findAll();

    void add(City city);

    void update(City city);

    void delete(City city);
}

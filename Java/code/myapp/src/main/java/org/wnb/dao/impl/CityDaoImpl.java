package org.wnb.dao.impl;

import java.util.List;

import org.wnb.dao.CityDao;
import org.wnb.entity.City;

public class CityDaoImpl extends BaseDaoImpl<City,Integer> implements CityDao {

    @Override
    protected String namespace() {
        return "mybatis.mapper.CityMapper";
    }

}

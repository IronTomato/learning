package com.wnb.dao.impl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {

    private static String CONFIG = "mybatis-config.xml";
    private static SqlSessionFactory factory;

    static {
        factory = new SqlSessionFactoryBuilder().build(MyBatisUtil.class.getClassLoader().getResourceAsStream(CONFIG));
    }
    
    public static SqlSessionFactory getSqlSessionFactory(){
        return factory;
    }
}

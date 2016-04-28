package com.sls.sample.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.sls.sample.dao.CityDao;
import com.sls.sample.entity.City;

@Repository
public class CityDaoImpl extends BaseDaoImpl<City, Integer> implements CityDao {


	private static String NAME_SPACE = "mybatis.xml.CityMapper";

	public List<City> findAll() {
		return getSqlSession().selectList(getFullMethodName(MethodName.findAll));
	}

	@Override
	protected String getNamespace() {
		return NAME_SPACE;
	}
	
	private static enum MethodName{
		findAll;
	}

//	private SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
//			.build(this.getClass().getClassLoader().getResourceAsStream("mybatis-config.xml"));
//
//	private SqlSession getSession() {
//		return sessionFactory.openSession();
//	}
//
//
//	public String namespace() {
//		return NAME_SPACE;
//	}
//
//	public City findById(Integer id) {
//		City city = getSession().selectOne(MethodName.findById.toString(), id);
//		return city;
//	}
//
//	public List<City> findAll() {
//		return getSession().selectList(MethodName.findAll.toString());
//	}
//
//	public void add(City city) {
//		SqlSession session = getSession();
//		
//		session.insert(MethodName.add.toString(), city);
//		session.commit();
//		session.close();
//	}
//
//	public void update(City city) {
//		SqlSession session = getSession();
//		
//		session.update(MethodName.update.toString(), city);
//		session.commit();
//		session.close();
//	}
//
//	public void delete(City city) {
//		SqlSession session = getSession();
//		session.delete(MethodName.delete.toString(), city);
//		session.commit();
//		session.close();
//	}
//
//	private static enum MethodName {
//		findById, findAll, add, update, delete;
//
//		@Override
//		public String toString() {
//			return CityDaoImpl.NAME_SPACE + this.name();
//		}
//	}

}

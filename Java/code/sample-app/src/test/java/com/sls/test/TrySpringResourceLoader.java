package com.sls.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.sls.sample.dao.CityDao;

public class TrySpringResourceLoader {
	

//	@Test
	public void test() throws IOException {
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource[] resources = resolver.getResources("classpath*:**/*.xml");
		for (Resource resource : resources) {
			System.out.println(resource.getFilename());
		}
//		ClassPathXmlApplicationContext
	}
	
	@Test
	public void testSpringStart(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ctx.getBean(CityDao.class);
	}

}

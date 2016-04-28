package com.sls.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class TrySpringResourceLoader {
	

	@Test
	public void test() throws IOException {
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource[] resources = resolver.getResources("classpath*:**/*.xml");
		for (Resource resource : resources) {
			System.out.println(resource.getFilename());
		}
//		ClassPathXmlApplicationContext
	}

}

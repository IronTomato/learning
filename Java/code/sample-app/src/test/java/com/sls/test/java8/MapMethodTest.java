package com.sls.test.java8;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.Test;

public class MapMethodTest {

	@Test
	public void test() {
		Map<String, String> map = new HashMap<>();
		map.put("1", "one");
		map.put("2", "two");
		map.put("3", "three");
		map.put("4", "four");
		StringBuilder sb = new StringBuilder();
		StringBuilder re = Arrays.asList("1", "2", "3").stream().map(map::get).reduce(new StringBuilder(),
				StringBuilder::append, StringBuilder::append);
		System.out.println(re);
	}

}

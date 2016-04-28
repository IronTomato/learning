package com.sls.test;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class PatternTest {

	@Test
	public void test() {
		Pattern pattern = Pattern.compile(".*App.*");
		Matcher matcher = pattern.matcher("com.sls.bm.App.test");
		System.out.println(matcher.matches());
	}

}

package com.sls.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class UseBaseTestClass extends BaseTestClass {


	@Test
	public void test() {
//		assertEquals(1, 2);
		log.info(BigDecimal.ZERO+"");
	}

}

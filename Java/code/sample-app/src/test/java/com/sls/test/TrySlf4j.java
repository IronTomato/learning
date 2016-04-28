package com.sls.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrySlf4j {

	@Test
	public void test() {
		Logger logger = LoggerFactory.getLogger(this.getClass());
		logger.debug("debug level log");
		logger.info("info level log");
		logger.error("error level log"); 
	}

}

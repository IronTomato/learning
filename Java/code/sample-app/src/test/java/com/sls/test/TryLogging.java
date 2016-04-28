package com.sls.test;

import static org.junit.Assert.*;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

public class TryLogging {

	@Test
	public void test() {
		Logger logger = Logger.getLogger(this.getClass().getName());

		logger.setLevel(Level.FINEST);
		logger.fine("test logging1");
		logger.config("test logging2");
		logger.info("test logging3");
		logger.warning("test logging4");
		logger.severe("test logging5");
	}

}

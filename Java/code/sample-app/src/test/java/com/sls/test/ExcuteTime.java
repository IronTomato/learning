package com.sls.test;

import org.apache.commons.logging.Log;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class ExcuteTime implements TestRule {
	
	private Log log;
	public ExcuteTime(Log log){
		this.log = log;
	}

	public Statement apply(final Statement base, final Description description) {
		return new Statement() {

			@Override
			public void evaluate() throws Throwable {
				long start = System.currentTimeMillis();
				base.evaluate();
				long end = System.currentTimeMillis();
				log.info(description.getClassName() + "." + description.getMethodName() + "() cost "
						+ (end - start) + "ms");
			}
		};
	}

}

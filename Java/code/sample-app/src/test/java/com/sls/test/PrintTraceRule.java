package com.sls.test;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class PrintTraceRule implements TestRule {

	public Statement apply(final Statement base, Description description) {
		return new Statement() {
			
			@Override
			public void evaluate() throws Throwable {
				try {
					base.evaluate();
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
			}
		};
	}

}

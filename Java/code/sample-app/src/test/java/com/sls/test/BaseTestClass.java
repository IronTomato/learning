package com.sls.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Rule;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class BaseTestClass {

	protected final Log log = LogFactory.getLog(this.getClass());

//	@Rule
	public TestRule logExcuteTime = new ExcuteTime(log);

	@Rule
	public RuleChain ruleChain = RuleChain.outerRule(new ErrorLogRule()).around(new Timeout(1000));

	public static class ErrorLogRule implements TestRule {

		public Statement apply(final Statement base, final Description description) {
			return new Statement() {

				@Override
				public void evaluate() throws Throwable {
					try {
						base.evaluate();
					} catch (Throwable e) {
						LogFactory.getLog(description.getTestClass()).info(e.getMessage());
						throw e;
					}
				}
			};

		}

	}

}

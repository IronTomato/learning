package com.sls.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.runners.model.Statement;

@RunWith(Suite.class)
@SuiteClasses({ TestJUnitLifeCycle.class })
public class TestSuiteLifeCycle {

	@ClassRule
	public static TestRule classRule = new TestRule() {

		public Statement apply(final Statement base, final Description description) {
			return new Statement() {

				@Override
				public void evaluate() throws Throwable {
					println(description.getClassName() + " @ClassRule");
					base.evaluate();
					println(description.getClassName() + " @ClassRule");
				}
			};
		}
	};

	@Rule
	public TestRule rule = new TestRule() {

		public Statement apply(final Statement base, final Description description) {
			return new Statement() {

				@Override
				public void evaluate() throws Throwable {
					println(description.getClassName() + " @Rule");
					base.evaluate();
					println(description.getClassName() + " @Rule");
				}
			};
		}
	};

	@BeforeClass
	public static void beforeClass() {
		System.out.println("TestSuiteLifeCycle @BeforeClass");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("TestSuiteLifeCycle @AfterClass");
	}

	@Before
	public void before() {
		println(this.getClass().getSimpleName() + " @Before");
	}

	@After
	public void after() {
		println(this.getClass().getSimpleName() + " @After");
	}

	@Test
	public void test() {
		System.out.println(this.getClass().getName() + " @Test");
	}

	public static void println(String str) {
		System.out.println(str);
	}
}

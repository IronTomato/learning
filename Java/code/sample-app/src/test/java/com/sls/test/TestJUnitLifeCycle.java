package com.sls.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class TestJUnitLifeCycle {

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
	public TestRule rule1 = new TestRule() {

		public Statement apply(final Statement base, final Description description) {
			return new Statement() {

				@Override
				public void evaluate() throws Throwable {
					println(description.getClassName() + " @Rule1");
					try {
						base.evaluate();
					} finally {
						println(description.getClassName() + " @Rule1");
						println(description.toString());
					}
				}
			};
		}
	};
	@Rule
	public TestRule rule2 = new TestRule() {

		public Statement apply(final Statement base, final Description description) {
			return new Statement() {

				@Override
				public void evaluate() throws Throwable {
					println(description.getClassName() + " @Rule2");
					base.evaluate();
					println(description.getClassName() + " @Rule2");
				}
			};
		}
	};

	@BeforeClass
	public static void beforeClass() {
		System.out.println("TestJUnitLifeCycle @BeforeClass");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("TestJUnitLifeCycle @AfterClass");
	}

	@Before
	public void before1() {
		println(this.getClass().getSimpleName() + " @Before1");
	}
	@Before
	public void before2() {
		println(this.getClass().getSimpleName() + " @Before2");
	}

	@After
	public void after1() {
		println(this.getClass().getSimpleName() + " @After1");
	}
	@After
	public void after2() {
		println(this.getClass().getSimpleName() + " @After2");
	}

	@Test
	public void testMethod() {
		System.out.println(this.getClass().getName()+" @Test");
		fail("----");
	}

	public static void println(String str) {
		System.out.println(str);
	}

}

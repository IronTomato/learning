package com.sls.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TryParameterizedTest {

	@SuppressWarnings("rawtypes")
	@Parameters
	public static Collection prepareData() {
		Object[][] objects = { { -1, -2, -3 }, { 0, 2, 2 }, { -1, 1, 0 }, { 1, 2, 3 } };
		return Arrays.asList(objects);
	}

	private int input1;
	private int input2;
	private int expected;

	public TryParameterizedTest(int input1, int input2, int expected) {
		this.input1 = input1;
		this.input2 = input2;
		this.expected = expected;
	}

	@Test
	public void testAdd() {
		assertEquals(expected, input1 + input2);
	}

}

package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtilTest {

	private MathUtil mathUtil = new MathUtil();

	@Test
	void testAdd() {
		assertEquals(2, mathUtil.add(1, 1), "Should return correct sum.");
	}

	@Test
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> mathUtil.divide(1, 0),
				"Divide by zero should throw an Arithmatic exception.");
	}

}

package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtilTest {

	@Test
	void testAdd() {
		MathUtil mathUtil = new MathUtil();
		assertEquals(2, mathUtil.add(1, 1), "Should return correct sum.");
	}

	@Test
	void testDivide() {
		MathUtil mathUtil = new MathUtil();
		assertThrows(ArithmeticException.class, () -> mathUtil.divide(1, 0),
				"Divide by zero should throw an Arithmatic exception.");
	}

}

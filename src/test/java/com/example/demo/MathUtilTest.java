package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MathUtilTest {

	private MathUtil mathUtil;

	@BeforeEach
	void initMathUtil() {
		mathUtil = new MathUtil();
	}

	@Test
	void testAdd() {
		mathUtil = new MathUtil();
		assertEquals(2, mathUtil.add(1, 1), "Should return correct sum.");
	}

	@Test
	void testDivide() {
		mathUtil = new MathUtil();
		assertThrows(ArithmeticException.class, () -> mathUtil.divide(1, 0),
				"Divide by zero should throw an Arithmatic exception.");
	}

}

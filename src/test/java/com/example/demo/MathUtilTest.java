package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MathUtilTest {
	
	private MathUtil mathUtil = new MathUtil();

	@Test
	void testAdd() {
		assertEquals(2, mathUtil.add(1, 1), "Should return correct sum.");
	}

}

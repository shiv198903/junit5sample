package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

/*Makes junit to initialize the class only once in the 
test run. This can be used in cases where we want 
to share the member variables between different tests.
Although the sequeunce in which the tests are executed 
is not constant.*/
@TestInstance(Lifecycle.PER_CLASS)
class MathUtilTest {

	private MathUtil mathUtil;

	@BeforeEach
	void initMathUtil() {
		mathUtil = new MathUtil();
	}

	@Test
	@DisplayName("Testing add method")
	void testAdd() {
		assertEquals(2, mathUtil.add(1, 1), "Should return correct sum.");
	}

	/*
	 * @EnabledOnOs conditional annotation makes the test 
	 * to be executed if the underlying os is linux.
	 */
	@Test
	@DisplayName("Testing divide method")
	@EnabledOnOs(OS.LINUX)
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> mathUtil.divide(1, 0),
				"Divide by zero should throw an Arithmatic exception.");
	}
	
	/*
	 * The @Disabled annotation makes junit to skip this test.
	 */
	@Test
	@Disabled
	@DisplayName("Testing substract method")
	void testSubstract() {
		assertEquals(1, mathUtil.substract(2, 1), "Should return correct substract.");
	}
	
	/*
	 * The assumeTrue can have condition that requires to be true 
	 * to run the test. For example the condition could be that
	 * the server should be up.If the condition is false the
	 * test is skipped.
	 */
	@Test
	@DisplayName("Testing multiply method")
	void testMultiply() {
		Assumptions.assumeTrue(false);
		assertEquals(9, mathUtil.multiply(3, 3), "Should return correct multiply.");
	}


}

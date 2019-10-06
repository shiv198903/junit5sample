package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestReporter;
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
	private TestInfo testInfo;
	private TestReporter testReporter;

	@BeforeEach
	void initMathUtil(TestInfo testInfo, TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		mathUtil = new MathUtil();
	}

	@RepeatedTest(value = 3)
	@DisplayName("Testing add method")
	@Tag("Add")
	void testAdd() {
		testReporter.publishEntry("Running "+testInfo.getTestMethod());
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
		testReporter.publishEntry("Running "+testInfo.getTestMethod());
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
		testReporter.publishEntry("Running "+testInfo.getTestMethod());
		assertEquals(9, mathUtil.multiply(3, 3), "Should return correct multiply.");
	}
	
	@Test
	@DisplayName("Testing all MathUtil operations in one test")
	void testAllOperations() {
		testReporter.publishEntry("Running "+testInfo.getTestMethod());
		Assertions.assertAll(
				() -> assertEquals(4, mathUtil.add(2, 2)),
				() -> assertEquals(4, mathUtil.substract(6, 2)),
				() -> assertEquals(4, mathUtil.divide(8, 2)),
				() -> assertEquals(4, mathUtil.multiply(2, 2))
				);
	}
	
	@Nested
	@DisplayName("Add Group")
	@Tag("Add")
	/*
	 * Supplying a string as an executable to the assert
	 * function makes juint to execute it only if the test
	 * fails not when it is passed. This can be useful in 
	 * cases where calculation of String might be computation
	 * heavy.
	 */
	class GroupedAddTest{
		@Test
		@DisplayName("Testing positive add method")
		void testPositiveAdd() {
			assertEquals(2, mathUtil.add(1, 1), () -> "Should return correct sum.");
		}
		
		@Test
		@DisplayName("Testing negetive add method")
		void testNegetiveAdd() {
			assertEquals(-2, mathUtil.add(-1, -1), "Should return correct sum.");
		}
		
	}


}

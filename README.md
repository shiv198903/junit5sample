# junit5sample
Sample Junit-5 project.
This is created as practise project while learning JUnit by following JavaBrains-Tutorial. 
https://www.youtube.com/playlist?list=PLqq-6Pq4lTTa4ad5JISViSb2FVG8Vwa4o

Below are the notes made during the tutorial.

Junit4 is around 10 years old. Not updated a lot of language features. Like lambdas, etc. Had a monolithic architecture.
Junit5 has a different architecture compared to Junit4 and also supports dependency injection.

Version 5 has a below components. Each has a specific purpose and needs to be included only if there's a need for it.
Platform - this runs the actual tests.
Jupiter - used to provide input to platform on what to run.
Vintage - used to run the older tests written using version 4 to run on version 5.
Extension - used to write extensions.

Based on the above description we need to have following dependencies.
Platform/Jupiter - run newly written tests.
Platform/Vintage - run older tests(version 4) using Junit5 runtime.
Platform/Extension/JupiterOrVintage - run extensions.

Always the scope of Maven dependency for Junit is test as we do not want library to be bundled at runtime.

Standard conventions:
The tests should not be ordered as that would make the execution sequential and would take longer time to test execution also it is a bad practice as
each test should be independent of another. We can use BeforeTest and AfterTest annotations to execute the logic that has to be done for the test execution.
Also we shouldn't be using class variables shared in between methods. This would increase the possibility of the invalid access/modification of
the variables by the test methods and may alter the test results.

Life Cycle:
Junit creates an new instance of test class for each test(method) so that we do not use the stale instances that might alter the results.
Junit provides hooks which can be used to execute the code before the entire test class or each method.
@BeforeAll - Called before the execution of all the tests in the particular class.Should be static as it is called even before the test class is initialized.
@BeforeEach - Called before execution of each test.
@AfterEach - Called after execution of each test.
@AfterAll - Called after the execution of all the tests in the particular class.Should be static.

Conditional Execution
@EnabledIf
@EnabledIfEnvironmentVariable
@EnabledIfSystemProperty
@EnabledOnJre
@EnabledOnJre
Above annotations help us enable/disable the tests basedon some conditions. When the condition is not met the tests are disabled/skipped.

Assumptions
Assumptions are similar to assertions that they give programmatic control to enable/disable the test execution.

AssertAll
When we have more that one assertion to be made for a single test we can use it.

@Nested is used to group certain tests where the output of test is passed only when all the nested tests are passed.

@Tag: Used to run/skip selected methods that are tagged with the same name as that provided at runtime.

TestInfo and TestReporter are the interfaces that has the details of the methods/class of the test classes and 
reporter is interface used to report the messages to the console/html or whatever output the information is streamed to.  

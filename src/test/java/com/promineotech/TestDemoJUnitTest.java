package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {
	
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	@Test
	public void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
	}
	
	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(
				Arguments.arguments(2, 4, 6, false),
				Arguments.arguments(0, 0, 0, false),
				Arguments.arguments(5, -3, 2, false),
				Arguments.arguments(-1, -1, 0, true)
				);
	}
	
	@Test
	void testCalculateSum() {
		//positive integer tests
		assertEquals(1, testDemo.calculateSum(1));
		assertEquals(3, testDemo.calculateSum(2));
		assertEquals(10, testDemo.calculateSum(4));
		
		/*negatives and zeros tests
		 * lambdas are used specify code to trigger exceptions
		 */
		assertThrows(IllegalArgumentException.class, () -> testDemo.calculateSum(0));
		assertThrows(IllegalArgumentException.class, () -> testDemo.calculateSum(-5));
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(5).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
	}
}

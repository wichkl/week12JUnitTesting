package com.promineotech;

import java.util.Random;

public class TestDemo {
	public int addPositive(int a, int b) {
		if(a > 0 && b > 0) {
			return a + b;
		} else {
			throw new IllegalArgumentException("Both paramters must be positive!");
		}
	}
	
	/* calculate sum method
	 * use a for loop to get the sum of all positive integers less than or equal to 'n'
	 * throws an exception if 'n' is not positive
	 */
	public int calculateSum(int n) {
		if(n <= 0) {
			throw new IllegalArgumentException("Input must be a positive integer");
		}
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		return sum;
	}
	public int randomNumberSquared() {
		int randomNumber = getRandomInt();
		return randomNumber * randomNumber;
	}

	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
}

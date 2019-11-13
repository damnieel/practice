package com.cvc.springboot;

public class SortTest {

	public static void main(String[] args) {
		int[] numbers = { 10, 3, 40, 8, 12 };

		for (int m : numbers) {
			System.out.print(m);
			System.out.print(" ");
		}
		
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length - 1 - i; j++)
				if (numbers[j] > numbers[j + 1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
		}
		System.out.println();
		for (int m : numbers) {
			System.out.print(m);
			System.out.print(" ");
		}
	}
}

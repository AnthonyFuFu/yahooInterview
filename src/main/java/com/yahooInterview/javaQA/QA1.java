package com.yahooInterview.javaQA;

public class QA1 {
	public static void main(String[] args) {
		String input = "ABC";
		int length = 3;
		generatePermutations(input, "", length);
	}

	public static void generatePermutations(String input, String prefix, int length) {
		if (length == 0) {
			System.out.println(prefix);
			return;
		}
		for (int i = 0; i < input.length(); i++) {
			generatePermutations(input, prefix + input.charAt(i), length - 1);
		}
	}
}

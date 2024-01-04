package com.BinaryLogic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Tests {
	public static void main(String[] args) {
		
//		List<String> words = Arrays.asList("apple", "banana", "cherry");
//		List<String> words1 = Arrays.asList("dogMeat", "EelLiver", "fanta");
//		List<String> words2 = Arrays.asList("goatMilk", "humus", "icecream");
//		List<List<String>> listOfWords = Arrays.asList(words,words1,words2);
//		
//		String result = listOfWords.stream()
//		    .flatMap(word -> Arrays.stream(word.chars().mapToObj(c -> String.valueOf((char) c)))
//		    .peek(System.out::println) // Print each letter before filtering duplicates
//		    .distinct()
//		    .peek(System.out::println) // Print each unique letter
//		    .collect(Collectors.joining());
//
//		System.out.println(result);
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

		int product = numbers.stream()
		                    .filter(n -> n % 2 != 0)
		                    .map(n -> n * 2)
		                    .reduce(1, (a, b) -> a * b);

		System.out.println(product);
		List<String> words = Arrays.asList("apple", 
				"banana", "cherry");
		List<String> result = words.stream()
		 .map(word -> 
		word.substring(0, 1).toUpperCase() + 
		word.substring(1))
		 .collect(Collectors.toList());
		System.out.println(result);
	}
}

package Practise2025.JavaPractise.GPTChallenges;

import java.util.*;
import java.util.stream.Collectors;

public class Stream {
	
	// Return list with even number greate than 10 in sorted order
	private static List<Integer> challenge1(List<Integer> list){
		return list.stream().filter(a -> (a > 10 && a % 2 == 0)).sorted().toList();
	}
	
	/*
	 * Task: Using streams, return a list of words that: 
	 * Start with "a",
	 * Converted to uppercase, 
	 * Sorted by length (shortest first)
	 */
	private static List<String> challenge2(List<String> words){
		// another way to sort .sorted(Comparator.comparingInt(String::length))
		// Or .sorted(Comparator.comparingInt(a -> a.length()))
		return words.stream().filter(a -> a.startsWith("a"))
				.map(a -> a.toUpperCase())
				.sorted((a, b) -> a.length() - b.length())
				.toList();
	}
	
	
	// Give product of all the numbers in the list
	private static int challenge3(List<Integer> list) {
		return list.stream().reduce(1, (a, b) -> a * b);
	}
	
	// Get Maximum and minimum values in the list
	private static int challenge3_2(List<Integer> list) {
		return list.stream().reduce((a, b) -> Math.max(a,  b)).get();
	}
	
	// Using streams, count the frequency of each word and return a Map<String, Long>
	private static Map<String, Long> challenge5(List<String> words) {
		return words.stream().collect(Collectors.groupingBy(word -> word, Collectors.counting()));
	}
	
	public static void main(String[] args) {
		List<Integer> list = List.of(5, 12, 8, 21, 7, 30, 18);
		System.out.println(challenge1(list));
		
		List<String> words = List.of("apple", "banana", "pear", "mango", "apricot", "blueberry");
		System.out.println(challenge2(words));

		List<Integer> nums = List.of(3, 7, 2, 10, 5);
		System.out.println(challenge3(nums));
		
		System.out.println(challenge3_2(nums));
		
		words = List.of("apple", "banana", "pear", "apple", "banana", "banana");
		System.out.println(challenge5(words));
	}
}

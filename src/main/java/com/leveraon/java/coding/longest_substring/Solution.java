package com.leveraon.java.coding.longest_substring;

import java.util.HashMap;

import lombok.extern.slf4j.Slf4j;

/**
 * Given a string, find the longest substring that contains only two unique
 * characters. For example, given "abcbbbbcccbdddadacb", the longest substring
 * that contains 2 unique character is "bcbbbbcccb".
 * 
 * @author leveraon
 *
 *         Created on: Jul 27, 2024
 */
@Slf4j
public class Solution {
	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		int max = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
			if (map.size() > 2) {
				max = Math.max(max, i - start);
				while (map.size() > 2) {
					char t = s.charAt(start);
					int count = map.get(t);
					if (count > 1) {
						map.put(t, count - 1);
					} else {
						map.remove(t);
					}
					start++;
				}
			}
		}
		max = Math.max(max, s.length() - start);
		return max;
	}

	public static void main(String[] args) {
		String testStr = "abddddfdsdfssssdfffdddfsadbcddkdkdkkdkdkdsdfdfdssssdddrrr";

		log.info("The longest substring is {}", lengthOfLongestSubstringTwoDistinct(testStr));
	}
}

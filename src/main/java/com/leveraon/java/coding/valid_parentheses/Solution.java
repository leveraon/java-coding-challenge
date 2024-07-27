package com.leveraon.java.coding.valid_parentheses;

import java.util.HashMap;
import java.util.Stack;

import lombok.extern.slf4j.Slf4j;

/**
 * Given a string containing just the characters ’(’, ’)’, ’’, ’’, ’[’ and ’]’,
 * determine if the input string is valid. The brackets must close in the
 * correct order, "()" and "()[]" are all valid but "(]" and "([)]" are not.
 * 
 */

@Slf4j
public class Solution {

	public static boolean isValid(String s) {
		HashMap<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			if (map.keySet().contains(curr)) {
				stack.push(curr);
			} else if (map.values().contains(curr)) {
				if (!stack.empty() && map.get(stack.peek()) == curr) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.empty();
	}

	public static void main(String[] args) {

		String testStr = "halo(world[famous{tourist}arraction]nowavailable)";

		log.info("\n String '{}' contains valid parentheses {}", testStr, isValid(testStr));

	}

}

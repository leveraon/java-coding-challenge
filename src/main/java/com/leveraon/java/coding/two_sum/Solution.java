package com.leveraon.java.coding.two_sum;

import java.util.HashMap;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Solution {
	public int[] twoSum(int[] numbers, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] result = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(numbers[i])) {
				int index = map.get(numbers[i]);
				result[0] = index;
				result[1] = i;
				break;
			} else {
				map.put(target - numbers[i], i);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] testArray = new int[] { 1, 2, 3, 4, 5, 8, 10 };
		int target = 12;

		log.info("Array is {}", testArray);
		log.info("Target Sum is {}", target);
		Solution solution = new Solution();
		int[] result = solution.twoSum(testArray, target);
		log.info("Two sum result {}", result);
	}
}
/**
 * LEVERAON INC
 *
 * 2015 - 2024 ALL RIGHTS RESERVED
 */
package com.leveraon.java.coding.two_sum;

import java.util.HashMap;

import lombok.extern.slf4j.Slf4j;

/**
 * @author leveraon
 *
 *         Created on: Jul 27, 2024
 */
@Slf4j
public class TwoSum {

	private HashMap<Integer, Integer> elements = new HashMap<>();

	public void add(int number) {
		if (elements.containsKey(number)) {
			elements.put(number, elements.get(number) + 1);
		} else {
			elements.put(number, 1);
		}
	}

	public boolean find(int value) {
		for (Integer i : elements.keySet()) {
			int target = value - i;
			if (elements.containsKey(target)) {
				if (i == target && elements.get(target) < 2) {
					continue;
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TwoSum twoSum = new TwoSum();

		for (int i = 1; i < 10; i++) {
			twoSum.add(i);
			log.info("Adding element {} to array", i);
		}

		log.info("Finding element 8 -> {}", twoSum.find(8));
	}

}

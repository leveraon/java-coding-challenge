package com.leveraon.java.coding.merge_sorted_array;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Solution {
	public int[] merge1(int[] arrayA, int m, int[] arrayB, int n) {
		int[] arrayC = new int[m + n];
		while (m > 0 && n > 0) {
			if (arrayA[m - 1] > arrayB[n - 1]) {
				arrayC[m + n - 1] = arrayA[m - 1];
				m--;
			} else {
				arrayC[m + n - 1] = arrayB[n - 1];
				n--;
			}
		}
		while (n > 0) {
			arrayC[m + n - 1] = arrayB[n - 1];
			n--;
		}

		return arrayC;
	}

	public int[] merge2(int[] arrayA, int m, int[] arrayB, int n) {
		int[] arrayC = new int[m + n];
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		while (k >= 0) {
			if (j < 0 || (i >= 0 && arrayA[i] > arrayB[j]))
				arrayC[k--] = arrayA[i--];
			else
				arrayC[k--] = arrayB[j--];
		}

		return arrayC;
	}

	public static void main(String[] args) {
		int[] arrayA = new int[] { 1, 2, 3, 4, 5 };
		int[] arrayB = new int[] { 13, 21, 33, 44, 54 };

		log.info("Before merge: \n Array A: {}, \n Array B: {}", arrayA, arrayB);

		Solution solution = new Solution();

		log.info("After merge1, \n New array: {}", solution.merge1(arrayA, arrayA.length, arrayB, arrayB.length));
		log.info("After merge2, \n New array: {}", solution.merge2(arrayA, arrayA.length, arrayB, arrayB.length));
	}
}

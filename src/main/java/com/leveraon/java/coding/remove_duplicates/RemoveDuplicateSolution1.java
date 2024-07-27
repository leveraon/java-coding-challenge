package com.leveraon.java.coding.remove_duplicates;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RemoveDuplicateSolution1 {

	public static int removeDuplicatesNaive(int[] A) {
		if (A.length < 2)
			return A.length;
		int j = 0;
		int i = 1;
		while (i < A.length) {
			if (A[i] == A[j]) {
				i++;
			} else {
				j++;
				A[j] = A[i];
				i++;
			}
		}
		return j + 1;
	}

	public static int[] removeDuplicates(int[] A) {
		if (A.length < 2)
			return A;
		int j = 0;
		int i = 1;
		while (i < A.length) {
			if (A[i] == A[j]) {
				i++;
			} else {
				j++;
				A[j] = A[i];
				i++;
			}
		}
		return Arrays.copyOf(A, j + 1);
	}

	public static void main(String[] args) {

		int[] testArray = new int[] { 1, 1, 2, 2, 3, 4, 5, 8 };

		log.info("Original array {}", testArray);

		int size = RemoveDuplicateSolution1.removeDuplicatesNaive(testArray);

		log.info("New array {},  size {}", testArray, size);

		log.info("Original array {}", testArray);

		int[] newArray = RemoveDuplicateSolution1.removeDuplicates(testArray);

		log.info("New array {}", newArray);

	}

}

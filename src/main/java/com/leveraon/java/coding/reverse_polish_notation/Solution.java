package com.leveraon.java.coding.reverse_polish_notation;

import java.util.Stack;

import lombok.extern.slf4j.Slf4j;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression. <br>
 * For example: <br>
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 <br>
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

@Slf4j
public class Solution {
	public static int evalRPN(String[] tokens) {
		int returnValue = 0;
		String operators = "+-*/";
		Stack<String> stack = new Stack<>();
		for (String token : tokens) {
			if (!operators.contains(token)) { // push to stack if it is a number
				stack.push(token);
			} else {// pop numbers from stack if it is an operator
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());
				switch (token) {
				case "+":
					stack.push(String.valueOf(a + b));
					break;
				case "-":
					stack.push(String.valueOf(b - a));
					break;
				case "*":
					stack.push(String.valueOf(a * b));
					break;
				case "/":
					stack.push(String.valueOf(b / a));
					break;
				}
			}
		}
		returnValue = Integer.valueOf(stack.pop());
		return returnValue;
	}

	public static void main(String[] args) {
		String[] tokens = new String[] { "2", "1", "+", "3", "*" };

		log.info("Given tokens \n {}", tokens);

		log.info("Given tokens results \n {}", evalRPN(tokens));
	}

}

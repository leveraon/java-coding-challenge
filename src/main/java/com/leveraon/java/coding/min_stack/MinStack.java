package com.leveraon.java.coding.min_stack;

import java.util.Random;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MinStack {
	public Element top;

	public MinStack() {
	}

	public void push(int x) {
		if (top == null) {
			top = new Element(x, x);
		} else {
			Element e = new Element(x, Math.min(x, top.min));
			e.next = top;
			top = e;
		}
	}

	public void pop() {
		if (top == null)
			return;
		Element temp = top.next;
		top.next = null;
		top = temp;
	}

	public int top() {
		if (top == null)
			return -1;
		return top.value;
	}

	public int getMin() {
		if (top == null)
			return -1;
		return top.min;
	}

	public static void main(String[] args) {
		MinStack stack = new MinStack();
		for (int i = 1; i < 10; i++) {
			int randomNumber = new Random().nextInt(10 + i);
			log.info("\nrandomNumber is {}", randomNumber);
			stack.push(randomNumber);
		}

		log.info("\nMin Stack is {}", stack.getMin());

	}

}

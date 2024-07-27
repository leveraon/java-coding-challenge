package com.leveraon.java.coding.min_stack;

import lombok.Data;

@Data
public class Element {
	public int value;
	public int min;
	public Element next;

	public Element(int value, int min) {
		this.value = value;
		this.min = min;
	}
}

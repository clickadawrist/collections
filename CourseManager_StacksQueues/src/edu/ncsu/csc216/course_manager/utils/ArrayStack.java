package edu.ncsu.csc216.course_manager.utils;

import java.util.ArrayList;

/**
 * @author Manaka Green and Jerry Zhang
 *
 */
public class ArrayStack<E> implements Stack {

	private ArrayList<E> list = new ArrayList<E>();

	/**
	 * Pushes the given element to the top of the stack.
	 */
	@Override
	public void push(Object element) {
		
	}

	/**
	 * Removes and returns the element at the top of the stack.
	 * @throws EmptyStackException If the stack is empty
	 */
	@Override
	public Object pop() {
		/*
		 * throws an EmptyStackException if the stack is empty
		 */
		return null;
	}

	/**
	 * Returns, but does not remove, the element at the top of the stack.
	 * @throws EmptyStackException If the stack is empty
	 */
	@Override
	public Object peek() {
		/* 
		 * throws an EmptyStackException if the stack is empty
		 */
		return null;
	}

	/**
	 * Returns true if the stack is empty.
	 */
	@Override
	public boolean isEmpty() {
		return false;
	}
}
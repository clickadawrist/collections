package edu.ncsu.csc216.course_manager.utils;

import java.util.ArrayList;

/**
 * 
 * @author Manaka Green and Jerry Zhang
 *
 */
public class ArrayStack<E> implements Stack<E> {


	private ArrayList<E> list;

	/**
	 * 
	 */
	public ArrayStack() {
		list = new ArrayList<E>();
	}

	
	/**
	 * Pushes the given element to the top of the stack.
	 */
	@Override
	public void push(E element) {
		
	}

	/**
	 * Removes and returns the element at the top of the stack.
	 * @throws EmptyStackException If the stack is empty
	 */
	@Override
	public E pop() {
		/*
		 * throws an EmptyStackException if the stack is empty
		 */
		return null;
	}

	/**
	 * Returns, but does not remove, the element at the top of the stack.
	 * It is basically get.
	 * @throws EmptyStackException If the stack is empty
	 */
	@Override
	public E peek() {
		/* 
		 * Use arraylist methods to utilize stack class
		 * throws an EmptyStackException if the stack is empty
		 */
		return list.get(list.size() - 1);
	}

	/**
	 * Returns true if the stack is empty.
	 */
	@Override
	public boolean isEmpty() {
		if (list.isEmpty()) {
			return true;
		}
		return false;
	}
}
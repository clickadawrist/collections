package edu.ncsu.csc216.course_manager.utils;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * 
 * @author Manaka Green and Jerry Zhang
 *
 */
public class ArrayStack<E> implements Stack<E> {

	/** */
	private ArrayList<E> list;

	/**
	 * Creates an instance of a generic array list.
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
		if (list.isEmpty()) {
			throw new EmptyStackException();
		}
		return list.remove(list.size() - 1);
	}

	/**
	 * Returns, but does not remove, the element at the top of the stack.
	 * It is basically get.
	 * @throws EmptyStackException If the stack is empty
	 */
	@Override
	public E peek() {
		if (list.isEmpty()) {
			throw new EmptyStackException();
		}
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
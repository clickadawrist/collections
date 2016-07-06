package edu.ncsu.csc216.course_manager.utils;

import java.util.EmptyStackException;

/**
 * 
 * @author Manaka Green and Jerry Zhang
 */
public class LinkedStack<E> implements Stack<E> {

	/** */
	private LinkedList<E> list;

	/**
	 * Creates an instance of a linked list.
	 */
	public LinkedStack() {
		list = new LinkedList<E>();
	}
	
	/**
	 * Pushes the given element to the top of the stack.
	 */
	@Override
	public void push(E element) {
		
		list.add(list.size() - 1, element);
		
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
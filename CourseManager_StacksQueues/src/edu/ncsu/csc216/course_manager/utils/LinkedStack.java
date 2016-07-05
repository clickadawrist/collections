package edu.ncsu.csc216.course_manager.utils;

import java.util.ArrayList;

/**
 * 
 * @author Manaka Green and Jerry Zhang
 */
public class LinkedStack<E> implements Stack<E> {

	private LinkedList<E> list;

	/**
	 * 
	 */
	public LinkedStack() {
		list = new LinkedList<E>();
	}
	
	/**
	 * Pushes the given element to the top of the stack.
	 */
	@Override
	public void push(E element) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Removes and returns the element at the top of the stack.
	 * @throws EmptyStackException If the stack is empty
	 */
	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns, but does not remove, the element at the top of the stack.
	 * @throws EmptyStackException If the stack is empty
	 */
	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns true if the stack is empty.
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
}
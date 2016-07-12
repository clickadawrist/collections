package edu.ncsu.csc216.course_manager.utils;

/**
 * Behavior for arrayList and linkedList stack.
 * @author yijiezhang and Manaka Green
 * @param <E> Generic stack
 */
public interface Stack<E> {
	
	/**
	 * Adds element to back of lists.
	 * @param element Element to be pushed to top of stack
	 */
	public void push(E element);
	
	/**
	 * Removes element from back of lists.
	 * @return element Element popped from the top of the stack 
	 */
	public E pop();
	
	/**
	 * Looks at element at the back of lists.
	 * @return element Element at the top of the stack
	 */
	public E peek();
	
	/**
	 * True if the list is empty.
	 * @return true If stack is empty
	 */
	public boolean isEmpty();
}
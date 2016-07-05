package edu.ncsu.csc216.course_manager.utils;

/**
 * Interface that specifies the stacks' behaviors.
 * @author yijiezhang
 * @param <E>
 */
public interface Stack<E> {
	
	public void push(E element);
	
	public E pop();
	
	public E peek();
	
	public boolean isEmpty();
}

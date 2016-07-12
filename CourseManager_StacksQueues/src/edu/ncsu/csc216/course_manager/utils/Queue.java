package edu.ncsu.csc216.course_manager.utils;

/**
 * @author Manaka Green and Jerry Zhang
 *
 */
public interface Queue<E> {

	public void enqueue(E element);
	
	public E dequeue();
	
	public boolean isEmpty();

}

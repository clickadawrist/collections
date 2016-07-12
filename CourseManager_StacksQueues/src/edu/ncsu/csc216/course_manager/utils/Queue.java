package edu.ncsu.csc216.course_manager.utils;

/**
 * Behavior for arrayList and linkedList queue.
 * @author Manaka Green and Jerry Zhang
 * @param <E> Generic stack
 */
public interface Queue<E> {

	public void enqueue(E element);
	
	public E dequeue();
	
	public boolean isEmpty();

}

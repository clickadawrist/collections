package edu.ncsu.csc216.course_manager.utils;

/**
 * Behavior for arrayList and linkedList queue.
 * @author Manaka Green and Jerry Zhang
 * @param <E> Generic stack
 */
public interface Queue<E> {

	/** 
	 * Adds element to the queue
	 * @param element that was added
	 */
	public void enqueue(E element);
	
	/**
	 * Removes element from the queue.
	 * @return element that was removed
	 */
	public E dequeue();
	
	/**
	 * Checks to see if the queue is empty.
	 * @return true if queue is empty
	 */
	public boolean isEmpty();

}

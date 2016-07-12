package edu.ncsu.csc216.course_manager.utils;

import java.util.NoSuchElementException;

/**
 * Uses LinkedList as a queue.
 * @author Manaka Green and Jerry Zhang
 * @param <E>
 */
public class LinkedQueue<E> implements Queue<E> {

	/** Accesses LinkedList's methods. */
	private LinkedList<E> list;
	
	/**
	 * Creates an instance of a linked list.
	 */
	public LinkedQueue() {
		list = new LinkedList<E>();
	}

	/**
	 * Adds the given element to the end of the queue.
	 */
	@Override
	public void enqueue(E element) {
		list.add(list.size(), element);
	}

	/**
	 * Removes and returns the element at the front of the queue.
	 * @throws NoSuchElementException If the queue is empty
	 */
	@Override
	public E dequeue() {
		if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.remove(0);
	}

	/**
	 * Returns true if the queue is empty.
	 */
	@Override
	public boolean isEmpty() {
		if((list.size() == 0)) {
			return true;
		}
		return false;
	}
}
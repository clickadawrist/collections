package edu.ncsu.csc216.course_manager.utils;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * @author Manaka Green and Jerry Zhang
 *
 */
public class ArrayQueue<E> implements Queue<E> {

	private ArrayList<E> list;
	
	/**
	 * 
	 */
	public ArrayQueue() {
		list = new ArrayList<E>();
	}

	@Override
	public void enqueue(E element) {
		list.add(element);
	}

	@Override
	public E dequeue() {
		if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.remove(0);
	}

	@Override
	public boolean isEmpty() {
		return (list.size() == 0);
	}

}

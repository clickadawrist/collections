package edu.ncsu.csc216.course_manager.utils;

import java.util.ArrayList;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}

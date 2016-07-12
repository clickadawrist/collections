package edu.ncsu.csc216.course_manager.utils;

/**
 * 
 * @author Manaka Green and Jerry Zhang
 */
public class LinkedQueue<E> implements Queue<E> {

	private LinkedList<E> list;
	
	/**
	 * 
	 */
	public LinkedQueue() {
		list = new LinkedList<E>();
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

package edu.ncsu.csc216.collections;

import java.util.AbstractList;

/**
 * Implementation of a generic array list extending a generic abstract list.
 * @author Manaka Green and Jerry Zhang
 * @param <E> Generic 
 */
public class ArrayBasedList<E> extends AbstractList<E> {

	/** Array of generic type elements. */
	private E[] arrayBasedList;
	/** Size of the collection. */
	private int size;
	
	
	/**
	 * @param arrayBasedList
	 * @param size
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ArrayBasedList() {
		//super();
		arrayBasedList = (E[]) (new Object[10]);
		this.size = 0;
	}

	/**
	 * 
	 */
	@Override
	public E get(int index) {
		
		return null;
	}

	/**
	 * 
	 */
	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		 return (E) super.set(index, element);
		//return null;
	}

	/**
	 * 
	 */
	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		super.add(index, element);
	}

	/**
	 * 
	 */
	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return (E) super.remove(index);
	}

	/**
	 * Returns the size of the ArrayBasedList.
	 */
	@Override
	public int size() {
		return arrayBasedList.length;
	}
}
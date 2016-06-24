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
	/** Size (the amount) of elements in the collection. */
	private int size;
	
	
	/**
	 * Constructs the generic arrayBasedList at initial capacity of 10 elements and size 0.
	 * @param arrayBasedList Initial Array of generic elements
	 * @param size Initial size of the arrayBasedList
	 */
	@SuppressWarnings("unchecked")
	public ArrayBasedList() {
		super();//do I need this
		arrayBasedList = (E[]) (new Object[10]);
		this.size = 0;
	}

	/**
	 * Returns the element at the specified position in the array-based list.
	 * @param index Index of the element to return
	 * @return the element at the specified position in this list
	 * @throws IndexOutOfBoundsException If the index is out of range
	 */
	@Override
	public E get(int index) {
		 if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		 }
		return arrayBasedList[index];
	}

	/**
	 * Replaces the element at the specified position in this list with the specified element.
	 * @param index Index of the element to replace
	 * @param element Element to be stored at the specified position
	 * @return the element previously at the specified position
	 * @throws IndexOutOfBoundsException If the index is out of range
	 * @throws NullPointerException If the specified element is null 
	 * and this list does not permit null elements
	 */
	@Override
	public E set(int index, E element) {
		if (index < 0 || index >= size()) {	
			throw new IndexOutOfBoundsException();
		}
		
		if (arrayBasedList[index] == null) {
			throw new NullPointerException();
		}
		
		E elementBeingReplaced = arrayBasedList[index];
		//vvv sets element at specified index as the element passed in. (replacement)
		this.arrayBasedList[index] = element; 
		
		return elementBeingReplaced;
	}

	/**
	 * Inserts the specified element at the specified position in this list. 
	 * Shifts the element currently at that position (if any) and any 
	 * subsequent elements to the right (adds one to their indices).
	 * Can grow list (add element at the end of the list).
	 * @param index Index at which the specified element is to be inserted
	 * @param element Element to be inserted
	 * @throws IndexOutOfBoundsException If the index is out of range
	 * @throws NullPointerException If the specified element is null 
	 * and this list does not permit null elements
	 */
	@Override
	public void add(int index, E element) {
		//super.add(index, element); <<< probably won't need this
		if (index < 0 || index > size()) {	
			throw new IndexOutOfBoundsException();
		}
		
		if (arrayBasedList[index] == null) {
			throw new NullPointerException();
		}
		
		arrayBasedList[size] = element;
	    size++;
	}

	/**
	 * Helper method for add method.
	 */
	private void helpAdd() {
		
	}
	/**
	 * Removes the element at the specified position in this list. 
	 * Shifts any subsequent elements to the left (subtracts one from their indices). 
	 * Returns the element that was removed from the list.
	 */
	@Override
	public E remove(int index) {
		E elementBeingRemoved = arrayBasedList[index];
		
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
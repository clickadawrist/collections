package edu.ncsu.csc216.collections;

import java.util.AbstractList;
import java.util.Arrays;

/**
 * Implementation of a generic array list extending a generic abstract list.
 * @author Manaka Green and Jerry Zhang
 * @param <E> Generic 
 */
public class ArrayBasedList<E> extends AbstractList<E> {
/*
	Capacity = null placeholders in array
	Size = number of elements in array
	Length = same as capacity
	Empty = size is 0
*/	
	/** Array of generic type elements. */
	private E[] arrayBasedList;
	/** Size (the amount) of elements in the collection. */
	private int size;
	
	/**
	 * Constructs the generic arrayBasedList at initial capacity 
	 * of 10 elements and size 0.
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
		 if (index < 0 || index >= arrayBasedList.length) {
			throw new IndexOutOfBoundsException();
		 }
		return arrayBasedList[index];
	}

	/**
	 * Replaces the element at the specified position in this list with the 
	 * specified element.
	 * @param index Index of the element to replace
	 * @param element Element to be stored at the specified position
	 * @return the element previously at the specified position
	 * @throws IndexOutOfBoundsException If the index is out of range
	 * @throws NullPointerException If the specified element is null 
	 * and this list does not permit null elements
	 */
	@Override
	public E set(int index, E element) {
		//question about replacement: what if the previous element was null??
		//do we still return null?? what do we do?
		
		if (index < 0 || index >= arrayBasedList.length) {	
			throw new IndexOutOfBoundsException();
		}
		
		if (element == null) {
			throw new NullPointerException();
		}
		
		if (arrayBasedList[index] == null) {
			//You can't set/substitute null. You have to set/substitute an element.
			//Null elements would be ones beyond the scope of  
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
		ensureCapacity(size + 1);
		//index @8 example: [A, B, C, D, E, F, G, H] index 0-7, length=8 
		//index @8 added: [A, B, C, D, E, F, G, H, I] index 0-8, length=9
		if (index < 0 || index > arrayBasedList.length) {	
			//you can add at index 8 (to make list "grow")
			throw new IndexOutOfBoundsException();
		}
		
		//can't add in null element
		if (element == null) {
			throw new NullPointerException();
		}
		
		//adds element to the end of the list (capacity 10 or more)
		//before example: [A, B, C, D, E, F, G, H] index 0-7, length=8
/*		//after  example: [A, B, C, D, E, F, G, H, I]
		if(index == arrayBasedList.length) {
			arrayBasedList[size] = element;
		}*/

		//adds element to the middle of the list (capacity 10 or more)
		for (int i = size; i >= index + 1; i--) {
			arrayBasedList[i] = arrayBasedList[i - 1];
		}
		arrayBasedList[index] = element;
	    size++;
	}

	/**
	 * Helper method for add method.
	 */
	private void ensureCapacity(int capacity) {
		if (capacity > arrayBasedList.length) {
			int newCapacity = arrayBasedList.length * 2 + 1;
			if (capacity > newCapacity) {
				newCapacity = capacity;
			}
			arrayBasedList = Arrays.copyOf(arrayBasedList, newCapacity);
		}
	}
	
	/**
	 * Removes the element at the specified position in this list. 
	 * Shifts any subsequent elements to the left (subtracts one from their indices). 
	 * Returns the element that was removed from the list.
	 * @param index The index of the element to be removed
	 * @return element The element previously at the specified position
	 * @throws IndexOutOfBoundsException If the index is out of range
	 */
	@Override
	public E remove(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		E elementBeingRemoved = arrayBasedList[index];
		arrayBasedList[index] = null;
		for (int i = size - 1 ; i > index ; i--) {
			
		}
		//size--;
		return elementBeingRemoved;
	}

	/**
	 * Returns the size (amount of elements in list) of the ArrayBasedList.
	 */
	@Override
	public int size() {
		int amountOfElements = 0;
		for (int i = 0; i < arrayBasedList.length; i++) {
			amountOfElements++;
			if(arrayBasedList[i] == null)
					amountOfElements--; 
		}
		return amountOfElements;
	}
}
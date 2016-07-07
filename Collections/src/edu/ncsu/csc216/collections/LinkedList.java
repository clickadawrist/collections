/**
 * 
 */
package edu.ncsu.csc216.collections;

import java.util.AbstractSequentialList;
import java.util.ListIterator;

/**
 * 
 * @author Yijie zhang and Manaka Green
 */
public class LinkedList<E> extends AbstractSequentialList<E> {
	
	private ListNode front;
	private ListNode back;
	private int size;
	
	/**
	 * Creates a ListNode with null data that front will point to.
	 * Creates a ListNode with null data that back will point to.
	 * Sets front's next to point to back, and back's prev point to front.
	 * Initializes size to 0.
	 */
	public LinkedList() {
		this.front = new ListNode(null, null, back);
		this.back = new ListNode(null, front, null);
		this.size = 0;
	}

	
	/**
	 * Returns a list iterator over the elements in this list (in proper sequence).
	 * @param index index of first element to be returned 
	 * from the list iterator (by a call to the next method)
	 * @return a list iterator over the elements in this list (in proper sequence)
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
	 */
	@Override
	public ListIterator<E> listIterator(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return size;
	}
	
	/**
	 * 
	 * @author Manaka Green and Jerry Zhang
	 *
	 */
	private class ListNode {
		public E data;
		public ListNode prev;
		public ListNode next;
		public ListNode(E data) {
			this(data, null, null);
		}
		
		public ListNode(E data, ListNode prev, ListNode next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}
	
	/**
	 * 
	 * @author Manaka Green and Jerry Zhang
	 *
	 */
	private class LinkedListIterator implements ListIterator<E> {

		/**
		 * 
		 */
		public LinkedListIterator() {
			
		}
		
		/**
		 * 
		 * @param index
		 */
		public LinkedListIterator(int index) {
			
		}
		
		@Override
		public void add(E arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public E previous() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void set(E arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}

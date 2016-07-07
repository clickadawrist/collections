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
		// TODO Auto-generated method stub
		return 0;
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
}

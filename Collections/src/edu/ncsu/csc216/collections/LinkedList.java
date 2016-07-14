package edu.ncsu.csc216.collections;

import java.util.AbstractSequentialList;
import java.util.ListIterator;

/**
 * 
 * @author Yijie zhang and Manaka Green
 */
public class LinkedList<E> extends AbstractSequentialList<E> {
	
	/** */
	private ListNode front;
	/** */
	private ListNode back;
	/** */
	private int size;
	
	/**
	 * Creates a ListNode with null data that front will point to.
	 * Creates a ListNode with null data that back will point to.
	 * Sets front's next to point to back, and back's prev point to front.
	 * Initializes size to 0.
	 */
	public LinkedList() {
		//ListNode(data, prev, next)
		this.front = new ListNode(null, null, back);
		this.back = new ListNode(null, front, null);
		this.size = 0;
	}
	
	/**
	 * Returns a list iterator over the elements in this list (in proper sequence).
	 * @param idx Index of first element to be returned 
	 * from the list iterator (by a call to the next method)
	 * @return linkedListIterator Which is the value at the given index
	 * @throws IndexOutOfBoundsException If the index is out of range (index < 0 || index > size())
	 */
	@Override
	public ListIterator<E> listIterator(int idx) {
		LinkedListIterator linkedListIterator = new LinkedListIterator(idx);
		return linkedListIterator;
		/* Implement listIterator() to return a ListIterator<E> that will return the 
		 * value at the given index when next() is called
		 */
	}

	/**
	 * @return 
	 */
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
		/** */
		public E data;
		/** */
		public ListNode prev;
		/** */
		public ListNode next;

		/**
		 * 
		 * @param data
		 */
		public ListNode(E data) {
			this(data, null, null);
		}
		
		/**
		 * 
		 * @param data
		 * @param prev
		 * @param next
		 */
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

		//not sure what type the previous and next is supposed to be
		/** */
		private ListNode previous;
		/** */
		private ListNode next;
		/** */
		private int previousIndex;
		/** */
		private int nextIndex;
		
		/**
		 * 
		 */
		public LinkedListIterator() {
			this(0);
		}

		/**
		 * Constructs an an iterator which points to front and 2nd front node.
		 * Previous points to front, and next points to front.next.
		 * @param index Index that the iterator will return at the next call
		 */
		public LinkedListIterator(int index) {
			//front and back don't move.
			
			//throws IOOBE if index is < 0 || >= size
			if(index < 0 || index >= size) {
				throw new IndexOutOfBoundsException();
			}

			//set previous to front so that we are behind of the index of interest
			previous = front;
			//set next to previous.next so that we are in front of the index of interest
			next = previous.next;
			
			//The following loop initializes iterator to that index to improve runtime effiency
			//because there's a high chance the next get call is near that index. (b4 or after)
			for (int i = 0; i < index; i++) {
				previous = previous.next;
				next = next.next;
			}
		}

		/**
		 * Inserts the specified element into the list
		 */
		@Override
		public void add(E arg0) {
			// TODO Auto-generated method stub
			
		}

		/**
		 * Returns true if this list iterator has more elements 
		 * when traversing the list in the forward direction.
		 * @return true If there are more elements in the forward direction
		 */
		@Override
		public boolean hasNext() {
			if (next.next == null) {
				return false;
			}
			return true;
		}

		/**
		 * Returns true if this list iterator has more elements 
		 * when traversing the list in the reverse direction.
		 * @return true If there are more elements in the reverse direction
		 */
		@Override
		public boolean hasPrevious() {
			if (previous.prev == null) {
				return false;
			}
			return true;
		}

		/**
		 * Returns the next element in the list and advances the cursor position.
		 * @return element NEXT element in the list
		 */
		@Override
		public E next() {
			// throws NoSuchElementException if there are none left to examine
			return null;
		}

		/**
		 * Returns the index of the element that would be returned by a subsequent call to next().
		 * @return index Int of next index 
		 */
		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		/**
		 * Returns the previous element in the list 
		 * and moves the cursor position backwards.
		 * @return element PREVIOUS element in the list
		 */
		@Override
		public E previous() {
			// TODO Auto-generated method stub
			return null;
		}

		/**
		 * Returns the index of the element that would be 
		 * returned by a subsequent call to previous().
		 * @return index Int of previous index
		 */
		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		/**
		 * Removes from the list the last element that was returned by next() or previous().
		 */
		@Override
		public void remove() {
			// throws IllegalStateException if haven't called next() yet.
			
		}

		/**
		 * Replaces the last element returned by next() 
		 * or previous() with the specified element.
		 * @param 
		 */
		@Override
		public void set(E element) {
			// TODO Auto-generated method stub
			
		}		
	}
}
package edu.ncsu.csc216.collections;

import java.util.AbstractSequentialList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Linked List that behaves sequentially.
 * @author Yijie zhang and Manaka Green
 * @param <E> Generic linked list 
 */
public class LinkedList<E> extends AbstractSequentialList<E> {
	//Had to initialize them to node so that in the constructor
	//front can initialize back .
	/** Points to front node. */
	private ListNode front = null;
	/** Points to back node. */
	private ListNode back = null;
	/** Size of linked list. */
	private int size;
	
	/**
	 * Creates a ListNode with null data that front will point to.
	 * Creates a ListNode with null data that back will point to.
	 * Sets front's next to point to back, and back's prev point to front.
	 * Initializes size to 0.
	 */
	public LinkedList() {
		//ListNode(data, prev, next)
		front = new ListNode(null, null, back);
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
	 * Gets size of the linked list.
	 * @return size Number of elements in linked list
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Inner node class that constructs generic nodes.
	 * @author Manaka Green and Jerry Zhang
	 */
	private class ListNode {
		
		/** Generic data in a node. */
		public E data;
		/** Type list node pointer to previous node. */
		public ListNode prev;
		/** Type list node pointer to next node. */
		public ListNode next;

		/**
		 * Calls default node that has prev and next parameters.
		 * @param data Generic element in list node
		 */
		public ListNode(E data) {
			this(data, null, null);
		}
		
		/**
		 * Creates a node with a next.
		 * @param data Generic element in 
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
	 * List iterator which iterates through linked lists.
	 * @author Manaka Green and Jerry Zhang
	 */
	private class LinkedListIterator implements ListIterator<E> {

		private static final int INITIAL_FRONT = 0;
		//not sure what type the previous and next is supposed to be
		/** Points to node to the left of index of interest. */
		private ListNode previous;
		/** Points to node to the right of index of interest. */
		private ListNode next;
		/** Used to update previousIndex location. */
		private int previousIndex;
		/** Used to update nextIndex location. */
		private int nextIndex;
		/** Check whether next element was removed. */
		private boolean removeNextCheck = false;
		/** Check whether previous element was removed. */
		private boolean removePreviousCheck = false;
		/** Check whether the element was removed. */
		private boolean removeCheck = false;
		
		/**
		 * Constructor that passes 0 into parameterized constructor.
		 */
		public LinkedListIterator() {
			this(INITIAL_FRONT);
		}

		/**
		 * Constructs an an iterator which points to front and 2nd front node.
		 * Previous points to front, and next points to front.next.
		 * @param index Index that the iterator will return at the next call
		 */
		public LinkedListIterator(int index) {
			//front and back don't move.
			
			//throws IOOBE if index is < 0 || >= size
			if(index < 0 || index > size()) {
				//changed from size to size()
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
		 * Inserts the specified element into the list before 
		 * the element that would be returned by next().
		 * @throws IllegalArgumentException If element is null
		 */
		@Override
		public void add(E element) {
			if (element == null) {
				throw new IllegalArgumentException();
			}
			
			ListNode newNode = new ListNode(element, previous, previous.next);
			previous.next = newNode;
			next.prev = newNode;
			size++;
			previousIndex++;
			nextIndex++;
			removeCheck = false;
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
		 * @throws NoSuchElementException When next has null data
		 */
		@Override
		public E next() {
			// throws NoSuchElementException if there are none left to examine
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			//move forward one
			next = next.next;
			//advances cursor position
			nextIndex++;
			previousIndex++;
			removeNextCheck = true;
			removePreviousCheck = false;
			//return value at new next
			return next.prev.data;
		}

		/**
		 * Returns the index of the element that would be returned by a subsequent call to next().
		 * @return index Int of next index 
		 */
		@Override
		public int nextIndex() {
			return nextIndex;
		}

		/**
		 * Returns the previous element in the list 
		 * and moves the cursor position backwards.
		 * @return element PREVIOUS element in the list
		 * @throws
		 */
		@Override
		public E previous() {
		// throws NoSuchElementException if there are none left to examine
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}
			//move back one
			previous = previous.prev;
			//moves cursor position back
			nextIndex--;
			previousIndex--;
			removeNextCheck = false;
			removePreviousCheck = true;
			//return value at new previous
			return previous.next.data;
		}

		/**
		 * Returns the index of the element that would be 
		 * returned by a subsequent call to previous().
		 * @return index Int of previous index
		 */
		@Override
		public int previousIndex() {
			return previousIndex;
		}

		/**
		 * Removes from the list the last element that was returned by next() or previous().
		 */
		@Override
		public void remove() {
			// throws IllegalStateException if haven't called next() yet.
			if (next() == null || previous() == null) {
				throw new IllegalStateException();
			}
			if(!removeCheck) {
				throw new IllegalArgumentException();
			}
			ListNode relevantNext = previous.next;
			removeCheck = false;
			previous = previous.prev;
			previous.next = relevantNext;
			previousIndex--;
			nextIndex--;
			size--;
		}

		/**
		 * Replaces the last element returned by next() 
		 * or previous() with the specified element.
		 * @param element Generic element
		 * @throws IllegalArgumentException If the element is null
		 */
		@Override
		public void set(E element) {
			if (element == null) {
				throw new IllegalArgumentException();
			}
			
			if (!removeNextCheck && !removePreviousCheck) {
				throw new IllegalArgumentException();
			}
			previous.next.data = element;
		}		
	}
}
package edu.ncsu.csc216.collections;

/**
 * A linkedlist behaves recursively.
 * @author Manaka Green and Jerry Zhang
 */
public class LinkedListRecursive<E> {

	/** A reference to the front of the list. */
	private ListNode front;
	/** The amount of elements in the list. */
	private int size;
	
	/**
	 * Constructs a recursive linked list.
	 */
	public LinkedListRecursive() {
		front = new ListNode(null);
		size = 0;
	}
	
	/**
	 * Returns the element at the specified position in this list.
	 * @param index index of the element
	 * @return the element at the specified position in this list.
	 */
	public E get(int index) {
		return null;
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Replaces the element at the specified position in this list with the specified element.
	 * @param index index of the element
	 * @param element the element will be replaced
	 * @return the element at the specified position in this list with the specified element.
	 */
	public E set(int index, E element) {
		return element;
		// TODO Auto-generated method stub
		
	}
		
	/**
	 * Inserts the specified element at the specified position in this list.
	 * @param index index of the element
	 * @param element The element that will be inserted.
	 */
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Removes the element at the specified position in this list.
	 * @param index index of the element
	 * @return element that was removed
	 */
	public E remove(int index) {
		return null;
		// TODO Auto-generated method stub
		
	}

	/**
	 * Returns the number of elements in this list.
	 * @return size The number of elements in the list
	 */
	public int size() {
	//Rely on the size field and don't implement recursively.		
		return size;
	}
	
	/**
	 * Returns true if the linked list is empty.
	 * @return true If the list is empty
	 */
	public boolean isEmpty() {
	//Rely on the size field and don't implement recursively.
		if (size() == 0) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * Inner node class that constructs generic nodes.
	 * @author Manaka Green and Jerry Zhang
	 */
	private class ListNode {
		/** Generic data in a node. */
		public E data;
		/** Type list node pointer to next node. */
		public ListNode next;
		/**
		 * Constructs a node.
		 * @param data A generic data
		 */
		public ListNode(E data) {
			this(data, null);
		}
		/**
		 * Constructs a node with reference.
		 * @param data Generic data
		 * @param next Reference to next generic node
		 */
		public ListNode(E data, ListNode next) {
			this.data = data;
			this.next = next;
		}
	}
}

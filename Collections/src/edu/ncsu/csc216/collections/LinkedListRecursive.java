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
	 * @param index Index of the element
	 * @return element At the specified position in this list.
	 */
	public E get(int index) {
		return null;
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Replaces the element at the specified position in this list with the specified element.
	 * @param index Index of the element
	 * @param element The element will be replaced
	 * @return element At the specified position in this list with the specified element
	 */
	public E set(int index, E element) {
		return element;
		// TODO Auto-generated method stub
		
	}
		
	/**
	 * Inserts the specified element at the specified position in this list.
	 * @param index Index of the element
	 * @param element The element that will be inserted
	 */
	public void add(int index, E element) {
		ListNode current = front;

		if (element == null) {
			throw new NullPointerException();
		}
		
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		
		//insert in empty list
		if (front == null) {
			//create a new node and attach it at the front of the list
			front = new ListNode(element);
		}
		//insert at front of non-empty list
		else if (index == 0) {
			front = new ListNode(element, front);
		}
		//insert at end of non-empty list
		else if (index == size()) {
			while (current.next != null) {
				current = current.next;
			}
			current.next = new ListNode(element);
		}
		//insert in middle of non-empty list
		else {
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			current.next = new ListNode(element, current.next);
		}
		size++;
	}

	/**
	 * Removes the element at the specified position in this list.
	 * @param index Index of the element
	 * @return element The element that was removed
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

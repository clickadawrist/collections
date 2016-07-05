package edu.ncsu.csc216.collections;

import java.util.AbstractList;

/**
 * Implementation of a generic linked list 
 * extending a generic abstract list.
 * @author yijiezhang and Manaka Green
 * @param <E> generic 
 */
public class LinkedList<E> extends AbstractList<E> {
	/** List node in the linked list always points to the front */
	private Node front;
	/** The number of nodes in the linked list */
	private int size;
	/**
	 * Constructor of an empty list.
	 */
	public LinkedList() {
		front = null;
		size = 0;
	}
	/**
	 * Gets generic data at index.
	 * @throws IndexOutOfBoundsException if data is null or index is out of bounds
	 * @see java.util.AbstractList#get(int)
	 */
	@Override
	public E get(int index) {
		Node current = front;
//changed from index > size() to index >= size()				
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		if (index == size()) {
			throw new IndexOutOfBoundsException();
		}	
		if (index == 0) {
				return current.data;
		} else {
			for (int i = 0; i < index; i++) {
				current = current.next;
				if (current.data == null) {
					throw new IndexOutOfBoundsException();		
				}
			}
		}
		return current.data;
	}

	/** (non-Javadoc)
	 * @see java.util.AbstractList#set(int, java.lang.Object)
	 */
	@Override
	public E set(int index, E element) {
		if (element == null) {
			throw new NullPointerException();
		}
		
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}

		
		//set in empty list
		//supposed to throw IOOBE right?
		if (front == null) {
			throw new IndexOutOfBoundsException();
			//front = new Node(element);
		}
		//insert at front of non-empty list
		else if (index == 0) {
			front = new Node(element, front);
		}
		//insert at end of non-empty list
		else if (index == size()) {
		//	while (current.next != null) {
		//		current = current.next;
			}
		//	current.next = new Node(element);
		//}
		//insert in middle of non-empty list
		//else {
		//	for (int i = 0; i < index - 1; i++) {
		//		current = current.next;
		//	}
		//	current.next = new Node(element, current.next);
		//}
		return element;
	}

	/** (non-Javadoc)
	 * @see java.util.AbstractList#add(int, java.lang.Object)
	 * @throws NullPointerException if the specified element is null and this list does not permit null elements
	 * @throws IllegalArgumentException if some property of the specified element prevents it from being added to this list
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
	 */
	@Override
	public void add(int index, E element) {
		Node current = front;
		if (element == null) {
			throw new NullPointerException();
		}
		
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		
		//"throws IllegalArgumentException if some property of the specified element prevents it from being added to this list"
//////////^^I don't know exactly what to do there
		
		//insert in empty list
		if (front == null) {
			//create a new node and attach it at the front of the list
			front = new Node(element);
		}
		//insert at front of non-empty list
		else if (index == 0) {
			front = new Node(element, front);
		}
		//insert at end of non-empty list
		else if (index == size()) {
			while (current.next != null) {
				current = current.next;
			}
			current.next = new Node(element);
		}
		//insert in middle of non-empty list
		else {
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			current.next = new Node(element, current.next);
		}
		size++;
	}

	/** (non-Javadoc)
	 * @see java.util.AbstractList#remove(int)
	 */
	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		E removedElement = null;
		if (index == 0) {
			removedElement = front.data;
			front = front.next;
		}else {
			Node current = front;
			for(int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			removedElement = current.next.data;
			current.next = current.next.next;
		}
		size--;
		return removedElement;
	}
	/**
	 * Returns size of the linked list.
	 */
	@Override
	public int size() {
		return size;
	}
	
	/**
	 * A node for linked list.
	 * @author yijiezhang and Manaka Green
	 * @param <E> Generic
	 */
	private class Node {
		
		/** Generic data type of a node */
		public E data;
	    
		/** Generic reference to the next node */
		public Node next;
		
		/**
		 * Constructs a node.
		 * @param d generic data
		 */
	    public Node(E d) {
	        data = d;
	        next = null;
	    }
	    
	    /**
	     * Constructs a node with reference.
	     * @param d generic data
	     * @param n reference to next generic node
	     */
	    public Node(E d, Node n) {
	        data = d;
	        next = n;
	    }
	}
}

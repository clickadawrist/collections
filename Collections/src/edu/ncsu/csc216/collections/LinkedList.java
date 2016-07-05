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
				
		if (index < 0 || index > size()) {
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

	/* (non-Javadoc)
	 * @see java.util.AbstractList#set(int, java.lang.Object)
	 */
	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return super.set(index, element);
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractList#add(int, java.lang.Object)
	 */
	@Override
	public void add(int index, E element) {
		Node current = front;
////definitely not finished
		
		//insert in empty list
		if (front == null) {
			//create a new node and attach it as the front of the list
			front = new Node(element, front);
		}
		//insert at front of non-empty list
		else if (index == 0) {
			current = new Node(element, current.next);
			
			current = current.next;
			
		}
		//insert at end of non-empty list
		else if (index == (size() - 1)) {
			while(current.next.data != element) {
				current = current.next;
			}
			current.next = new Node(element, current.next);
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

	/* (non-Javadoc)
	 * @see java.util.AbstractList#remove(int)
	 */
	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return super.remove(index);
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

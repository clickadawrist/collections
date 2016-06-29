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
	/* (non-Javadoc)
	 * @see java.util.AbstractList#get(int)
	 */
	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		super.add(index, element);
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
/*		Node current = front;
		while(current != null) {
			current = current.next;
			size++;
		}*/
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

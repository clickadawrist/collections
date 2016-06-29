/**
 * 
 */
package edu.ncsu.csc216.collections;

import java.util.AbstractList;

/**
 * @author yijiezhang
 *
 */
public class LinkedList<E> extends AbstractList<E> {
	private class Node<E> {
		private E data;
	    private Node<E> next;

	    public Node(E d) {
	        data = d;
	        next = null;
	    }
	    public Node(E d, Node<E> n) {
	        data = d;
	        next = n;
	    }
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

	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#size()
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
}

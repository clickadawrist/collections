package edu.ncsu.csc216.collections;

/**
 * A linkedlist behaves recursively.
 * @author Manaka Green and Jerry Zhang
 * @param <E> Generic list 
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
	 * Inserts the specified element at the end of this list.
	 * This method handles the special case of adding a node to an empty list. 
	 * If the list is not empty, then this method transfers the flow of control
	 * to the private ListNode.add(E element) method, which completes the recursion 
	 * to add the element to the end of the list.
	 * @param element The element that will be inserted
	 * @return true If element is added to the list
	 */
	public boolean add(E element) {
		//looked at lecture notes...
		if (element == null) {
			throw new NullPointerException();
		}
		
		//insert in empty list
		if (front == null) {
			//create a new node and attach it at the front of the list
			front = new ListNode(element);
			size++;
			return true;
		}
		//insert in nonempty list
		if (!(front == null)) {
			front.add(element);
			return true;
		}
		return false;
	}
	
	/**
	 * Inserts the specified element at the specified position in this list.
	 * @param index Index of the element
	 * @param element The element that will be inserted
	 * @return true If element is added to the index
	 */
	public boolean add(int index, E element) {
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
			size++;
			return true;
		}
		
		//insert at front of non-empty list
		if (index == 0) {
			front = new ListNode(element, front);
			size++;
			return true;
		}
		//insert at middle or end of non-empty list
		if (index > 0 || index <= size())  {
			current.add(index, element);
			return true;
		}
		return false;
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
		 * Uses recursion to add to the end of the list when next is null.
		 * @param element Generic element being added
		 */
		private void add(E element) {
			if (next == null) {
			//base case
				next = new ListNode(element);
				size++;
			} else {
			//recursive case				
				next.add(element);
			//Calling next.add() would make the next Node the current node 
			//and the add() method would be called on that node
			}
		}

		/**
		 * Uses recursion to add to the middle or end of the list.
		 * @param index Index of the element
		 * @param element Generic element being added
		 */
		private void add(int index, E element) {
			int position = 1;
			//adding to the end
			if (index == size() - 1) {
				if (next == null) {
					//base case
					next = new ListNode(element);
					size++;
				} else {
					//recursive case				
					next.add(element);
					//Calling next.add() would make the next Node the current node 
					//and the add() method would be called on that node
				}
			}
			
			//adding to the middle
			if (position == index) {
				//base case
				next = new ListNode(element, next);
				size++;
			} 
			else {
				//recursive case				
				next.add(index, element);
				position++;
				//Calling next.add() would make the next Node the current node 
				//and the add() method would be called on that node
			}			
		}
		
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
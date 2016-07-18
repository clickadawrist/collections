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
	 * @param index Index of the element to return
	 * @throws IndexOutOfBoundsException If the index is out of range 
	 * (index < 0 || index >= size())
	 * @return element At the specified position in this list.
	 */
	public E get(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		return null;
		
	}
	
	/**
	 * Replaces the element at the specified position in this list with the specified element.
	 * @param index Index of the element
	 * @param element The element will be replaced
	 * @throws NullPointerException If the specified element is null 
	 * and this list does not permit null elements
	 * @throws IndexOutOfBoundsException If the index is out of range 
	 * (index < 0 || index >= size())
	 * @return elementBeingReplaced At the specified position in this list with the specified element
	 */
	public E set(int index, E element) {
		E elementBeingReplaced = null;
		if(element == null) {
			throw new NullPointerException();
		}
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		return elementBeingReplaced;	
	}
	
	/**
	 * Inserts the specified element at the end of this list.
	 * This method handles the special case of adding a node to an empty list. 
	 * If the list is not empty, then this method transfers the flow of control
	 * to the private ListNode.add(E element) method, which completes the recursion 
	 * to add the element to the end of the list.
	 * @param element The element that will be inserted
	 * @throws NullPointerException If the specified element is null 
	 * and this list does not permit null elements
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
	 * @throws NullPointerException If the specified element is null 
	 * and this list does not permit null elements
	 * @throws IndexOutOfBoundsException If the index is out of range 
	 * (index < 0 || index > size()) 
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
	 * @throws IndexOutOfBoundsException If the index is out of range 
	 * (index < 0 || index >= size()) 
	 * @return element The element that was removed
	 */
	public E remove(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		return null;
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
	 * Returns true if this list contains the specified element. 
	 * @param element Element to search for in the list
	 * @throws NullPointerException If the specified element is null 
	 * and this list doesn't permit null elements
	 * @return true If this list contains the specified element
	 */
	public boolean contains(E element) {
		if (element == null) {
			throw new NullPointerException();
		}
		return true;
	}

	/**
	 * Returns the index of the first occurrence of the specified element in this list, 
	 * or -1 if this list does not contain the element.
	 * @param element Element to search for in the list
	 * @throws NullPointerException If the specified element is null
	 * and this list doesn't permit null elements
	 * @return location Index of the first occurrence of the specified element in this list, 
	 * or -1 if this list does not contain the element
	 */
	public int indexOf(E element) {
		if (element == null) {
			throw new NullPointerException();
		}
		int location = 0;
		return location;
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
		 * Uses recursion to get to element and remove.
		 * @param idx Index of the element
		 * @return data Generic element being removed
		 */
		private E remove(int idx) {
			return data;
			
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
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

	private int position; 

	/**
	 * Constructs a recursive linked list.
	 */
	public LinkedListRecursive() {
		front = new ListNode(null);
		size = 0;
		position = 0; 
	}

	/**
	 * Returns the element at the specified position in this list.
	 * @param index Index of the element to return
	 * @throws IndexOutOfBoundsException If the index is out of range 
	 * (index < 0 || index >= size())
	 * @return element At the specified position in this list
	 */
	public E get(int index) {
		//ListNode current = front;
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {
			return front.data;
		} else {
			return front.get(index);
		}
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
		ListNode current = front;
		if(element == null) {
			throw new NullPointerException();
		}
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
        if (index == 0) {
        	E oldElement = front.data;
        	front.data = element;
        	return oldElement;
        } else {
        	//return front.next.set(index - 1, element);
        	return current.next.set(index - 1, element);
        }
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
		if (isEmpty()) {
			//create a new node and attach it at the front of the list
			front = new ListNode(element);
			size++;
			return true;
		}
		//insert in nonempty list
		if (!isEmpty()) {
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
		if (isEmpty()) {
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
        if(index < 0 || index >= size) {
        	throw new IndexOutOfBoundsException();
        }
        if(index == 0) {
        	E previousElement = front.data;
        	front = front.next;
        	size--;
        	return previousElement;
        } else if(index == 1) {
        	E previousElement = front.next.data;
        	front.next = front.next.next;
        	size--;
        	return previousElement;
        	
        } else {
        	return front.next.remove(index - 1);
        }
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
			return true;
		}
		return false;
	}
	
/*	*//**
	 * Returns true if this list contains the specified element. 
	 * @param element Element to search for in the list
	 * @throws NullPointerException If the specified element is null 
	 * and this list doesn't permit null elements
	 * @return true If this list contains the specified element
	 *//*
	public boolean contains(E element) {
		if (element == null) {
			throw new NullPointerException();
		}
		
		return true;
	}*/

/*	*//**
	 * Returns the index of the first occurrence of the specified element in this list, 
	 * or -1 if this list does not contain the element.
	 * @param element Element to search for in the list
	 * @throws NullPointerException If the specified element is null
	 * and this list doesn't permit null elements
	 * @return location Index of the first occurrence of the specified element in this list, 
	 * or -1 if this list does not contain the element
	 *//*
	public int indexOf(E element) {
		if (element == null) {
			throw new NullPointerException();
		}
		int location = 0;
		return location;
	}*/
	
	/**
	 * Inner node class that constructs generic nodes.
	 * @author Manaka Green and Jerry Zhang
	 */
	private class ListNode {
		/** Generic data in a node. */
		public E data;
		/** Type list node pointer to next node. */
		public ListNode next;
				

		
		private int addPosition() {
			return position++;
		}
		
		
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
			//adding to the end (make list grow)
			if (index == size()) {
				//changed from size() - 1 to size()
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
			else if (position == index - 1) {
				//base case
				next = new ListNode(element, next);
				size++;
			} 
			else {
				//recursive case
				addPosition();
				next.add(index, element);
				//Calling next.add() would make the next Node the current node 
				//and the add() method would be called on that node
			}			
		}
		
		/**
		 * Gets an element at an index.
		 * @param index Index of the element
		 * @return data Data in the ListNode
		 */
		private E get(int index) {			
			if (index == 0) {
				//base case: when index = 0
				//(which was checked in the outer public get method)
				return data;
				
			}
			//recursive case
			return next.get(index - 1);
			//go to the base case which is at index = 0,
			//which was checked in the outer public get method
			//and returned front.data
	    }

		/**
		 * Uses recursion to get to element and remove.
		 * @param idx Index of the element
		 * @return data Generic element being removed
		 */
		private E remove(int idx) {
    		if(idx == 1) {
    			E previousElement = next.data;
    			next = next.next;
    			size--;
    			return previousElement;
    		} else {
    			return next.remove(idx - 1);
    		}
    	}

		/**
		 * Sets an element at an index.
		 * @param index Index of the element
		 * @param element The element at the index
		 * @return data The data previously in the ListNode
		 */
		private E set(int index, E element) {
			//base case
            if (index == 0) {
                E previousElement = data;
                data = element;
                return previousElement;
            } else {
            	//go to the base which is at index 0
                return next.set(index - 1, element);
            }
        }
		
		/**
		 * Constructs a node.
		 * @param data A generic data
		 */
		public ListNode(E d) {
			this(d, null);
		}

		/**
		 * Constructs a node with reference.
		 * @param data Generic data
		 * @param next Reference to next generic node
		 */
		public ListNode(E d, ListNode n) {
			data = d;
			next = n;
		}
	}
}
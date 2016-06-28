package edu.ncsu.csc216.collections;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests ArrayBasedList class.
 * 
 * @author SarahHeckman and Manaka Green and Jerry Zhang
 */
public class ArrayBasedListTest {

	/** ArrayBasedList named list for testing methods. */
	private ArrayBasedList<String> list;

	/**
	 * Sets up variables for testing ArrayBasedList class.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		list = new ArrayBasedList<String>();
	}

	/**
	 * Tests that a ArrayBasedList is constructed correctly. An ArrayBasedList
	 * of any generic type can have null elements, but user cannot insert null
	 * elements. Initially constructed ArrayBasedList will have a size of 10
	 * null elements, or capacity for 10 elements.
	 */
	@Test
	public void testArrayBasedList() {
		// Test that the list is created correctly.
		try {
			list.remove(11);
			list.get(11);
			fail("Didn't catch IndexOutOfBoundsException.");
		} catch (IndexOutOfBoundsException e) {
			assertEquals(0, list.size());
			for (int index = list.size(); index - 1 >= 0; index--) {
				assertEquals(null, list.get(index));
			}
		}

		// Try to set an element as null. Shouldn't work at all.//
		try {
			list.set(0, null);
			fail("Didn't catch NullPointerException.");
		} catch (NullPointerException e) {
			assertEquals(0, list.size());
			// All elements should be null initially.
		}
	}

	/**
	 * Tests adding elements to an empty ArrayBasedList. Then tests adding
	 * elements to the front, middle, and back of a ArrayBasedList. The size and
	 * contents should be checked after each insertion. Additionally, the bounds
	 * of the list should be checked and null elements should not be added to
	 * the list. Finally, test that the ArrayList with an initial capacity of 10
	 * grows when an 11th element is added.
	 */
	@Test
	public void testAdd() {
		// Attempt to add an element to index out of bounds.
		// Check that the element was not added.
		try {
			list.add(11, "A");
			fail("Didn't catch the IndexOutOfBoundsException.");
		} catch (IndexOutOfBoundsException e) {
			assertEquals(0, list.size());
		}

		// Add element to end of list list.add(0, "A"); list.add(1, "B");
		list.add(0, "A");
		list.add(1, "B");
		list.add(2, "C");
		list.add(3, "D");
		list.add(4, "E");
		list.add(5, "F");
		list.add(6, "G");
		list.add(7, "H");
		assertEquals(8, list.size());
		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));
		assertEquals("D", list.get(3));
		assertEquals("E", list.get(4));
		assertEquals("F", list.get(5));
		assertEquals("G", list.get(6));
		assertEquals("H", list.get(7));
		assertEquals(null, list.get(8));
		assertEquals(null, list.get(9));

		// Add element to the front of a list
		list.add(0, "front");
		assertEquals("front", list.get(0));
		assertEquals("A", list.get(1));
		assertEquals("B", list.get(2));
		assertEquals("C", list.get(3));
		assertEquals("D", list.get(4));
		assertEquals("E", list.get(5));
		assertEquals("F", list.get(6));
		assertEquals("G", list.get(7));
		assertEquals("H", list.get(8));
		assertEquals(null, list.get(9));

		// Add element to the middle of a list
		list.add(4, "middle");
		assertEquals("front", list.get(0));
		assertEquals("A", list.get(1));
		assertEquals("B", list.get(2));
		assertEquals("C", list.get(3));
		assertEquals("middle", list.get(4));
		assertEquals("D", list.get(5));
		assertEquals("E", list.get(6));
		assertEquals("F", list.get(7));
		assertEquals("G", list.get(8));
		assertEquals("H", list.get(9));
		assertEquals(10, list.size());

		// Add element to the back of a list
		list.add(10, "back");
		assertEquals("front", list.get(0));
		assertEquals("A", list.get(1));
		assertEquals("B", list.get(2));
		assertEquals("C", list.get(3));
		assertEquals("middle", list.get(4));
		assertEquals("D", list.get(5));
		assertEquals("E", list.get(6));
		assertEquals("F", list.get(7));
		assertEquals("G", list.get(8));
		assertEquals("H", list.get(9));
		assertEquals("back", list.get(10));
		assertEquals(11, list.size());

	}

	/**
	 * Tests that elements are correctly removed from the front, middle, and
	 * back of an ArrayList. Removing the last element should leave an empty
	 * list. The bounds are checked for the appropriate exceptions.
	 */
	@Test
	public void testRemove() {
		// Attempt to remove an element from an list of capacity 10 with null
		// elements
		try {
			list.remove(-1);
			fail("Didn't catch IndexOutOfBoundsException.");
		} catch (IndexOutOfBoundsException e) {
			assertEquals(0, list.size());
		}

		// Now add 10 elements
		list.add(0, "A");
		list.add(1, "B");
		list.add(2, "C");
		list.add(3, "D");
		list.add(4, "E");
		list.add(5, "F");
		list.add(6, "G");
		list.add(7, "H");
		list.add(8, "I");
		list.add(9, "J");

		// Test that IndexOutOfBoundsException is thrown when remove() is passed
		// a negative index. Make sure the list is unchanged.
		try {
			list.remove(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(10, list.size());
			assertEquals("A", list.get(0));
			assertEquals("B", list.get(1));
			assertEquals("C", list.get(2));
			assertEquals("D", list.get(3));
			assertEquals("E", list.get(4));
			assertEquals("F", list.get(5));
			assertEquals("G", list.get(6));
			assertEquals("H", list.get(7));
			assertEquals("I", list.get(8));
			assertEquals("J", list.get(9));
		}

		// Test that IndexOutOfBoundsException is thrown when remove() is passed
		// an index > size() - 1. Make sure the list is unchanged.
		try {
			list.remove(list.size());
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(10, list.size());
			assertEquals("A", list.get(0));
			assertEquals("B", list.get(1));
			assertEquals("C", list.get(2));
			assertEquals("D", list.get(3));
			assertEquals("E", list.get(4));
			assertEquals("F", list.get(5));
			assertEquals("G", list.get(6));
			assertEquals("H", list.get(7));
			assertEquals("I", list.get(8));
			assertEquals("J", list.get(9));
		}

		// remove the font element
		list.remove(0);
		assertEquals("B", list.get(0));
		assertEquals("C", list.get(1));
		assertEquals("D", list.get(2));
		assertEquals("E", list.get(3));
		assertEquals("F", list.get(4));
		assertEquals("G", list.get(5));
		assertEquals("H", list.get(6));
		assertEquals("I", list.get(7));
		assertEquals("J", list.get(8));
		assertEquals(null, list.get(9));

		// remove the middle element
		list.add(0, "A");
		list.remove(4);
		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));
		assertEquals("D", list.get(3));
		assertEquals("F", list.get(4));
		assertEquals("G", list.get(5));
		assertEquals("H", list.get(6));
		assertEquals("I", list.get(7));
		assertEquals("J", list.get(8));
		assertEquals(null, list.get(9));

		// remove the back element
		list.add(4, "E");
		list.remove(9);
		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));
		assertEquals("D", list.get(3));
		assertEquals("E", list.get(4));
		assertEquals("F", list.get(5));
		assertEquals("G", list.get(6));
		assertEquals("H", list.get(7));
		assertEquals("I", list.get(8));
		assertEquals(null, list.get(9));

	}

	/**
	 * Tests setting an element in an empty list, the bounds of the list when
	 * using the set() method, and setting an element at the front, middle, and
	 * back of the list.
	 */
	@Test
	public void testSet() {
		// Try to set an element as null. Shouldn't work at all.
		try {
			list.set(0, null);
			fail("Didn't catch NullPointerException.");
		} catch (NullPointerException e) {
			assertEquals(0, list.size());
			// All elements should be null initially. }
		}

		// Attempt to set an element out of bounds
		try {
			list.set(11, "asparagus");
		} catch (IndexOutOfBoundsException e) {
			assertEquals(0, list.size());
		}

		// Add 10 elements to the list and test that the contents are correct.
		// Reuse code from your testAdd.
		list.add(0, "A");
		list.add(1, "B");
		list.add(2, "C");
		list.add(3, "D");
		list.add(4, "E");
		list.add(5, "F");
		list.add(6, "G");
		list.add(7, "H");
		list.add(8, "I");
		list.add(9, "J");
		assertEquals(10, list.size());

		// Test that IndexOutOfBoundsException is thrown when set() is passed
		// anegative index. Make sure the list is unchanged.
		try {
			list.set(-1, "broccoli");
		} catch (IndexOutOfBoundsException e) {
			assertEquals(10, list.size());
			assertEquals("A", list.get(0));
			assertEquals("B", list.get(1));
			assertEquals("C", list.get(2));
			assertEquals("D", list.get(3));
			assertEquals("E", list.get(4));
			assertEquals("F", list.get(5));
			assertEquals("G", list.get(6));
			assertEquals("H", list.get(7));
			assertEquals("I", list.get(8));
			assertEquals("J", list.get(9));
		}

		// Set the first element
		list.set(0, "front");
		assertEquals(10, list.size());
		assertEquals("front", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));
		assertEquals("D", list.get(3));
		assertEquals("E", list.get(4));
		assertEquals("F", list.get(5));
		assertEquals("G", list.get(6));
		assertEquals("H", list.get(7));
		assertEquals("I", list.get(8));
		assertEquals("J", list.get(9));

		// set the middle element
		list.set(4, "middle");
		assertEquals("front", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));
		assertEquals("D", list.get(3));
		assertEquals("middle", list.get(4));
		assertEquals("F", list.get(5));
		assertEquals("G", list.get(6));
		assertEquals("H", list.get(7));
		assertEquals("I", list.get(8));
		assertEquals("J", list.get(9));

		// set the last element
		list.set(9, "back");
		assertEquals("front", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));
		assertEquals("D", list.get(3));
		assertEquals("middle", list.get(4));
		assertEquals("F", list.get(5));
		assertEquals("G", list.get(6));
		assertEquals("H", list.get(7));
		assertEquals("I", list.get(8));
		assertEquals("back", list.get(9));
	}

	/**
	 * Main get() functionality is tested in the other test methods. This method
	 * will focus on testing the exceptions associated with bounds.
	 */
	@Test
	// testGetInt()
	public void testGet() {
		// Add 8 elements to the list and test that the contents are correct.
		// Reuse code from your testAdd.
		list.add(0, "A");
		list.add(1, "B");
		list.add(2, "C");
		list.add(3, "D");
		list.add(4, "E");
		list.add(5, "F");
		list.add(6, "G");
		list.add(7, "H");

		assertEquals(8, list.size());
		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));
		assertEquals("D", list.get(3));
		assertEquals("E", list.get(4));
		assertEquals("F", list.get(5));
		assertEquals("G", list.get(6));
		assertEquals("H", list.get(7));
		assertEquals(null, list.get(8));
		assertEquals(null, list.get(9));

		// Test that IndexOutOfBoundsException is thrown when get() is passed
		// a negative index. Make sure the list is unchanged.
		try {
			list.get(-1);
			fail("Didn't catch IndexOutOfBoundsException.");
		} catch (IndexOutOfBoundsException e) {
			assertEquals(8, list.size());
			assertEquals("A", list.get(0));
			assertEquals("B", list.get(1));
			assertEquals("C", list.get(2));
			assertEquals("D", list.get(3));
			assertEquals("E", list.get(4));
			assertEquals("F", list.get(5));
			assertEquals("G", list.get(6));
			assertEquals("H", list.get(7));
			assertEquals(null, list.get(8));
			assertEquals(null, list.get(9));
		}

		// Test that IndexOutOfBoundsException is thrown when get() is passed
		// an index > length - 1. Make sure the list is unchanged.
		// index > length - 1 in this case would be: index > 9
		// You can set at index = 9 but not above it b/c that
		// would be out of bounds. (highest index being @ 9)
		try {
			list.get(10);
		} catch (IndexOutOfBoundsException e) {
			assertEquals(8, list.size());
			assertEquals("A", list.get(0));
			assertEquals("B", list.get(1));
			assertEquals("C", list.get(2));
			assertEquals("D", list.get(3));
			assertEquals("E", list.get(4));
			assertEquals("F", list.get(5));
			assertEquals("G", list.get(6));
			assertEquals("H", list.get(7));
			assertEquals(null, list.get(8));
			assertEquals(null, list.get(9));
		}

		// return a null?!
		try {
			list.get(9);
		} catch (IndexOutOfBoundsException e) {
			assertEquals(8, list.size());
			assertEquals("A", list.get(0));
			assertEquals("B", list.get(1));
			assertEquals("C", list.get(2));
			assertEquals("D", list.get(3));
			assertEquals("E", list.get(4));
			assertEquals("F", list.get(5));
			assertEquals("G", list.get(6));
			assertEquals("H", list.get(7));
			assertEquals(null, list.get(8));
			assertEquals(null, list.get(9));
		}
	}

	/**
	 * Method for testing the ArrayBasedList class with the object type Integer,
	 * instead of String
	 */
	@Test
	public void testIntegerArrayBasedList() {
		// Create an empty ArryaBasedList of Integers
		ArrayBasedList<Integer> intList = new ArrayBasedList<Integer>();
		assertEquals(null, intList.get(0));
		assertEquals(null, intList.get(1));
		assertEquals(null, intList.get(2));
		assertEquals(null, intList.get(3));
		assertEquals(null, intList.get(4));
		assertEquals(null, intList.get(5));
		assertEquals(null, intList.get(6));
		assertEquals(null, intList.get(7));
		assertEquals(null, intList.get(8));
		assertEquals(null, intList.get(9));

		// Add 5 number to the list
		intList.add(0, 1);
		intList.add(1, 2);
		intList.add(2, 3);
		intList.add(3, 4);
		intList.add(4, 5);
		assertEquals((Integer) 1, intList.get(0));
		assertEquals((Integer) 2, intList.get(1));
		assertEquals((Integer) 3, intList.get(2));
		assertEquals((Integer) 4, intList.get(3));
		assertEquals((Integer) 5, intList.get(4));

		// Remove the middle number (index 2)
		intList.remove(2);
		assertEquals((Integer) 1, intList.get(0));
		assertEquals((Integer) 2, intList.get(1));
		assertEquals((Integer) 4, intList.get(2));
		assertEquals((Integer) 5, intList.get(3));
		assertEquals(null, intList.get(4));

		// Add 2 more numbers
		intList.add(4, 6);
		intList.add(5, 7);
		assertEquals((Integer) 1, intList.get(0));
		assertEquals((Integer) 2, intList.get(1));
		assertEquals((Integer) 4, intList.get(2));
		assertEquals((Integer) 5, intList.get(3));
		assertEquals((Integer) 6, intList.get(4));
		assertEquals((Integer) 7, intList.get(5));

		// Remove the first number
		intList.remove(0);
		assertEquals((Integer) 2, intList.get(0));
		assertEquals((Integer) 4, intList.get(1));
		assertEquals((Integer) 5, intList.get(2));
		assertEquals((Integer) 6, intList.get(3));
		assertEquals((Integer) 7, intList.get(4));

		// Add a number (index 3)
		intList.add(3, 100);
		assertEquals((Integer) 2, intList.get(0));
		assertEquals((Integer) 4, intList.get(1));
		assertEquals((Integer) 5, intList.get(2));
		assertEquals((Integer) 100, intList.get(3));
		assertEquals((Integer) 6, intList.get(4));
		assertEquals((Integer) 7, intList.get(5));

		// Remove the last number
		intList.remove(intList.size() - 1);
		assertEquals((Integer) 2, intList.get(0));
		assertEquals((Integer) 4, intList.get(1));
		assertEquals((Integer) 5, intList.get(2));
		assertEquals((Integer) 100, intList.get(3));
		assertEquals((Integer) 6, intList.get(4));
		assertEquals(null, intList.get(5));

		// Add a number (index 2)
		intList.add(2, 101);
		assertEquals((Integer) 2, intList.get(0));
		assertEquals((Integer) 4, intList.get(1));
		assertEquals((Integer) 101, intList.get(2));
		assertEquals((Integer) 5, intList.get(3));
		assertEquals((Integer) 100, intList.get(4));
		assertEquals((Integer) 6, intList.get(5));

		// Remove the second number
		intList.remove(1);
		assertEquals((Integer) 2, intList.get(0));
		assertEquals((Integer) 101, intList.get(1));
		assertEquals((Integer) 5, intList.get(2));
		assertEquals((Integer) 100, intList.get(3));
		assertEquals((Integer) 6, intList.get(4));
		assertEquals(null, intList.get(5));

		// Remove the remaining number in the list
		intList.remove(0);
		intList.remove(0);
		intList.remove(0);
		intList.remove(0);
		intList.remove(0);

		assertEquals(null, intList.get(0));
		assertEquals(null, intList.get(1));
		assertEquals(null, intList.get(2));
		assertEquals(null, intList.get(3));
		assertEquals(null, intList.get(4));
		assertEquals(null, intList.get(5));
		assertEquals(null, intList.get(6));
		assertEquals(null, intList.get(7));
		assertEquals(null, intList.get(8));
		assertEquals(null, intList.get(9));
	}
}

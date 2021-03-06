package edu.ncsu.csc216.collections;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import edu.ncsu.csc216.collections.LinkedListAL;

/**
 * Tests LinkedListAL class.
 * @author SarahHeckman and Manaka Green and Jerry Zhang
 */
public class LinkedListALTest {
	
	/** LinkedListAL named list for testing methods. */
	private LinkedListAL<String> list;
	
	/**
	 * Sets up variables for testing LinkedListAL class.
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		list = new LinkedListAL<String>();
	}

	/**
	 * Tests that a LinkedListAL is constructed correctly.  A LinkedListAL of
	 * any generic type should be not null and empty, which implies a size of 0.
	 */
	@Test
	public void testLinkedList() {
		//Test that the list is created correctly.
		try {
			list.get(0);
			list.remove(0);
			list.set(0, "fruit");
			fail("Didn't catch IndexOutOfBoundsException.");
		} catch (IndexOutOfBoundsException e) {
			assertEquals(0, list.size());
			assertNotNull(list);
		}
		
		try {
			list.set(0, null);
			fail("Didn't catch NullPointerException.");
		} catch (NullPointerException e) {
			assertEquals(0, list.size());
			assertNotNull(list);
		}
	}

	/**
	 * Tests adding elements to an empty LinkedListAL.  Then tests adding elements to the 
	 * front, middle, and back of a LinkedListAL.  The size and contents should be checked
	 * after each insertion.  Additionally, the bounds of the list should be checked and null
	 * elements should not be added to the list.  Finally, test that the LinkedList with an
	 * initial capacity of 10 grows when an 11th element is added.
	 */
	@Test
	public void testAddIntE() {
		//Attempt to add an element to index 1 in an empty list.
		//Check that the element was not added.
		try {
			list.add(1, "apple");
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(0, list.size());
		}
		
		//Add element to empty list
		list.add(0, "apple");
		assertEquals(1, list.size());
		assertEquals("apple", list.get(0));
		
		//Add element to the front of a list
		list.add(0, "banana");
		assertEquals(2, list.size());
		assertEquals("banana", list.get(0));
		//**just to make sure apple is still there...
		assertEquals("apple", list.get(1));
		
		//Add element to the middle of a list
		list.add(list.size() / 2, "cherry");
		//**^ the division symbol cuts off anything past the decimal point (I think)
		assertEquals(3, list.size());
		assertEquals("cherry", list.get(1));
		
		//Add element to the back of a list
		//**currently the list is size 3, last index at 2.
		//**vv index @ 3 dragonfruit; meaning list.size() = 4th element is dragonfruit
		list.add(list.size(), "dragonfruit");
		assertEquals(4, list.size());
		assertEquals("dragonfruit", list.get(3));
		
		//Attempt to add a null element.  Check that the element
		//was not added.
		try {
			list.add(0, null);
			fail();
		} catch (NullPointerException e) {
			assertEquals(4, list.size());
			assertNotNull(list.get(0));
		}
		
		//Attempt to add at index -1.  Check that the element was not
		//added.
		try {
			list.add(-1, "durian");
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(4, list.size());
			assertEquals("banana", list.get(0));
		}
		
		//Attempt to add at index 5 (since there are 4 elements in the list).
		//Check that the element was not added.
		try {
			list.add(5, "eggfruit");
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(4, list.size());
			assertEquals("dragonfruit", list.get(3));
		}
		
		//Test adding an 11th element to an LinkedList with an initial 
		//capacity of 10.
		list.add(list.size(), "elderberry");
		list.add(list.size(), "fig");
		list.add(list.size(), "grape");
		list.add(list.size(), "huckleberry");
		list.add(list.size(), "itapalmfruit");
		list.add(list.size(), "jujube");
		list.add(list.size(), "kiwi");
		assertEquals(11, list.size());
		assertEquals("kiwi", list.get(10));
	}

	/**
	 * Tests that elements are correctly removed from the front, middle, and back of an 
	 * LinkedList.  Removing the last element should leave an empty list.  The bounds are
	 * checked for the appropriate exceptions.
	 */
	@Test
	public void testRemoveInt() {
		//Attempt to remove an element from an empty list
		try {
			list.remove(0);
			fail("Didn't catch IndexOutOfBoundsException.");
		} catch (IndexOutOfBoundsException e) {
			assertEquals(0, list.size());
		}
		
		//Add 4 elements to the list and test that the contents are correct.
		//"Reuse code from your testAddIntE."
		list.add(0, "banana");
		list.add(1, "cherry");
		list.add(2, "apple");
		list.add(3, "dragonfruit");
		assertEquals(4, list.size());
		assertEquals("banana", list.get(0));
		assertEquals("cherry", list.get(1));
		assertEquals("apple", list.get(2));
		assertEquals("dragonfruit", list.get(3));
		
		//Test that IndexOutOfBoundsException is thrown when remove() is passed
		//a negative index.  Make sure the list is unchanged.
		try {
			list.remove(-1);
			fail();
		} catch (IndexOutOfBoundsException e){
			assertEquals(4, list.size());
			assertEquals("banana", list.get(0));
			assertEquals("cherry", list.get(1));
			assertEquals("apple", list.get(2));
			assertEquals("dragonfruit", list.get(3));
		}
		
		//Test that IndexOutOfBoundsException is thrown when remove() is passed
		//an index > size() - 1.  Make sure the list is unchanged.
		try {
			list.remove(list.size());
			fail();
		} catch (IndexOutOfBoundsException e){
			assertEquals(4, list.size());
			assertEquals("banana", list.get(0));
			assertEquals("cherry", list.get(1));
			assertEquals("apple", list.get(2));
			assertEquals("dragonfruit", list.get(3));
		}
		
		//Remove middle element.  Test that the removed element is correct and
		//that the remaining list is correct after the removal.
		String s1 = list.remove(list.size() / 2);
		assertEquals("apple", s1);
		assertEquals(3, list.size());
		assertEquals("banana", list.get(0));
		assertEquals("cherry", list.get(1));
		assertEquals("dragonfruit", list.get(2));
				
		//Remove first element
		String s2 = list.remove(0);
		assertEquals("banana", s2);
		assertEquals(2, list.size());
		assertEquals("cherry", list.get(0));
		assertEquals("dragonfruit", list.get(1));
		
		//Remove last element
		String s3 = list.remove(list.size() - 1);
		assertEquals("dragonfruit", s3);
		assertEquals(1, list.size());
		assertEquals("cherry", list.get(0));
		
		//Remove only element
		String s4 = list.remove(0);
		assertEquals("cherry", s4);
		assertEquals(0, list.size());		
	}

	/**
	 * Tests setting an element in an empty list, the bounds of the list when
	 * using the set() method, and setting an element at the front, middle, and back
	 * of the list.  The set() method is also passed null.
	 */
	@Test
	public void testSetIntE() {
		//Attempt to set a value in an empty list
		try {
			list.set(0, "asparagus");
		} catch(IndexOutOfBoundsException e) {
			assertEquals(0, list.size());
		}
		
		//Add 4 elements to the list and test that the contents are correct.
		//"Reuse code from your testAddIntE."
		list.add(0, "banana");
		list.add(1, "cherry");
		list.add(2, "apple");
		list.add(3, "dragonfruit");
		assertEquals(4, list.size());
		assertEquals("banana", list.get(0));
		assertEquals("cherry", list.get(1));
		assertEquals("apple", list.get(2));
		assertEquals("dragonfruit", list.get(3));
		
		//Test that IndexOutOfBoundsException is thrown when set() is passed
		//a negative index.  Make sure the list is unchanged.
		try {
			list.set(-1, "broccoli");
		} catch (IndexOutOfBoundsException e) {
			assertEquals(4, list.size()); 
			assertEquals("banana", list.get(0));
			assertEquals("cherry", list.get(1));
			assertEquals("apple", list.get(2));
			assertEquals("dragonfruit", list.get(3));
		}
		
		//Test that IndexOutOfBoundsException is thrown when set() is passed
		//an index > size() - 1.  Make sure the list is unchanged.
		try {
			list.set(list.size(), "carrot");
			//index > size() - 1 in this case would be: index > 3 
			//You can set at index = 3 but not above it b/c that 
			//would be out of bounds. (highest index being @ 3)
		} catch (IndexOutOfBoundsException e) {
			assertEquals(4, list.size());
			assertEquals("banana", list.get(0));
			assertEquals("cherry", list.get(1));
			assertEquals("apple", list.get(2));
			assertEquals("dragonfruit", list.get(3));
		}
		
		//Set middle element.  Test that the element is modified correctly, set() returns the
		//right value, and that the rest of the list is correct.
		String s1 = list.set(list.size() / 2, "strawberry");
		//^^ what is set doing...nvm
		assertEquals("apple", s1);
		assertEquals(4, list.size());
		assertEquals("banana", list.get(0));
		assertEquals("cherry", list.get(1));
		assertEquals("strawberry", list.get(2));
		assertEquals("dragonfruit", list.get(3));
		
		//Set first element
		String s2 = list.set(0, "blueberry");
		assertEquals("banana", s2);
		assertEquals(4, list.size());
		assertEquals("blueberry", list.get(0));
		assertEquals("cherry", list.get(1));
		assertEquals("strawberry", list.get(2));
		assertEquals("dragonfruit", list.get(3));
		
		//Set last element
		String s3 = list.set(list.size() - 1, "pineapple");
		assertEquals("dragonfruit", s3);
		assertEquals(4, list.size());
		assertEquals("pineapple", list.get(3));
		assertEquals("strawberry", list.get(2));
		assertEquals("cherry", list.get(1));
		assertEquals("blueberry", list.get(0));
		
		//Attempt to set an element to null.  Check that the element
		//was not modified.
		try {
			list.set(0, null);
		} catch (NullPointerException e) {
			assertEquals(4, list.size());
			assertEquals("blueberry", list.get(0));
		}
	}

	/**
	 * Main get() functionality is tested in the other test methods.  This method will
	 * focus on testing the exceptions associated with bounds.
	 */
	@Test
	public void testGetInt() {
		
		//Checking indexes out of bounds before adding to the list
		try {
			list.get(-1);
		} catch (IndexOutOfBoundsException e) {
			assertEquals(0, list.size());
		}
		
		try {
			list.get(1);
		} catch (IndexOutOfBoundsException e) {
			assertEquals(0, list.size());
		}
		

		try {
			list.get(0);
		} catch (IndexOutOfBoundsException e) {
			assertEquals(0, list.size());
		}
		
		//Add 4 elements to the list and test that the contents are correct.
		//list.add(0, "banana");
		list.add(0, "cherry");
		list.add(1, "apple");
		list.add(2, "dragonfruit");
		
		//Add element to the front of a list
		list.add(0, "banana");
		assertEquals(4, list.size());
		assertEquals("banana", list.get(0));
		
		
		//Make sure everything's in order
		assertEquals(4, list.size());
		assertEquals("banana", list.get(0));
		assertEquals("cherry", list.get(1));
		assertEquals("apple", list.get(2));
		assertEquals("dragonfruit", list.get(3));	
		
		//Test that IndexOutOfBoundsException is thrown when get() is passed
		//a negative index.  Make sure the list is unchanged.
		try {
			list.get(-1);
		} catch (IndexOutOfBoundsException e) {
			assertEquals(4, list.size());
			assertEquals("banana", list.get(0));
			assertEquals("cherry", list.get(1));
			assertEquals("apple", list.get(2));
			assertEquals("dragonfruit", list.get(3));
		}
		
		//Test that IndexOutOfBoundsException is thrown when get() is passed
		//an index > size() - 1.  Make sure the list is unchanged.
		//index > size() - 1 in this case would be: index > 3 
		//You can set at index = 3 but not above it b/c that 
		//would be out of bounds. (highest index being @ 3)
		try {
			list.get(list.size());
		} catch (IndexOutOfBoundsException e) {
			assertEquals(4, list.size());
			assertEquals("banana", list.get(0));
			assertEquals("cherry", list.get(1));
			assertEquals("apple", list.get(2));
			assertEquals("dragonfruit", list.get(3));
		}
	}	
}
package edu.ncsu.csc216.collections;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests ArrayBasedList class.
 * @author SarahHeckman and Manaka Green and Jerry Zhang
 */
public class ArrayBasedListTest {
	
	/** ArrayBasedList named list for testing methods. */
	private ArrayBasedList<String> list;
	
	/**
	 * Sets up variables for testing ArrayBasedList class.
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		list = new ArrayBasedList<String>();
	}

	/**
	 * Tests that a ArrayBasedList is constructed correctly.  
	 * An ArrayBasedList of any generic type can have null elements,
	 * but user cannot insert null elements.
	 * Initially constructed ArrayBasedList will have a size of 10 null elements, 
	 * or capacity for 10 elements.
	 */
	@Test
	public void testArrayBasedList() {
		//Test that the list is created correctly.
		try {
			list.remove(11);
			list.get(11);
			fail("Didn't catch IndexOutOfBoundsException.");
		} catch (IndexOutOfBoundsException e) {
			assertEquals(0, list.size());
			for(int index = list.size() ; index - 1 >= 0 ; index--) {
				assertEquals(null, list.get(index));
			}
		}
		
		//Try to set an element as null. Shouldn't work at all.//		
		try {
			list.set(0, null);
			fail("Didn't catch NullPointerException.");
		} catch (NullPointerException e) {
			assertEquals(0, list.size());
			//All elements should be null initially.
		}	
	}

	/**
	 * Tests adding elements to an empty ArrayBasedList.  
	 * Then tests adding elements to the front, middle, and back of a ArrayBasedList.  
	 * The size and contents should be checked after each insertion.  
	 * Additionally, the bounds of the list should be checked and null elements 
	 * should not be added to the list.  
	 * Finally, test that the ArrayList with an initial capacity of 
	 * 10 grows when an 11th element is added.
	 */
	@Test
//	public void testAddIntE() {
	public void testAdd() {
		//Attempt to add an element to index out of bounds.
		//Check that the element was not added.
		try {
			list.add(11, "A");
			fail("Didn't catch the IndexOutOfBoundsException.");
		} catch (IndexOutOfBoundsException e) {
			assertEquals(0, list.size());
		}
/*		
		//Add element to end of list
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
		
		//Add element to the front of a list

		
		//Add element to the middle of a list

		
		//Add element to the back of a list
		
		
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
			list.add(-1, "Sigma");
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
		
		//Test adding an 11th element to an ArrayList with an initial 
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
*/	}

	/**
	 * Tests that elements are correctly removed from the front, middle, and back of an 
	 * ArrayList.  Removing the last element should leave an empty list.  The bounds are
	 * checked for the appropriate exceptions.
	 */
/*	@Test
	//testRemoveInt()
	public void testRemove() {
		//Attempt to remove an element from an list of capacity 10 with null elements
		try {
			list.remove(0);
			fail("Didn't catch IndexOutOfBoundsException.");
		} catch (IndexOutOfBoundsException e) {
			assertEquals(0, list.size());
		}

		
		//Add 4 elements to the list and test that the contents are correct.
		//Reuse code from your testAddIntE.
		list.add(0, "A");
		list.add(1, "B");
		list.add(2, "C");
		list.add(3, "D");
		list.add(4, "E");
		list.add(5, "F");
		list.add(6, "G");
		list.add(7, "H");
		/*assertEquals(4, list.size());
		assertEquals("banana", list.get(0));
		assertEquals("cherry", list.get(1));
		assertEquals("apple", list.get(2));
		assertEquals("dragonfruit", list.get(3));*/
		
		//Test that IndexOutOfBoundsException is thrown when remove() is passed
		//a negative index.  Make sure the list is unchanged.
		/*try {
			list.remove(-1);
			fail();
		} catch (IndexOutOfBoundsException e){
			assertEquals(4, list.size());
			assertEquals("banana", list.get(0));
			assertEquals("cherry", list.get(1));
			assertEquals("apple", list.get(2));
			assertEquals("dragonfruit", list.get(3));
		}
		*/
		//Test that IndexOutOfBoundsException is thrown when remove() is passed
		//an index > size() - 1.  Make sure the list is unchanged.
/*		try {
			list.remove(list.size());
			fail();
		} catch (IndexOutOfBoundsException e){
			assertEquals(4, list.size());
			assertEquals("banana", list.get(0));
			assertEquals("cherry", list.get(1));
			assertEquals("apple", list.get(2));
			assertEquals("dragonfruit", list.get(3));
		}*/
		
		//Remove middle element.  Test that the removed element is correct and
		//that the remaining list is correct after the removal.
/*		String s1 = list.remove(list.size() / 2);
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
		
		list.remove(4);
		System.out.println(list);
		//assertEquals(7, list.size());		
	} */

	/**
	 * Tests setting an element in an empty list, the bounds of the list when
	 * using the set() method, and setting an element at the front, middle, and back
	 * of the list.
	 */
/*	@Test
	//testSetIntE()
	public void testSet() {

		//Try to set an element as null. Shouldn't work at all.		
		try {
			list.set(0, null);
			fail("Didn't catch NullPointerException.");
		} catch (NullPointerException e) {
			assertEquals(0, list.size());
			//All elements should be null initially.
		}	
		
		//Attempt to set an element out of bounds
		try {
			list.set(11, "asparagus");
		} catch(IndexOutOfBoundsException e) {
			assertEquals(0, list.size());
		}
		


		
		//Add 8 elements to the list and test that the contents are correct.
		//Reuse code from your testAdd.
		list.add(0, "A");
		list.add(1, "B");
		list.add(2, "C");
		list.add(3, "D");
		list.add(4, "E");
		list.add(5, "F");
		list.add(6, "G");
		list.add(7, "H");		
		assertEquals(8, list.size());
		//assertEquals(list.);
*/
/*		assertEquals("cherry", list.get(1));
 * 		assertEquals("cherry", list.get(1));
		assertEquals("apple", list.get(2));
		assertEquals("dragonfruit", list.get(3));*/
		
	/*	//Test that IndexOutOfBoundsException is thrown when set() is passed
		//a negative index.  Make sure the list is unchanged.
		try {
			list.set(-1, "broccoli");
		} catch (IndexOutOfBoundsException e) {
			assertEquals(8, list.size()); 
			assertEquals("A", list.get(0));
		}
		
		//Set middle element.  Test that the element is modified correctly, set() returns the
		//right value, and that the rest of the list is correct.
		String s1 = list.set(list.size() / 2, "Letter");*/
//		assertEquals("apple", s1);
//		assertEquals(4, list.size());
//		assertEquals("banana", list.get(0));
//		assertEquals("cherry", list.get(1));
//		assertEquals("strawberry", list.get(2));
//		assertEquals("dragonfruit", list.get(3));
//		
		
		//Set first element
/*		String s2 = list.set(0, "blueberry");
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
	} */

	/**
	 * Main get() functionality is tested in the other test methods.  This method will
	 * focus on testing the exceptions associated with bounds.
	 */
	@Test
	//testGetInt()
	public void testGet() { 
		//Add 8 elements to the list and test that the contents are correct.
		//Reuse code from your testAdd.
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
		
		//Test that IndexOutOfBoundsException is thrown when get() is passed
		//a negative index.  Make sure the list is unchanged.
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
		
		//Test that IndexOutOfBoundsException is thrown when get() is passed
		//an index > length - 1.  Make sure the list is unchanged.
		//index > length - 1 in this case would be: index > 9
		//You can set at index = 9 but not above it b/c that 
		//would be out of bounds. (highest index being @ 9)
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
		
		//return a null?!
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
}

package edu.ncsu.csc216.course_manager.courses;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.course_manager.courses.Course;
import edu.ncsu.csc216.course_manager.users.Student;

/**
 * Tests for Course.  
 * @author SarahHeckman
 */
public class CourseTest {

	/**
	 * Tests the Course constructor.
	 */
	@Test
	public void testCourse() {
		//Test correct path
		Course c = new Course("CSC216", 3, 10);
		assertEquals("CSC216", c.getName());
		assertEquals(3, c.getCredits());
		assertEquals(10, c.getCapacity());
		
		//Test null name
		c = null;
		try {
			c = new Course(null, 3, 10);
			fail("A course with a null name should throw an IllegalArgumentException.");
		} catch (IllegalArgumentException e) {
			assertNull(c);
		}
		
		//Test empty string name
		c = null;
		try {
			c = new Course("", 3, 10);
			fail("A course with a null name should throw an IllegalArgumentException.");
		} catch (IllegalArgumentException e) {
			assertNull(c);
		}
		
		//Test credit min boundary
		c = null;
		try {
			c = new Course("CSC216", Course.MIN_HOURS - 1, 10);
			fail("A course with a null name should throw an IllegalArgumentException.");
		} catch (IllegalArgumentException e) {
			assertNull(c);
		}
		
		c = new Course("CSC216", Course.MIN_HOURS, 10);
		assertEquals("CSC216", c.getName());
		assertEquals(Course.MIN_HOURS, c.getCredits());
		assertEquals(10, c.getCapacity());
		
		//Test credit max boundary
		c = null;
		try {
			c = new Course("CSC216", Course.MAX_HOURS + 1, 10);
			fail("A course with a null name should throw an IllegalArgumentException.");
		} catch (IllegalArgumentException e) {
			assertNull(c);
		}
		
		c = new Course("CSC216", Course.MAX_HOURS, 10);
		assertEquals("CSC216", c.getName());
		assertEquals(Course.MAX_HOURS, c.getCredits());
		assertEquals(10, c.getCapacity());
		
		//Test negative capacity
		c = null;
		try {
			c = new Course("CSC216", 3, -1);
			fail("A negative capacity should throw an IllegalArgumentException.");
		} catch (IllegalArgumentException e) {
			assertNull(c);
		}	
	}
	
	/**
	 * Tests setName() after a valid course object is created.
	 */
	@Test
	public void testSetName() {
		//Test correct path
		Course c = new Course("CSC216", 3, 10);
		assertEquals("CSC216", c.getName());
		assertEquals(3, c.getCredits());
		assertEquals(10, c.getCapacity());
		
		//Set name to null
		try {
			c.setName(null);
			fail();
		} catch (IllegalArgumentException e) {
			//No changes
			assertEquals("CSC216", c.getName());
			assertEquals(3, c.getCredits());
			assertEquals(10, c.getCapacity());
		}
		
		//Set name to empty string
		try {
			c.setName("");
			fail();
		} catch (IllegalArgumentException e) {
			//No changes
			assertEquals("CSC216", c.getName());
			assertEquals(3, c.getCredits());
			assertEquals(10, c.getCapacity());
		}
		
		//Change name
		c.setName("CSC116");
		assertEquals("CSC116", c.getName());
		assertEquals(3, c.getCredits());
		assertEquals(10, c.getCapacity());
	}
	
	/**
	 * Tests setCredits() after a valid course object is created.
	 */
	@Test
	public void testSetCredits() {
		//Test correct path
		Course c = new Course("CSC216", 3, 10);
		assertEquals("CSC216", c.getName());
		assertEquals(3, c.getCredits());
		assertEquals(10, c.getCapacity());
		
		//Set credits to MIN_HOURS - 1
		try {
			c.setCredits(Course.MIN_HOURS - 1);
			fail();
		} catch (IllegalArgumentException e) {
			//No changes
			assertEquals("CSC216", c.getName());
			assertEquals(3, c.getCredits());
			assertEquals(10, c.getCapacity());
		}
		
		//Set credits to MAX_HOURS + 1
		try {
			c.setCredits(Course.MAX_HOURS + 1);
			fail();
		} catch (IllegalArgumentException e) {
			//No changes
			assertEquals("CSC216", c.getName());
			assertEquals(3, c.getCredits());
			assertEquals(10, c.getCapacity());
		}
		
		//Change credits to MIN_HOURS
		c.setCredits(Course.MIN_HOURS);
		assertEquals("CSC216", c.getName());
		assertEquals(Course.MIN_HOURS, c.getCredits());
		assertEquals(10, c.getCapacity());
		
		//Change credits to MAX_HOURS
		c.setCredits(Course.MAX_HOURS);
		assertEquals("CSC216", c.getName());
		assertEquals(Course.MAX_HOURS, c.getCredits());
		assertEquals(10, c.getCapacity());
	}
	
	/**
	 * Test setCapacity() after a valid course object is created.
	 */
	@Test
	public void testSetCapacity() {
		//Test correct path
		Course c = new Course("CSC216", 3, 10);
		assertEquals("CSC216", c.getName());
		assertEquals(3, c.getCredits());
		
		//Set capacity to 0
		try {
			c.setCapacity(0);
			fail();
		} catch (IllegalArgumentException e) {
			//No changes
			assertEquals("CSC216", c.getName());
			assertEquals(3, c.getCredits());
			assertEquals(10, c.getCapacity());
		}
	}
	
	
	/**
	 * Tests enroll().
	 */
	@Test
	public void testEnroll() {
		//Add a student to a course
		Course c = new Course("CSC216", 3, 1);
		Student s1 = new Student("first", "last", "flast", "first_last@ncsu.edu", "pw");
		assertTrue(c.enroll(s1));
		
		//Should be able to add this student to waitlist at 1st position
		//c.setCapacity(1); //does not apply for this GUI lab
		Student s2 = new Student("firstname", "last", "flast", "first_last@ncsu.edu", "pw");
		assertTrue(c.enroll(s2));
////////^^^ something is wrong here; it's adding this person 5 times
		
		//Should be able to add this student to waitlist at 2nd position
		//c.setCapacity(2); //does not apply for this GUI lab
		Student s3 = new Student("first", "lastname", "flast", "first_last@ncsu.edu", "pw");
		assertTrue(c.enroll(s3));
		
		//Should be able to add this student to waitlist at 3rd position
		Student s4 = new Student("first", "last", "flastname", "first_last@ncsu.edu", "pw");
		assertTrue(c.enroll(s4));
		
		//Should be able to add this student to waitlist at 4th position
		Student s5 = new Student("firstname", "lastname", "flast", "first_last@ncsu.edu", "pw");
		assertTrue(c.enroll(s5));
		
		//Should be able to add this student to waitlist at 5th position
		Student s6 = new Student("firstname", "lastname", "flastname", "first_last@ncsu.edu", "pw");
		assertTrue(c.enroll(s6));
		//Should be able to add this student to waitlist at 6th position
		Student s7 = new Student("fname", "last", "flast", "first_last@ncsu.edu", "pw");
		assertFalse(c.enroll(s7));
		
		//Attempt to enroll a student in the same course
		//c.setCapacity(2);
		assertFalse(c.enroll(s1));
		
		//canEnroll() is tested through enroll()
	}
	
	/**
	 * Tests drop().
	 */
	@Test
	public void testDrop() {
		//Attempt to drop a student not enrolled in the course or the waitlist - should fail (see assertFalse)
		Course c = new Course("CSC216", 3, 1);
		Student s1 = new Student("first", "last", "flast", "first_last@ncsu.edu", "pw");
		assertFalse(c.drop(s1));

		Student s2 = new Student("firstname", "lastname", "flastname", "first_last@ncsu.edu", "pw");
		
		//add one student to the course
		assertTrue(c.enroll(s1));
		assertEquals(1, c.getEnrolledStudents().length);
		
		/*//add another student to the course but that student should be waitlisted
		assertTrue(c.enroll(s2));
		assertEquals(1, c.getEnrolledStudents().length);
		*/
		c.drop(s1);
		//assertTrue(c.drop(s1));
		assertEquals(0, c.getEnrolledStudents().length);
	}
	
	/**
	 * Test hashCode and equals.
	 */
	@Test
	public void testEquals() {
		Course c1 = new Course("CSC216", 4, 10);
		Course c2 = new Course("CSC216", 4, 10);
		Course c3 = new Course("CSC216", 3, 10);
		Course c4 = new Course("CSC116", 4, 10);
		
		assertTrue(c1.equals(c2));
		assertTrue(c1.equals(c3));
		assertFalse(c1.equals(c4));
		assertTrue(c1.equals(c1));
		
		assertEquals(c1.hashCode(), c2.hashCode());
		assertEquals(c1.hashCode(), c3.hashCode());
		assertNotEquals(c1.hashCode(), c4.hashCode());
	}

}

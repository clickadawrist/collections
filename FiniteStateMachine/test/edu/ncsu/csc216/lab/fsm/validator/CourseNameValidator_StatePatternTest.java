package edu.ncsu.csc216.lab.fsm.validator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.lab.fsm.exception.InvalidFSMTransitionException;

/**
 * Tests the CourseNameValidator class
 * @author Jason King and Manaka Green and Jerry Zhang
 */
public class CourseNameValidator_StatePatternTest {

	/** Keeps track of the CourseNameValidator object */
	private Validatable validator;
	
	/**
	 * Before each test case executes,
	 * initializes the validator object to a new CourseNameValidator
	 */
	@Before
	public void setUp()
	{
		validator = new CourseNameValidator_StatePattern();
	}
	
	/**
	 * Tests the isValid method
	 * finite state machine
	 */
	@Test
	public void testIsValid()
	{	
		// STATE_INITIAL
		// Transition: Letter
		try
		{
			assertTrue(validator.isValid("C116"));
		} catch(InvalidFSMTransitionException e)
		{
			fail("STATE_INITIAL, letter: A valid course name was provided.");
		}
		
		// STATE_INITIAL
		// Transition: Digit
		try
		{
			validator.isValid("116");
			fail("STATE_INITIAL, digit: Course name cannot start with a digit.");
		} catch(InvalidFSMTransitionException e)
		{
			assertEquals("Course name must start with a letter.", e.getMessage());
		}
		
		// STATE_INITIAL
		// Transition: Symbol
		try
		{
			validator.isValid("!CSC116");
			fail("STATE_INITIAL, symbol: Course name can only contain letters and digits.");
		} catch(InvalidFSMTransitionException e)
		{
			assertEquals("Course name can only contain letters and digits.", e.getMessage());
		}
		
		
		
		
		
		//TODO create the rest of the tests for the isValid() method
		
		
		
		
		// Test valid course names
		try{
			assertTrue(validator.isValid("CSC216"));
			
			//TODO Create additional valid path tests here
		} catch(InvalidFSMTransitionException e)
		{
			fail("Valid course names were provided.");
		}
	}

}

package edu.ncsu.csc216.lab.fsm.validator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.lab.fsm.exception.InvalidFSMTransitionException;

/**
 * Tests the CourseNameValidator class
 * @author Jason King and Manaka Green and Jerry Zhang
 */
public class CourseNameValidatorTest {

	/** Keeps track of the CourseNameValidator object */
	private Validatable validator;
	
	/**
	 * Before each test case executes,
	 * initializes the validator object to a new CourseNameValidator
	 */
	@Before
	public void setUp()
	{
		validator = new CourseNameValidator();
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
		
		// STATE_L
		// Transition: Letter
		try
		{
			assertTrue(validator.isValid("MA141"));
		} catch(InvalidFSMTransitionException e)
		{
			fail("STATE_L, letter: A valid course name was provided.");
		}
		
		// STATE_L
		// Transition: Digit
		try
		{
			assertTrue(validator.isValid("MA141"));
		} catch(InvalidFSMTransitionException e)
		{
			fail("STATE_L, letter: A valid course name was provided.");
		}
		
		// STATE_L
		// Transition: Symbol
		try
		{
			validator.isValid("M!A141");
			fail("STATE_L, symbol: Course name can only contain letters and digits.");
		} catch(InvalidFSMTransitionException e)
		{
			assertEquals("Course name can only contain letters and digits.", e.getMessage());
		}
		
		// STATE_LL
		// Transition: Letter
		try
		{
			assertTrue(validator.isValid("MA141"));
		} catch(InvalidFSMTransitionException e)
		{
			fail("STATE_LL, letter: A valid course name was provided.");
		}
		
		// STATE_LL
		// Transition: Digit
		try
		{
			assertTrue(validator.isValid("MA141"));
		} catch(InvalidFSMTransitionException e)
		{
			fail("STATE_LL, letter: A valid course name was provided.");
		}
		
		// STATE_LL
		// Transition: Symbol
		try
		{
			validator.isValid("M!A141");
			fail("STATE_LL, symbol: Course name can only contain letters and digits.");
		} catch(InvalidFSMTransitionException e)
		{
			assertEquals("Course name can only contain letters and digits.", e.getMessage());
		}
		
		// STATE_LLL
		// Transition: Letter
		try
		{
			validator.isValid("MA14L");
			fail("STATE_LLL, letter: Course name must have 3 digits.");
		} catch(InvalidFSMTransitionException e)
		{
			assertEquals("Course name must have 3 digits.", e.getMessage());
		}
		
		// STATE_LLL
		// Transition: Digit
		try
		{
			assertTrue(validator.isValid("MA141"));
		} catch(InvalidFSMTransitionException e)
		{
			fail("STATE_LLL, letter: A valid course name was provided.");
		}
		
		// STATE_LLL
		// Transition: Symbol
		try
		{
			validator.isValid("M!A141");
			fail("STATE_LLL, symbol: Course name can only contain letters and digits.");
		} catch(InvalidFSMTransitionException e)
		{
			assertEquals("Course name can only contain letters and digits.", e.getMessage());
		}
		
		
		// STATE_D
		// Transition: Letter
		try
		{
			validator.isValid("MAS14");
			fail("STATE_D, letter: Course name must have 3 digits.");
		} catch(InvalidFSMTransitionException e)
		{
			assertEquals("Course name must have 3 digits.", e.getMessage());
		}
		
		// STATE_D
		// Transition: Digit
		try
		{
			assertTrue(validator.isValid("MA141"));
		} catch(InvalidFSMTransitionException e)
		{
			fail("STATE_D, letter: A valid course name was provided.");
		}
		
		// STATE_D
		// Transition: Symbol
		try
		{
			validator.isValid("M!A141");
			fail("STATE_D, symbol: Course name can only contain letters and digits.");
		} catch(InvalidFSMTransitionException e)
		{
			assertEquals("Course name can only contain letters and digits.", e.getMessage());
		}
		
		// STATE_DD
		// Transition: Letter
		try
		{
			validator.isValid("MAS14");
			fail("STATE_DD, letter: Course name must have 3 digits.");
		} catch(InvalidFSMTransitionException e)
		{
			assertEquals("Course name must have 3 digits.", e.getMessage());
		}
		
		// STATE_DD
		// Transition: Digit
		try
		{
			assertTrue(validator.isValid("MA141"));
		} catch(InvalidFSMTransitionException e)
		{
			fail("STATE_DD, letter: A valid course name was provided.");
		}
		
		// STATE_DD
		// Transition: Symbol
		try
		{
			validator.isValid("M!A141");
			fail("STATE_DD, symbol: Course name can only contain letters and digits.");
		} catch(InvalidFSMTransitionException e)
		{
			assertEquals("Course name can only contain letters and digits.", e.getMessage());
		}
		
		// STATE_DDD
		// Transition: Letter
		try
		{
			assertTrue(validator.isValid("MA141S"));
		} catch(InvalidFSMTransitionException e)
		{
			fail("STATE_DDD, letter: A valid course name was provided.");
		}
		
		// STATE_DDD
		// Transition: Digit
		try
		{
			validator.isValid("MA1412");
			fail("STATE_DDD, digit: Course name can only have 3 digits.");
		} catch(InvalidFSMTransitionException e)
		{
			assertEquals("Course name can only have 3 digits.", e.getMessage());
		}
		
		// STATE_DDD
		// Transition: Symbol
		try
		{
			validator.isValid("M!A141");
			fail("STATE_DDD, symbol: Course name can only contain letters and digits.");
		} catch(InvalidFSMTransitionException e)
		{
			assertEquals("Course name can only contain letters and digits.", e.getMessage());
		}
		
		// STATE_SUFFIX
		// Transition: Letter
		try
		{
			validator.isValid("MA141SL");
			fail("STATE_SUFFIX, letter: Course name can only have a 1 letter suffix.");
		} catch(InvalidFSMTransitionException e)
		{
			assertEquals("Course name can only have a 1 letter suffix.", e.getMessage());
		
		
		// STATE_SUFFIX
		// Transition: Digit
		try
		{
			validator.isValid("MA141S2");
			fail("STATE_SUFFIX, digit: Course name cannot contain digits after the suffix.");
		} catch(InvalidFSMTransitionException e1)
		{
			assertEquals("Course name cannot contain digits after the suffix.", e.getMessage());
		}
		
		// STATE_SUFFIX
		// Transition: Symbol
		try
		{
			validator.isValid("M!A141");
			fail("STATE_SUFFIX, symbol: Course name can only contain letters and digits.");
		} catch(InvalidFSMTransitionException e1)
		{
			assertEquals("Course name can only contain letters and digits.", e.getMessage());
		}
		
		
		
		
		// Test valid course names
		try{
			assertTrue(validator.isValid("CSC216"));
			
		
		} catch(InvalidFSMTransitionException e1)
		{
			fail("Valid course names were provided.");
		}
	}
}
}


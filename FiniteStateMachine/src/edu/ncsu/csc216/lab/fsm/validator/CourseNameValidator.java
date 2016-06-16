package edu.ncsu.csc216.lab.fsm.validator;

import edu.ncsu.csc216.lab.fsm.exception.InvalidFSMTransitionException;

/**
 * Finite State Machine for checking whether
 * a Course Name is valid
 * 
 * @author Jason King
 */
public class CourseNameValidator implements Validatable {

	/** Initial state before input is examined */
	private final int stateINITIAL = 0;
	
	/** State at which one letter has been identified */
	private final int stateL = 1;
	
	/** State at which two letters have been identified */
	private final int stateLL = 2;
	
	/** State at which three letters have been identified */
	private final int stateLLL = 3;
	
	/** State at which one digit has been identified */
	private final int stateD = 4;
	
	/** State at which two digits have been identified */
	private final int stateDD = 5;
	
	/** State at which three digits have been identified */
	private final int stateDDD = 6;
	
	/** State at which a suffix letter has been identified */
	private final int stateSUFFIX = 7;
	
	/** The state variable keeps track of the current FSM state we are in */
	private int state;
	
	/** This variable tracks whether the input string is in a valid final/end state */
	private boolean validEndState;
	
	/**
	 * Returns true if the course name is valid, based on
	 * a string matching Finite State Machine.
	 * 
	 * The course name must match the following format:
	 *      (1-3 letters)(3 digits)(optionally, a 1 letter suffix)
	 *      
	 * @param courseName the name of the course
	 * @return true if the course name is valid, or false if the course name is invalid
	 * @throws InvalidFSMTransitionException when the FSM attempts an invalid transition
	 */
	public boolean isValid(String courseName) throws InvalidFSMTransitionException
	{
		// Set the state field to be the initial FSM state
		state = stateINITIAL;
		
		// Create a variable to track the current character index
		int charIndex = 0;
		
		// Variable to keep track of the current input character being examined
		char c;
		
		// Boolean variable to keep track of whether the course name is valid or not
		validEndState = false;
		
		// Iterate through the ID, examining one character at a time
		while(charIndex < courseName.length())
		{
			// Set the current character being examined
			c = courseName.charAt(charIndex);
			
			// Throw an exception if the string contains non alphanumeric characters
			if(!Character.isLetter(c) && !Character.isDigit(c))
			{
				throw new InvalidFSMTransitionException("Course name can only contain letters and digits.");
			}
			
			// Use a switch statement for the current state
			switch(state)
			{
				case stateINITIAL:
					if(Character.isLetter(c))
					{
						state = stateL;
					}
					else if(Character.isDigit(c))
					{
						throw new InvalidFSMTransitionException("Course name must start with a letter.");
					}
					break;
				
				case stateL:
					if(Character.isLetter(c))
					{
						state = stateLL;
					}
					else if (Character.isDigit(c))
					{
						state = stateD;
					}
					break;
					
				case stateLL:
					if(Character.isLetter(c))
					{
						state = stateLLL;
					}
					else if (Character.isDigit(c))
					{
						state = stateD;
					}
					break;
					
				case stateLLL:
					if(Character.isLetter(c))
					{
						throw new InvalidFSMTransitionException("Course name cannot start with more than 3 letters.");
					}
					else if (Character.isDigit(c))
					{
						state = stateD;
					}
					break;
					
				case stateD:
					if(Character.isLetter(c))
					{
						throw new InvalidFSMTransitionException("Course name must have 3 digits.");
					}
					else if (Character.isDigit(c))
					{
						state = stateDD;
					}
					break;
					
				case stateDD:
					if(Character.isLetter(c))
					{
						throw new InvalidFSMTransitionException("Course name must have 3 digits.");
					}
					else if (Character.isDigit(c))
					{
						state = stateDDD;
						validEndState = true;
					}
					break;
					
				case stateDDD:
					if(Character.isLetter(c))
					{
						state = stateSUFFIX;
						validEndState = true;
					}
					else if (Character.isDigit(c))
					{
						throw new InvalidFSMTransitionException("Course name can only have 3 digits.");
					}
					break;
					
				case stateSUFFIX:
					if(Character.isLetter(c))
					{
						throw new InvalidFSMTransitionException("Course name can only have a 1 letter suffix.");
					}
					else if (Character.isDigit(c))
					{
						throw new InvalidFSMTransitionException("Course name cannot contain digits after the suffix.");
					}
					break;
				
				default:
					return false;
			}
			
			charIndex++;

		}
		
		return validEndState;	
	}

}

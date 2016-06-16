package edu.ncsu.csc216.lab.fsm.validator;

import edu.ncsu.csc216.lab.fsm.exception.InvalidFSMTransitionException;
import edu.ncsu.csc216.lab.fsm.state.State;

/**
 * Finite State Machine for checking whether
 * a Course Name is valid.
 * @author Manaka Green and Jerry Zhang
 */
public class CourseNameValidator_StatePattern implements Validatable {

	/** Initial state before input is examined */
	private final State stateINITIAL = new StateInitial();
	
	/** State at which one letter has been identified */
	private final State stateL = new StateL();
	
	/** State at which two letters have been identified */
	private final State stateLL = new StateLL();
	
	/** State at which three letters have been identified */
	private final State stateLLL = new StateLLL();
	
	/** State at which one digit has been identified */
	private final State stateD = new StateD();
	
	/** State at which two digits have been identified */
	private final State stateDD = new StateDD();
	
	/** State at which three digits have been identified */
	private final State stateDDD = new StateDDD();
	
	/** State at which a suffix letter has been identified */
	private final State stateSUFFIX = new StateSuffix();
	
	/** The state variable keeps track of the current FSM state we are in */
	private State state;
	
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
	@Override
	public boolean isValid(String courseName) throws InvalidFSMTransitionException {
		// Set the state field to be the initial FSM state
			state = stateINITIAL;
			
		// Create a variable to track the current character index
		int charIndex = 0;
		
		// Variable to keep track of the current input character being examined
		char c;
		
		// Boolean variable to keep track of whether the course name is valid or not
		validEndState = false;

		while(charIndex < courseName.length())	{
			// Set the current character being examined
			c = courseName.charAt(charIndex++);

				if(Character.isLetter(c)) {
					state.onLetter();
				}
				else if (Character.isDigit(c)) {
					state.onDigit();
				}
				else { 
					state.onOther();
					//throw new InvalidFSMTransitionException("Course name must start with a letter.");
				}
			}				
		return validEndState;
	}

	/**
	 * Implementation of initial state.
	 * @author Manaka Green
	 */
	private class StateInitial implements State {

		@Override
		public void onLetter() {
			state = stateL;
		}
		
		@Override
		public void onDigit() throws InvalidFSMTransitionException {
			throw new InvalidFSMTransitionException("Course name must start with a letter");	
		}

		@Override
		public void onOther() throws InvalidFSMTransitionException {
			throw new InvalidFSMTransitionException("Course name can only contain letters and digits.");
		}
		
	}
	
	/**
	 * Implementation of first letter state.
	 * @author Manaka Green	 
	 * */
	private class StateL implements State {

		@Override
		public void onLetter() {
			state = stateLL;
			
		}

		@Override
		public void onDigit() {
			state = stateD;
			
		}

		@Override
		public void onOther() throws InvalidFSMTransitionException {
			throw new InvalidFSMTransitionException("Course name can only contain letters and digits.");
			
		}
		
	}

	/**
	 * Implementation of second letter state.
	 * @author Manaka Green
	 */
	private class StateLL implements State {

		@Override
		public void onLetter() {
			state = stateLLL;
			
		}

		@Override
		public void onDigit() {
			state = stateD;
			
		}

		@Override
		public void onOther() throws InvalidFSMTransitionException {
			throw new InvalidFSMTransitionException("Course name can only contain letters and digits.");
		}
		
	}

	/**
	 * Implementation of third letter state.
	 * @author Manaka Green
	 */
	private class StateLLL implements State {

		@Override
		public void onLetter() throws InvalidFSMTransitionException {
			throw new InvalidFSMTransitionException("Course name must have 3 digits.");
			
		}

		@Override
		public void onDigit() {
			state = stateD;
			
		}

		@Override
		public void onOther() throws InvalidFSMTransitionException {
			throw new InvalidFSMTransitionException("Course name can only contain letters and digits.");
			
		}
	}
	
	/**
	 * Implementation of first digit state.
	 * @author Manaka Green
	 */
	private class StateD implements State {

		@Override
		public void onLetter() throws InvalidFSMTransitionException {
			throw new InvalidFSMTransitionException("Course name must have 3 digits.");
			
		}

		@Override
		public void onDigit() {
			state = stateDD;
			
		}

		@Override
		public void onOther() throws InvalidFSMTransitionException {
			throw new InvalidFSMTransitionException("Course name can only contain letters and digits.");
		}
		
	}
	
	/**
	 * Implementation of second digit state.
	 * @author Manaka Green
	 */
	private class StateDD implements State {

		@Override
		public void onLetter() throws InvalidFSMTransitionException {
			throw new InvalidFSMTransitionException("Course name must have 3 digits.");			
		}

		@Override
		public void onDigit() {
			state = stateDDD;
			validEndState = true;
		}

		@Override
		public void onOther() throws InvalidFSMTransitionException {
			throw new InvalidFSMTransitionException("Course name can only contain letters and digits.");
			
		}
		
	}
	
	/**
	 * Implementation of third digit state.
	 * @author Manaka Green
	 */
	private class StateDDD implements State {

		@Override
		public void onLetter() {
			state = stateSUFFIX;
			validEndState = true;
		}

		@Override
		public void onDigit() throws InvalidFSMTransitionException {
			throw new InvalidFSMTransitionException("Course name can only have 3 digits.");
			
		}

		@Override
		public void onOther() throws InvalidFSMTransitionException {
			throw new InvalidFSMTransitionException("Course name can only contain letters and digits.");
			
		}
		
	}
	
	/**
	 * Implementation of suffix state.
	 * @author Manaka Green
	 */
	private class StateSuffix implements State {

		@Override
		public void onLetter() throws InvalidFSMTransitionException {
			throw new InvalidFSMTransitionException("Course name can only have a 1 letter suffix.");
			
		}

		@Override
		public void onDigit() throws InvalidFSMTransitionException {
			throw new InvalidFSMTransitionException("Course name cannot contain digits after the suffix.");
			
		}

		@Override
		public void onOther() throws InvalidFSMTransitionException {
			// Throw an exception if the string contains non alphanumeric characters
			/*if(!Character.isLetter(c) && !Character.isDigit(c))
			{*/
			throw new InvalidFSMTransitionException("Course name can only contain letters and digits.");
			/*}*/	
		}		
	}
}
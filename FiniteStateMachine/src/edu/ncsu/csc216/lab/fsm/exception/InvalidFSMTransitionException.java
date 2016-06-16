package edu.ncsu.csc216.lab.fsm.exception;

/**
 * Custom exception for invalid FSM Transitions
 * @author Manaka Green and Jerry Zhang
 */
public class InvalidFSMTransitionException extends Exception {

	/**
	 * Declares a static final serialVersionUID field of type long.
	 * (Gets rid of Eclipse warning)
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Overrides exception's message.
	 */
	public InvalidFSMTransitionException() {
		super("Invalid FSM Transition");
	}
	
	/**
	 * Passes in exception's message.
	 * @param message Exception's message
	 */
	public InvalidFSMTransitionException(String message) {
		super(message);
	}
}

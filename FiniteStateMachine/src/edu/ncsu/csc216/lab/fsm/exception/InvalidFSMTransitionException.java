package edu.ncsu.csc216.lab.fsm.exception;

public class InvalidFSMTransitionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public InvalidFSMTransitionException() {
		super("Invalid FSM Transition");
	}
	public InvalidFSMTransitionException(String s) {
		super(s);
	}
}

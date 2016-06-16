package edu.ncsu.csc216.lab.fsm.state;

import edu.ncsu.csc216.lab.fsm.exception.InvalidFSMTransitionException;

/**
 * Interface specifying the behaviors of courses.
 * @author Manaka Green and Jerry Zhang
 */
public interface State {
	
	/** Transition for letter input. */
	void onLetter() throws InvalidFSMTransitionException;
	
	/** Transition for digit input. */
	void onDigit() throws InvalidFSMTransitionException;
	
	/** Transition for other input. */
	void onOther() throws InvalidFSMTransitionException;
}

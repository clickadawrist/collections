package edu.ncsu.csc216.lab.fsm.exception;

import org.junit.Test;

import static org.junit.Assert.*;

public class InvalidFSMTransitionExceptionTest {
	@Test
	public void testInvalidFSMTransitionException() {
		try {
			throw new InvalidFSMTransitionException("Invalid FSM Transition");
		}catch (InvalidFSMTransitionException e){
			assertTrue(e instanceof InvalidFSMTransitionException);
			assertEquals("Invalid FSM Transition", e.getMessage());
		}
	}
}

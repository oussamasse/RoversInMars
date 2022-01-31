package com.oussama.exceptions;

public class MoveRoverException extends RuntimeException{
	public MoveRoverException() {
		super("Rover can't move");
	}
}

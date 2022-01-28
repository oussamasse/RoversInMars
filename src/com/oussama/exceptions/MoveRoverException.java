package com.oussama.exceptions;

public class MoveRoverException extends Exception{
	public MoveRoverException() {
		super("Rover can't move");
	}
}

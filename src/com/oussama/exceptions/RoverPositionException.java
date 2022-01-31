package com.oussama.exceptions;

public class RoverPositionException extends RuntimeException{
	public RoverPositionException() {
		super("Position is out of bound!");
	}
}

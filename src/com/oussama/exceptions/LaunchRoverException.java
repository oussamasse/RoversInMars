package com.oussama.exceptions;

public class LaunchRoverException extends RuntimeException{
	public LaunchRoverException() {
		super("Can't launch Rover, position already occupied!");
	}
}

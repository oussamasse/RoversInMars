package com.oussama.exceptions;

public class LaunchRoverException extends Exception{
	public LaunchRoverException() {
		super("Can't launch Rover, position already occupied!");
	}
}

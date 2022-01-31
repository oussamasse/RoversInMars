package com.oussama.exceptions;

public class RoverDirectionException extends RuntimeException {
	public RoverDirectionException(char value) {
		super("Bad direction " + value + "! Known directions : E,W,N,S");
	}
}

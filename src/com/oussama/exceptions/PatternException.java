package com.oussama.exceptions;

public class PatternException extends Exception{
	public PatternException(String errorCode) {
		super("Bad Pattern! " + errorCode);
	}
}

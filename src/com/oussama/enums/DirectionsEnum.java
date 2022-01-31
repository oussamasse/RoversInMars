package com.oussama.enums;

import com.oussama.exceptions.RoverDirectionException;

public enum DirectionsEnum {
    WEST('W'),
    NORTH('N'),
    EAST('E'),
    SOUTH('S');
	
	public final char direction;
	
	private DirectionsEnum(char direction) {
		this.direction = direction;
	}
	
	public static DirectionsEnum getEnumFromValue(char value) {
		for (DirectionsEnum direc : DirectionsEnum.values()) {
            if (direc.direction == value) {
                return direc;
            }
        }
		throw new RoverDirectionException(value);
	}
}
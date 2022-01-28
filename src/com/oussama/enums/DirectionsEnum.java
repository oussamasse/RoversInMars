package com.oussama.enums;

public enum DirectionsEnum {
    WEST("W"),
    NORTH("N"),
    EAST("E"),
    SOUTH("S");
	
	public final String direction;
	
	private DirectionsEnum(String direction) {
		this.direction = direction;
	}
	
	public static DirectionsEnum getEnumFromValue(String value) {
		for (DirectionsEnum direc : DirectionsEnum.values()) {
            if (direc.direction.equalsIgnoreCase(value)) {
                return direc;
            }
        }
        return null;
	}
}
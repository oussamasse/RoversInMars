package com.oussama.enums;

public enum InstructionsEnum {
	Right("R"),
	Left("L"),
	Move("M");
	
	private final String instruction;
	private InstructionsEnum(String instruction) {
		this.instruction = instruction;
	}
	
	public static InstructionsEnum getEnumFromValue(String value) {
		for (InstructionsEnum inst : InstructionsEnum.values()) {
            if (inst.instruction.equalsIgnoreCase(value)) {
                return inst;
            }
        }
        return null;
	}
}

package com.oussama.main;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.oussama.enums.DirectionsEnum;
import com.oussama.exceptions.LaunchRoverException;
import com.oussama.models.Plateau;
import com.oussama.models.Position;
import com.oussama.models.Rover;

public class MainTest {
	@Test
	public void mainTest() throws LaunchRoverException {
		Plateau plateau = new Plateau(6, 6);
    	
    	Rover rover1 = new Rover(new Position(1,2), DirectionsEnum.NORTH);
    	Rover rover2 = new Rover(new Position(3,3), DirectionsEnum.EAST);
    	
    	plateau.addRover(rover1);
    	plateau.addRover(rover2);
    	
    	rover1.launchInstructions("LMLMLMLMM");
    	rover2.launchInstructions("MMRMMRMRRM");	
		assertEquals("1 3 N", rover1.toString());
		assertEquals("5 1 E", rover2.toString());
	}
}

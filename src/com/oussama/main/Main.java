package com.oussama.main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

import com.oussama.enums.DirectionsEnum;
import com.oussama.exceptions.LaunchRoverException;
import com.oussama.exceptions.PatternException;
import com.oussama.models.Plateau;
import com.oussama.models.Position;
import com.oussama.models.Rover;

public class Main {
    public static void main(String args[]) throws Exception {
    	
    	String fileName = args[0];//"C:\\Users\\Oussama\\Desktop\\input.txt";
    	Plateau plateau = null;
		Rover currentRover = null;
		
		BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null) {
            	if(Pattern.matches("[0-9] [0-9]", line)) {
            		plateau = createPlateau(line);
    			} else if(Pattern.matches("[0-9] [0-9] [E|e|S|s|W|w|N|n]", line)) {
            		currentRover = addRoverToPlateau(plateau, line);
    			} else if(Pattern.matches("[L|l|R|r|M|m]+", line)) {
    				executeInstructions(currentRover, line);
    			} else {
    				throw new PatternException("Can't read pattern!");
    			}
                line = reader.readLine(); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
        	reader.close();
        }
    }
    
    private static void executeInstructions(Rover currentRover, String line) {
    	System.out.println("ok match instruction");
		currentRover.getInstructionsFromSequence(line);
		currentRover.launchInstructions();
		System.out.println(currentRover);
	}

	public static Plateau createPlateau(String line) {
    	System.out.println("ok plateau");
		int rowsCount = Integer.valueOf(line.split("")[0]);
		int columnsCount = Integer.valueOf(line.split("")[2]);
		return new Plateau(rowsCount+1, columnsCount+1);
    }
    
    public static Rover addRoverToPlateau(Plateau p, String line) throws LaunchRoverException {
    	System.out.println("ok match rover");
		int x = Integer.valueOf(line.split("")[0]);
		int y = Integer.valueOf(line.split("")[2]);
		DirectionsEnum direction = DirectionsEnum.getEnumFromValue(line.split("")[4]);
		Rover r = new Rover(new Position(x, y), direction);
		p.addRover(r);
		return r;
    }
}
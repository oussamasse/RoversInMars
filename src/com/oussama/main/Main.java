package com.oussama.main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

import com.oussama.enums.DirectionsEnum;
import com.oussama.exceptions.PatternException;
import com.oussama.exceptions.RoverPositionException;
import com.oussama.models.Plateau;
import com.oussama.models.Position;
import com.oussama.models.Rover;

public class Main {
	
	public static String regexPlateau = "[0-9] [0-9]";
	public static String regexRover = "[0-9] [0-9] [A-Z]";
	//E|e|S|s|W|w|N|n
	//Programme principal
    public static void main(String args[]) {
    	
    	if(args == null || args.length < 1) {
    		throw new RuntimeException("Input file doesn't exist !");
    	}
    	Plateau plateau = null;
		Rover currentRover = null;
		
        try(BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            
        	//Lecture de la 1ére ligne pour récupérer la taille du plateau
            String line = reader.readLine();
            
            //Contrôle des données du plateau
            if(!Pattern.matches(regexPlateau, line)) 
        		throw new RuntimeException("Please set correct pattern for plateau EX : 5 5");
            //Création du plateau
            plateau = createPlateau(line);
            //Lecture de la ligne suivante : rover
        	line = reader.readLine(); 
        	
            while (line != null) {
            	//Contrôle des données du rover
            	if(Pattern.matches(regexRover, line)) {
            		
            		currentRover = addRoverToPlateau(plateau, line);
            		
            		//Lecture de la ligne suivante : séquence
            		line = reader.readLine();
            		
            		//Execution des intructions
        			executeInstructions(currentRover, line);
            	} else {
    				throw new PatternException("Please set correct pattern for rover EX : 1 2 N");
    			}
            	line = reader.readLine(); 
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    //Créer le plateau
	public static Plateau createPlateau(String plateauInput) {
		int rowsCount = Integer.valueOf(plateauInput.split(" ")[0]);
		int columnsCount = Integer.valueOf(plateauInput.split(" ")[1]);
		return new Plateau(rowsCount, columnsCount);
    }
    
	//Ajouter le rover dans le plateau
    public static Rover addRoverToPlateau(Plateau plateau, String roverInput){
		int x = Integer.valueOf(roverInput.split(" ")[0]);
		int y = Integer.valueOf(roverInput.split(" ")[1]);
		DirectionsEnum direction = DirectionsEnum.getEnumFromValue(roverInput.split(" ")[2].charAt(0));
		Position position = new Position(x, y);
		if (!position.IsOnPlateau(plateau)) {
			throw new RoverPositionException();
		}
		Rover r = new Rover(position, direction);
		plateau.addRover(r);
		return r;
    }
    
    //Executer les instructions
    private static void executeInstructions(Rover currentRover, String sequenceInput) {
    	currentRover.launchInstructions(sequenceInput);
		System.out.println(currentRover);
	}
}
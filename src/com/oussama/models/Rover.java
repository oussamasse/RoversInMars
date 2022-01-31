package com.oussama.models;

import com.oussama.enums.DirectionsEnum;
import com.oussama.exceptions.PatternException;
import com.oussama.exceptions.RoverPositionException;

public class Rover {
	private Position position;
    private DirectionsEnum direction;
    private Plateau plateau;
    private String sequence;
    
    public Rover(Position position, DirectionsEnum direction) {
    	this.position = position;
    	this.direction = direction;
    }

    //Instruction au rover pour se tourner à gauche
    private void turnLeft () {
    	switch(this.direction) {
    	case NORTH:
    		this.direction = DirectionsEnum.WEST;
    		break;
    	case EAST:
    		this.direction = DirectionsEnum.NORTH;
    		break;
    	case SOUTH:
    		this.direction = DirectionsEnum.EAST;
    		break;
    	case WEST:
    		this.direction = DirectionsEnum.SOUTH;
    		break;
    	default:
    		break;
    	}
    }
    
    //Instruction au rover pour se tourner à droite
    private void turnRight() {
    	switch(this.direction) {
    	case NORTH:
    		this.direction = DirectionsEnum.EAST;
    		break;
    	case EAST:
    		this.direction = DirectionsEnum.SOUTH;
    		break;
    	case SOUTH:
    		this.direction = DirectionsEnum.WEST;
    		break;
    	case WEST:
    		this.direction = DirectionsEnum.NORTH;
    		break;
    	default:
    		break;
    	}
    }
    
    //Instruction au rover pour se déplacer
    private void move() {		
		Position newPosition = this.position.moveTo(direction);
		if (!newPosition.IsOnPlateau(plateau)) {
			throw new RoverPositionException();
		}
		position = newPosition;
	}
    
    //Executer les instructions
    public void launchInstructions(String sequence){
    	char[] instructions = sequence.toCharArray();
    	for(char inst : instructions) {
			switch (inst) {
				case 'M':
					this.move();
					break;
				case 'L':
					this.turnLeft();
					break;
				case 'R':
					this.turnRight();
					break;	
				default:
					throw new PatternException("Bad sequence instruction! Known instructions : M,L,R");
				}
    	}
    }

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public DirectionsEnum getDirection() {
		return direction;
	}

	public void setDirection(DirectionsEnum direction) {
		this.direction = direction;
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	@Override
	public String toString() {
		return position + " " + direction.direction;
	}

}

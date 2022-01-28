package com.oussama.models;

import java.util.ArrayList;
import java.util.List;

import com.oussama.enums.DirectionsEnum;
import com.oussama.enums.InstructionsEnum;
import com.oussama.exceptions.MoveRoverException;

public class Rover {
	private Position position;
    private DirectionsEnum direction;
    private Plateau plateau;
    private String sequence;

    private List<InstructionsEnum> instructions;
    
    public Rover(Position position, DirectionsEnum direction) {
    	this.position = position;
    	this.direction = direction;
    	this.instructions = new ArrayList<>();
    }

    public void getInstructionsFromSequence(String sequence) {
    	
    	String[] res = sequence.split("");
    	for(String c : res) {
    		InstructionsEnum val = InstructionsEnum.getEnumFromValue(c);
    		this.instructions.add(val);
    	}
    }
    
    private void goLeft () {
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
    
    private void goRight() {
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
    
    private void moveRoverInPlateau(Position oldPosition, Position newPosition) {
    	this.plateau.grid[oldPosition.getX()][oldPosition.getY()] = null;
		this.position.setX(newPosition.getX());
		this.position.setY(newPosition.getY());
		this.plateau.grid[newPosition.getX()][newPosition.getY()] = this;
    }
    
    private void move() throws Exception {
    	switch(this.direction) {
    	case NORTH:
    		if(this.position.getY()+1 > plateau.rowsCount) {
    			throw new MoveRoverException();
    		}
    		moveRoverInPlateau(this.position, new Position(this.position.getX(), this.position.getY()+1));
    		break;
    	case EAST:
    		if(this.position.getX()+1 > plateau.columnsCount) {
    			throw new MoveRoverException();
    		}
    		moveRoverInPlateau(this.position, new Position(this.position.getX()+1, this.position.getY()));
    		break;
    	case SOUTH:
    		if(this.position.getY()-1 < 0) {
    			throw new MoveRoverException();
    		}
    		moveRoverInPlateau(this.position, new Position(this.position.getX(), this.position.getY()-1));
    		break;
    	case WEST:
    		if(this.position.getX()-1 < 0) {
    			throw new MoveRoverException();
    		}
    		moveRoverInPlateau(this.position, new Position(this.position.getX()-1, this.position.getY()));
    		break;
    	default:
    		break;
    	}
    }
    
    public void launchInstructions(){
    	
    	instructions.stream().forEach(inst -> {
    		try {
    			switch (inst) {
    				case Move:
						this.move();
						break;
    				case Left:
						this.goLeft();
						break;
    				case Right:
						this.goRight();
						break;	
					default:
						break;
					}
    		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
    	});
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

	public List<InstructionsEnum> getInstructions() {
		return instructions;
	}

	public void setInstructions(List<InstructionsEnum> instructions) {
		this.instructions = instructions;
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

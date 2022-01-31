package com.oussama.models;

import com.oussama.enums.DirectionsEnum;
import com.oussama.exceptions.RoverDirectionException;

public class Position {
	int x;
	int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//Vérifier si la position est valide (inclue dans le plateau)
	public boolean IsOnPlateau(Plateau p) {
		if (x < 0 || x > p.rowsCount) {
			return false;
		}
		
		if (y < 0 || y > p.columnsCount) {
			return false;
		}
		
		return true;
	}
	
	//Donner à la position de nouvelles valeurs
	public Position moveTo(DirectionsEnum direction) {
		switch (direction) {
			case EAST: return new Position(x + 1, y);
			case NORTH: return new Position(x, y + 1);
			case SOUTH: return new Position(x, y - 1);
			case WEST: return new Position(x - 1, y);
			default: throw new RoverDirectionException(direction.direction);
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	//Vérifier l'égaliter de deux position
	public boolean isEqual(Position p) {
		return x == p.getX() && y == p.getY();
	}
	
	@Override
	public String toString() {
		return x + " " + y;
	}

}

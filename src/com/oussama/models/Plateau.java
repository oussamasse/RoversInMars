package com.oussama.models;

import java.util.ArrayList;
import java.util.List;

import com.oussama.exceptions.LaunchRoverException;

public class Plateau {
	
	int rowsCount;
	int columnsCount;
	List<Rover> rovers;
	
	
	
	public Plateau(int rowsCount, int columnsCount) {
		super();
		this.rowsCount = rowsCount;
		this.columnsCount = columnsCount;
		this.rovers = new ArrayList<Rover>();
	}

	//Ajouter le rover au plateau
	public void addRover(Rover r) {
		if(isOccupied(r.getPosition()))
			throw new LaunchRoverException();
		r.setPlateau(this);
		this.rovers.add(r);
	}
	
	//Voir si la position p est occupée
	public boolean isOccupied(Position p) {
		for (Rover r : rovers) {
			if (r.getPosition().isEqual(p)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Plateau [rowsCount=" + rowsCount + ", columnsCount=" + columnsCount + "]";
	}
}

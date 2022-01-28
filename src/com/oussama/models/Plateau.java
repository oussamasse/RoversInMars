package com.oussama.models;

import java.util.ArrayList;
import java.util.List;

import com.oussama.exceptions.LaunchRoverException;

public class Plateau {
	
	int rowsCount;
	int columnsCount;
	Rover[][] grid;
	List<Rover> rovers;
	
	
	
	public Plateau(int rowsCount, int columnsCount) {
		super();
		this.rowsCount = rowsCount;
		this.columnsCount = columnsCount;
		this.rovers = new ArrayList<Rover>();
		this.grid = new Rover[rowsCount][columnsCount];
	}

	public void addRover(Rover r) throws LaunchRoverException {
		if(!isOccupated(r.getPosition())) {
			this.grid[r.getPosition().getX()][r.getPosition().getY()] = r;
			r.setPlateau(this);
			this.rovers.add(r);
		} else {
			throw new LaunchRoverException();
		}
	}
	
	public boolean isOccupated(Position p) {
		if(grid[p.getX()][p.getY()] != null) {
			return true;
		}
		return false;
	}
}

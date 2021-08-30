package Buildings;

import Auxiliary.Coordinate;

public abstract class Building {

	protected int DP;
	protected int currentDP;
	protected String name;
	protected char owner;
	protected Coordinate coordinate;
	
	public int GetCurrentDP() {
		return currentDP;
	}
	
	public void SetCurrentDP(int currentDP) {	//Maybe villagers (constructors (need interface)) can repair. Repair point.
		if(currentDP > DP)
		{
			this.currentDP = DP;
		}
		else
		{
			this.currentDP = currentDP;
		}
	}
	
	public int GSetDP() {
		return DP;
	}
	
	public char GetOwner() {
		return owner;
	}

	public Coordinate GetCoordinate() {
		return coordinate;
	}

	public void SetCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	
	
	
	
}

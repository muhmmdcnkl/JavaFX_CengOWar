package Units;

import Auxiliary.Coordinate;

public abstract class Human {

	protected String ID;
	protected String type;
	protected int life;
	protected int currentLife;
	protected int cost;
	protected Coordinate coordinate;
	protected int moveSpeed;
	protected char direction;
	protected int stamina;
	protected int currentStamina;
	
	public int getCurrentStamina() {
		return currentStamina;
	}

	public void setCurrentStamina(int currentStamina) {
		this.currentStamina = currentStamina;
	}

	public int getStamina() {
		return stamina;
	}

	public int GetMoveSpeed() {
		return moveSpeed;
	}
	
	public String GetID() {
		return ID;
	}
	
	public String GetType() {
		return type;
	}
	
	public int GetLife() {
		return life;
	}
	
	public int GetCurrentLife() {
		return currentLife;
	}
	
	public void SetCurrentLife(int currentLife) {
		this.currentLife = currentLife;
	}
	
	public int GetCost() {
		return cost;
	}
	
	public Coordinate GetCoordinate() {
		return coordinate;
	}
	
	public void SetCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

	public abstract Object[][] Move(Object[][] map, String command);
}
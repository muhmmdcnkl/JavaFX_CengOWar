package Units;

import Auxiliary.Coordinate;

public class Foot extends Human implements ISoldier {

	protected final String TYPE = "FOOT";
	protected int attackSpeed;
	protected int attackDamage;
	
	public Foot(int ID, Coordinate coord)
	{
		this.ID = "F" + ID;
		life = 200;
		currentLife = life;
		type = TYPE;
		moveSpeed = 1;
		cost = 100;
		direction = ' ';	    
	    coordinate = coord;
	    attackDamage = 100;
	    attackSpeed = 1;
	    stamina = 2;
	    currentStamina = stamina;
	}
	
	public int GetAttackSpeed() {
		return attackSpeed;
	}
	
	public int GetAttackDamage() {
		return attackDamage;
	}
	
	public Object[][] Attack(Object[][] map)
	{
		//Add an attack logic here
		return map;
	}
	
	public Object[][] Move(Object[][] map, String command)
	{
		int oldX = coordinate.GetX();
		int oldY = coordinate.GetY();
		
		if(command.equals("left"))
		{
			coordinate.SetY(this.coordinate.GetY() - 1);
			direction = 'l';
		}
		else if(command.equals("right"))
		{
			coordinate.SetY(this.coordinate.GetY() + 1);
			direction = 'r';
		}
		else if(command.equals("up"))
		{
			coordinate.SetX(this.coordinate.GetX() - 1);
			direction = 'u';
		}
		else if (command.equals("down"))
		{
			coordinate.SetX(this.coordinate.GetX() + 1);
			direction = 'd';
		}
		
		if(map[coordinate.GetX()][coordinate.GetY()] == null)
		{
			map[this.coordinate.GetX()][this.coordinate.GetY()] = this;
			map[oldX][oldY] = null;
		}
		else
		{
			coordinate.SetX(oldX);
			coordinate.SetY(oldY);
		}
		
		return map;
	}
	
}

package Units;

import Auxiliary.Coordinate;

public class Archer extends Human implements ISoldier {

	protected final String TYPE = "ARCHER";
	protected int attackSpeed;
	protected int attackDamage;
	protected int range;
	
	public Archer(int ID, Coordinate coord)
	{
		this.ID = "A" + ID;
		life = 150;
		currentLife = life;
		type = TYPE;
		moveSpeed = 1;
		cost = 150;
		direction = ' ';	    
	    coordinate = coord;
	    attackDamage = 50;
	    attackSpeed = 1;
	    range = 3;
	    stamina = 2;
	    currentStamina = stamina;
	}
	
	public int GetAttackSpeed() {
		return attackSpeed;
	}

	public int GetAttackDamage() {
		return attackDamage;
	}

	public int GetRange() {
		return range;
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
	
	public Object[][] Attack(Object[][] map)
	{
		//Add an attack logic here
		return map;
	}
	
}

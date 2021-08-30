package Units;

import java.util.Random;

import Auxiliary.Coordinate;
import Resources.GoldMine;

public class Villager extends Human {

	protected final String TYPE = "VILLAGER";
	protected int collectSpeed;
	
	public Villager(int ID, Coordinate coord)
	{
		this.ID = "V" + ID;
		life = 100;
		currentLife = life;
		type = TYPE;
		moveSpeed = 1;
		collectSpeed = 100;
		cost = 50;
		direction = ' ';	    
	    coordinate = coord;
	    stamina = 3;
	    currentStamina = stamina;
	}
	
	public int GetCollectSpeed() {
		return collectSpeed;
	}

	public Object[][] Move(Object[][] map, String command)
	{
		if(currentStamina > 0)
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
			currentStamina--;
		}		
		return map;
	}
	
	public Object[][] Collect(Object[][] map)
	{
		int quantity = 0;
		
		if(direction == 'u')
		{
			if(coordinate.GetX() - 1 >= 0 && map[coordinate.GetX() - 1][coordinate.GetY()] instanceof GoldMine)
			{
				quantity = ((GoldMine)map[coordinate.GetX() - 1][coordinate.GetY()]).GetCurrentQuantity();
				if(quantity > 0)
				{
					((GoldMine)map[coordinate.GetX() - 1][coordinate.GetY()]).SetCurrentQuantity(quantity - collectSpeed);
				}
				else
				{
					map[coordinate.GetX() - 1][coordinate.GetY()] = null;
				}
			}
		}
		else if(direction == 'd')
		{
			if(coordinate.GetX() + 1 <= map.length && map[coordinate.GetX() + 1][coordinate.GetY()] instanceof GoldMine)
			{
				quantity = ((GoldMine)map[coordinate.GetX() + 1][coordinate.GetY()]).GetCurrentQuantity();
				if(quantity > 0)
				{
					((GoldMine)map[coordinate.GetX() + 1][coordinate.GetY()]).SetCurrentQuantity(quantity - collectSpeed);
				}
				else
				{
					map[coordinate.GetX() + 1][coordinate.GetY()] = null;
				}
			}
		}
		else if(direction == 'r')
		{
			if(coordinate.GetY() + 1 <= map[0].length && map[coordinate.GetX()][coordinate.GetY()  + 1] instanceof GoldMine)
			{
				quantity = ((GoldMine)map[coordinate.GetX()][coordinate.GetY() + 1]).GetCurrentQuantity();
				if(quantity > 0)
				{
					((GoldMine)map[coordinate.GetX()][coordinate.GetY() + 1]).SetCurrentQuantity(quantity - collectSpeed);
				}
				else
				{
					map[coordinate.GetX()][coordinate.GetY() + 1] = null;
				}
			}
		}
		else if(direction == 'l')
		{
			if(coordinate.GetY() - 1 >= 0 && map[coordinate.GetX()][coordinate.GetY()  - 1] instanceof GoldMine)
			{
				quantity = ((GoldMine)map[coordinate.GetX()][coordinate.GetY() - 1]).GetCurrentQuantity();
				if(quantity > 0)
				{
					((GoldMine)map[coordinate.GetX()][coordinate.GetY() - 1]).SetCurrentQuantity(quantity - collectSpeed);
				}
				else
				{
					map[coordinate.GetX()][coordinate.GetY() - 1] = null;
				}
			}
		}
		
		return map;
	}
}

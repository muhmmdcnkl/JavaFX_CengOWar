package Gamers;

import Units.*;
import Auxiliary.Coordinate;
import Buildings.*;

public class Player extends Gamer implements IGamerAuxiliary {

	public Player(Object[][] map)
	{
		villagers = new Villager[4];
		foots = new Foot[4];
		archers = new Archer[4];		
		base = new Base('P', CreateBase(map));
	}
	
	
	public Object[][] ProcessCommand(Object[][] map, String command)
	{
		String[] parts = command.split("");
		if(parts.length != 0)
		{
			String ID, cmd;
			if(parts[0].toLowerCase().equals("end"))
			{
				EndTurnProcess();
				return map;
			}
			else if(parts[0].toLowerCase().equals("villager"))
			{
				CreateVillager(map);
			}
			else if(parts[0].toLowerCase().equals("foot"))
			{
				CreateFoot(map);
			}
			else if(parts[0].toLowerCase().equals("archer"))
			{
				CreateArcher(map);
			}
			else
			{
				ID = parts[0];
				cmd = parts[1].toLowerCase();
			
				int index;
				if(cmd.equals("left") || cmd.equals("right") || cmd.equals("up") || cmd.equals("down"))
				{
					if(ID.substring(0, 1).equals("V"))
					{
						index = FindUnit(villagers, ID);
						if(index != -1)
						{
							map = villagers[index].Move(map, cmd);
							villagers[index].setCurrentStamina(villagers[index].getStamina() - 1);
						}
					}
					else if(ID.substring(0, 1).equals("F"))
					{
						index = FindUnit(foots, ID);
						if(index != -1)
						{
							map = foots[index].Move(map, cmd);
							foots[index].setCurrentStamina(foots[index].getStamina() - 1);
						}
					}
					else if(ID.substring(0, 1).equals("A"))
					{
						index = FindUnit(foots, ID);
						if(index != -1)
						{
							map = archers[index].Move(map, cmd);
							archers[index].setCurrentStamina(archers[index].getStamina() - 1);
						}
					}
				}
				else if(cmd.equals("collect"))
				{
					if(ID.substring(0, 1).equals("V"))
					{
						index = FindUnit(villagers, ID);
						if(index != -1)
						{
							map = villagers[index].Collect(map);
						}
					}
				}
				else if(cmd.equals("attack"))
				{
	
					if(ID.substring(0, 1).equals("F"))
					{
						index = FindUnit(foots, ID);
						map = foots[index].Attack(map);
					}
					else if(ID.substring(0, 1).equals("A"))
					{
						index = FindUnit(foots, ID);
						map = archers[index].Attack(map);
					}
				}
			}
			return map;
		}
		else
		{
			return map;
		}
	}
	
	public void CreateVillager(Object map[][])
	{
		int index = FindEmptySlot(villagers);
		if(index != -1)
		{
			int x = base.GetCoordinate().GetX();
			int y = base.GetCoordinate().GetY();
			while(true)
			{
				if(x < 20)
				if(map[x + 1][y] == null)
				{
					villagers[index] = new Villager(index + 1, new Coordinate(x + 1, y));
					map[x + 1][y] = villagers[index];
					break;
				}
				else if(map[x - 1][y] == null)
				{
					villagers[index] = new Villager(index + 1, new Coordinate(x - 1, y));
					map[x - 1][y] = villagers[index];
					break;
				}
				else if(map[x][y + 1] == null)
				{
					villagers[index] = new Villager(index + 1, new Coordinate(x, y + 1));
					map[x][y + 1] = villagers[index];
					break;
				}
				else if(map[x][y - 1] == null)
				{
					villagers[index] = new Villager(index + 1, new Coordinate(x, y - 1));
					map[x][y - 1] = villagers[index];
					break;
				}
				else if(map[x + 1][y + 1] == null)
				{
					villagers[index] = new Villager(index + 1, new Coordinate(x + 1, y + 1));
					map[x + 1][y + 1] = villagers[index];
					break;
				}

				else if(map[x - 1][y + 1] == null)
				{
					villagers[index] = new Villager(index + 1, new Coordinate(x - 1, y + 1));
					map[x - 1][y + 1] = villagers[index];
					break;
				}
				else if(map[x + 1][y - 1] == null)
				{
					villagers[index] = new Villager(index + 1, new Coordinate(x + 1, y - 1));
					map[x + 1][y - 1] = villagers[index];
					break;
				}
				else if(map[x - 1][y - 1] == null)
				{
					villagers[index] = new Villager(index + 1, new Coordinate(x - 1, y - 1));
					map[x - 1][y - 1] = villagers[index];
					break;
				}
				else
				{
					
				}
			}
		}
	}
	
	public void CreateFoot(Object map[][])
	{
		
	}
	
	public void CreateArcher(Object map[][])
	{
		
	}
	
	public Coordinate FindEmptySpace(Object map[][])
	{
		//while(true)
		{
			//if(map[base.get])
		}
		
		
		return null;
	}
	
	public int FindUnit(Human[] units, String ID)
	{
		int i = 0;
		for(; i < units.length; i++)
		{
			if(units[i].GetID().equals(ID)) {
				return i;
			}
		}
		return -1;
	}
	
	public int FindEmptySlot(Human[] units)
	{
		int i = 0;
		for(; i < units.length; i++)
		{
			if(units[i] == null)
			{
				return i;
			}
		}
		return -1;
	}
	
	public Coordinate CreateBase(Object map[][])
	{
		int x, y;
		do
		{
			x = (int)(Math.random() * (map.length - 1));
			y = (int)(Math.random() * (map.length - 1));
		}while(map[x][y] != null);
		
		return new Coordinate(x, y);
	}
	
}

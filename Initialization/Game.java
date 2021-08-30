package Initialization;

import java.util.Random;
import java.util.Scanner;

import Auxiliary.Coordinate;
import Resources.GoldMine;
import Units.*;

public class Game {
	
	Object[][] map;
	Villager[] villagers;
	Foot[] foots;
	Archer[] archers;
	private Random rand;
	
	public Game()
	{
		map = new Object[20][20];
		villagers = new Villager[4];
		foots  = new Foot[4];
		archers = new Archer[4];		
		
		CreateMap();
		InitializeUnits();
		Menu();
	}
	
	private void Menu()
	{
		Scanner scn = new Scanner(System.in);
		Random rnd = new Random();
		String command;
		
		while(true)
		{
			DisplayMap();
			command = scn.nextLine();
			if(command.toLowerCase().equals("left") || command.toLowerCase().equals("right") || command.toLowerCase().equals("up")
					|| command.toLowerCase().equals("down"))
			{
				map = villagers[0].Move(map, command);
			}
			else if(command.toLowerCase().equals("collect"))
			{
				map = villagers[0].Collect(map);
			}
			DisplayMap();
			command = scn.nextLine();
			if(command.toLowerCase().equals("left") || command.toLowerCase().equals("right") || command.toLowerCase().equals("up")
					|| command.toLowerCase().equals("down"))
			{
				map = foots[0].Move(map, command);
			}
			else if(command.toLowerCase().equals("attack"))
			{
				map = foots[0].Attack(map);
			}

			DisplayMap();
			command = scn.nextLine();
			if(command.toLowerCase().equals("left") || command.toLowerCase().equals("right") || command.toLowerCase().equals("up")
					|| command.toLowerCase().equals("down"))
			{
				map = archers[0].Move(map, command);
			}
			else if(command.toLowerCase().equals("attack"))
			{
				map = archers[0].Attack(map);
			}
		}
		
		

	}
	
	private void InitializeUnits()
	{
		Random rand = new Random();
		int x;
		int y;
		
		do
		{
			x = rand.nextInt((map.length - 0)) + 0;
			y = rand.nextInt((map[0].length - 0)) + 0;
		}while(map[x][y] != null);
		villagers[0] = new Villager(1, new Coordinate(x, y));
		map[x][y] = villagers[0];

		do
		{
			x = rand.nextInt((map.length - 0)) + 0;
			y = rand.nextInt((map[0].length - 0)) + 0;
		}while(map[x][y] != null);
		foots[0] = new Foot(1, new Coordinate(x, y));
		map[x][y] = foots[0];
		
		do
		{
			x = rand.nextInt((map.length - 0)) + 0;
			y = rand.nextInt((map[0].length - 0)) + 0;
		}while(map[x][y] != null);
		archers[0] = new Archer(1, new Coordinate(x, y));
		map[x][y] = archers[0];
	}
	
	private void CreateMap()
	{
		Random rand = new Random();
		int i = 0;
		
		while(i < 25)
		{
			int randomX = rand.nextInt((map.length - 0)) + 0;	//Rand((max - min) + 1) + min
		    int randomY = rand.nextInt((map[0].length - 0)) + 0;
		    if(map[randomX][randomY] == null)
		    {
		    	map[randomX][randomY] = new GoldMine(new Coordinate(randomX, randomY));
		    	i++;
		    }
		}
	}
	
	private void DisplayMap()
	{
		System.out.println("To create a unit, write its type.");
		System.out.println("Or enter a command. (left, right, up, down, collect, attack)");
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map[0].length; j++)
			{
				if(map[i][j] instanceof Human)
				{
					System.out.print(((Human)map[i][j]).GetID() + "  ");
				}
				else if(map[i][j] instanceof GoldMine)
				{
					System.out.print(((GoldMine)map[i][j]).GetCurrentQuantity() + " ");
				}
				/*if(map[i][j] instanceof Villager)
				{
					System.out.print(((Villager)map[i][j]).GetID() + "  ");
				}
				else if(map[i][j] instanceof Archer)
				{
					System.out.print(((Archer)map[i][j]).GetID() + "  ");
				}
				else if(map[i][j] instanceof Foot)
				{
					System.out.print(((Foot)map[i][j]).GetID() + "  ");
				}*/
				else
				{
					System.out.print(".   ");
				}
			}
			System.out.println();
		}
		System.out.print("Enter command = ");
	}
	
}

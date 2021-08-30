package Gamers;

import Units.*;
import Buildings.*;

public abstract class Gamer {

	Villager[] villagers;
	Foot[] foots;
	Archer[] archers;
	Base base;
	int[] population = new int[4];	//population[0] = villagers, population[1] = foots, population[2] = archers, population[3] = all
	
	public Villager[] GetVillagers() {
		return villagers;
	}
	
	public void SetVillagers(Villager[] villagers) {
		this.villagers = villagers;
	}
	
	public Foot[] GetFoots() {
		return foots;
	}
	
	public void SetFoots(Foot[] foots) {
		this.foots = foots;
	}
	
	public Archer[] GetArchers() {
		return archers;
	}
	
	public void SetArchers(Archer[] archers) {
		this.archers = archers;
	}
	
	public Base GetBase() {
		return base;
	}	
	
	
	/*protected int[] FindPopulation()
	{
		int[] population = new int[4];
		int i = 0;
		
		for(; i < villagers.length; i++)
		{
			if(villagers[i] != null)
			{
				population[0]++;
				population[3]++;
			}
		}
		for(i = 0; i < foots.length; i++)
		{
			if(foots[i] != null)
			{
				population[1]++;
				population[3]++;
			}
		}
		for(i = 0; i < archers.length; i++)
		{
			if(archers[i] != null)
			{
				population[2]++;
				population[3]++;
			}
		}
		
		
		return population;
	}*/
	
	protected void EndTurnProcess()
	{
		int i = 0;
		for(; i < villagers.length; i++)
		{
			if(villagers[i] != null)
			{
				villagers[i].setCurrentStamina(villagers[i].getStamina());
			}
		}
		
		for(i = 0; i < foots.length; i++)
		{
			if(foots[i] != null)
			{
				foots[i].setCurrentStamina(foots[i].getStamina());
			}
		}
		
		for(i = 0; i < archers.length; i++)
		{
			if(archers[i] != null)
			{
				archers[i].setCurrentStamina(archers[i].getStamina());
			}
		}
	}
}

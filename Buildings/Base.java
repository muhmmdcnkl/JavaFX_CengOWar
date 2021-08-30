package Buildings;

import Auxiliary.Coordinate;

public class Base extends Building{

	public Base(char owner, Coordinate coordinate)
	{
		this.owner = owner;
		DP = 1000;
		currentDP = DP;
		this.coordinate = coordinate;
		if(owner == 'P')
		{
			name = "[P]";
		}
		else if(owner == 'C')
		{
			name = "[C]";
		}
	}
	
}

package Gamers;

import Auxiliary.Coordinate;
import Units.Human;

public interface IGamerAuxiliary {

	public int FindUnit(Human[] units, String ID);
	
	public void CreateVillager(Object map[][]);
	
	public void CreateFoot(Object map[][]);
	
	public void CreateArcher(Object map[][]);

	public Object[][] ProcessCommand(Object[][] map, String command);
	
	public Coordinate FindEmptySpace(Object map[][]);
	
	public Coordinate CreateBase(Object map[][]);
}

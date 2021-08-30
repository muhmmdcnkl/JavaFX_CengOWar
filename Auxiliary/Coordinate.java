package Auxiliary;

public class Coordinate {

	protected int x;
	protected int y;
	
	public Coordinate(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public int GetX() {
		return x;
	}

	public void SetX(int x) {
		if(x >= 0 && x < 20)
		{
			this.x = x;
		}
	}

	public int GetY() {
		return y;
	}

	public void SetY(int y) {
		if(y >= 0 && y < 20)
		{
			this.y = y;
		}
	}
}

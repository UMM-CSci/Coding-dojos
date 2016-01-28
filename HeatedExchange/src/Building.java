import java.util.ArrayList;

public class Building {
	private ArrayList<Wall> wallArray = new ArrayList<Wall>();

	public void buildWall(Wall newWall) {
		wallArray.add(newWall);
	}

	public void passHour() {
		for (Wall wall : wallArray) {
			wall.takeTemps();
		}
		for (Wall wall : wallArray) {
			wall.updateRoomTemps();
		}
	}
	
	public ArrayList<Wall> getWalls() {
		return wallArray;
	}
}

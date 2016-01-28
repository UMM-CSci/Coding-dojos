// Good program here
public class MainProgram {
	public static void main(String[] args) {
		Room room1 = new Room(72.0);
		Room room2 = new Room(71.0);
		Room room3 = new Room(74.0);
		Room room4 = new Room(84.0);
		Room room5 = new Room(61.0);
		Wall wall1 = new Wall(.2, room1, room2);
		Wall wall2 = new Wall(0.0, room1, room4);
		Wall wall3 = new Wall(1.0, room4, room5);
		Wall wall4 = new Wall(.55, room5, room3);
		Building office = new Building();
		office.buildWall(wall1);
		office.buildWall(wall2);
		office.buildWall(wall3);
		office.buildWall(wall4);

		for (int i = 0; i < 100; i++) {
			office.passHour();
			System.out.println("After hour " + i);
			for (Wall wall : office.getWalls()) {
				wall.printDiffs();
			}
			System.out.println();
		}
		
		System.out.println("Room 1 temp: " + room1.getTemp());
		System.out.println("Room 2 temp: " + room2.getTemp());
		System.out.println("Room 3 temp: " + room3.getTemp());
		System.out.println("Room 4 temp: " + room4.getTemp());
		System.out.println("Room 5 temp: " + room5.getTemp());
	}

}

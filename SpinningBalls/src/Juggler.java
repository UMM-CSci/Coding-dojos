import java.util.ArrayList;


public class Juggler {
	private ArrayList<Ball> balls = new ArrayList<Ball>();

	public void add(Ball ball) {
		balls.add(ball);
		
	}
	

	public int getMinRotations() {
		//Check all colors for their distance in turns from the current state
		//Returns the min num of turns from all of the colors
		String[] colors = balls.get(0).getColors();
		Integer minRotations = null;
		for (String color : colors) {
			int rotationsForColor = findTotalMinRotations(color);
			if (minRotations == null || rotationsForColor < minRotations) {
				minRotations = rotationsForColor;
			}
		}
		return minRotations;
	}


	private int findTotalMinRotations(String color) {
		int minRotations = 0;
		for (Ball activeBall : balls){
			minRotations += activeBall.getRotation(color);
		}
		return minRotations;
	}

}

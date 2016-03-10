
public class Ball {
	private String[] colors;
	private int front;
	
	public Ball(String[] colorArray, int frontIndex) {
		colors = colorArray;
		front = frontIndex;
	}
	
	public int getRotation(String color){
		int indexOfColor = getIndexOfColor(color);
		return Math.min(Math.abs(front - indexOfColor), colors.length - Math.abs(front - indexOfColor));
	}

	// Does not handle the case where color is not found
	private int getIndexOfColor(String color) {
		int currentIndex = 0;
		while (currentIndex < colors.length && !colors[currentIndex].equals(color)) {
			currentIndex++;
		}
		return currentIndex;
	}
	
	public String[] getColors() {
		return colors;
	}

}

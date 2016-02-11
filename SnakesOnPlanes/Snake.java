public class Snake {
	private final String color;
	private final int length;
	private static int totalLength = 0;
	private static int numSnakes = 0;
	
	public Snake(String col, int len) {
		color = col;
		length = len;
		numSnakes++;
		totalLength += len;
	}
	
	public String getColor() {
		return color;	
	}
	
	public int getLength() {
		return length;	
	}
	
	public static int getNum() {
		return numSnakes;
	}
	
	public static int getTotalLength(){
		return totalLength;	
	}
}


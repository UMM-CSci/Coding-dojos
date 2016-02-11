public class BlueSnake extends Snake {
	private static int numSnakes = 0;
	private static int totalLength = 0;
	
	public BlueSnake(int len){
		super("blue", len);
		numSnakes++;
		totalLength += len;
	}
	
	public static int getNum(){
		return numSnakes;	
	}
	
	public static int getTotalLength(){
		return totalLength;	
	}
}


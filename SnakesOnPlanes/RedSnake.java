public class RedSnake extends Snake {
	private static int numSnakes = 0;
	
	public RedSnake(int len){
		super("red", len);
		numSnakes++;
	}
	
	public static int getNum(){
		return numSnakes;	
	}
}


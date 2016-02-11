public class GreenSnake extends Snake {
	private static int numSnakes = 0;
	
	public GreenSnake(int len){
		super("green", len);
		numSnakes++;
	}
	
	public static int getNum(){
		return numSnakes;	
	}
}


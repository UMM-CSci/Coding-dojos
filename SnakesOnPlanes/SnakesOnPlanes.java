import java.util.ArrayList;

public class SnakesOnPlanes {
	public static void main(String[] args){
		ArrayList<Snake> snakes = new ArrayList<Snake>();
		snakes.add(new RedSnake(8));
		for (int i = 0; i < 5; i++) {
			snakes.add(new GreenSnake(i));
		}
		// first testing
		System.out.println(willSnakesAttack(snakes));
		//snakes.add(new GreenSnake(4));
		System.out.println(willSnakesAttack(snakes));
		snakes.add(new BlueSnake(9));
		System.out.println(snakes.get(0).getColor());
		System.out.println(snakes.get(0).getLength());
		System.out.println(snakes.get(1).getColor());
		System.out.println(snakes.get(1).getLength());
		System.out.println(snakes.get(2).getColor());
		System.out.println(snakes.get(2).getLength());
		
		// second testing
		System.out.println(willSnakesAttack(snakes)); // false
		for (int i = 0; i < 10; i++) {
			snakes.add(new BlueSnake(i));
		}
		System.out.println(willSnakesAttack(snakes)); 
		
	}
	
	public static boolean willSnakesAttack(ArrayList<Snake> snakes){
		return GreenSnake.getNum() > 5 ||
		       RedSnake.getNum() > GreenSnake.getNum() + BlueSnake.getNum() ||
		       Snake.getTotalLength() > 150 ||
		       BlueSnake.getTotalLength() > 50 ||
		       Snake.getNum() > 15 ||
		       (GreenSnake.getNum() > RedSnake.getNum() && BlueSnake.getNum() > RedSnake.getNum()) ||
		       (GreenSnake.getNum() < RedSnake.getNum() && BlueSnake.getNum() < RedSnake.getNum()) ||
		       tooManyLongSnakes(snakes) ||
		       haveTooBigOfABlueSnake(snakes);
	}
	
	public static boolean tooManyLongSnakes(ArrayList<Snake> snakes){
		int longSnakes = 0;
		for (Snake snake : snakes) {
			if (snake.getLength() > 10) {
				longSnakes++;
			}
		}
		return longSnakes > 10;
	}
	
	public static boolean haveTooBigOfABlueSnake(ArrayList<Snake> snakes) {
		int minGreenSnakeLength = Snake.getTotalLength();
		int maxBlueSnakeLength = -1;
		
		for (Snake snake : snakes) {
			if (snake.getColor() == "green" && snake.getLength() < minGreenSnakeLength) {
				minGreenSnakeLength = snake.getLength();
			} else if (snake.getColor() == "blue" && snake.getLength() > maxBlueSnakeLength) {
				maxBlueSnakeLength = snake.getLength();
			}
		}
		
		return minGreenSnakeLength <= maxBlueSnakeLength;
	}
}


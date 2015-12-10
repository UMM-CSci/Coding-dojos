import stanford.karel.SuperKarel;

public class WindmillKarel extends SuperKarel {

	public void run() {
		
		for (int i = 0; i < 4; i++) {
			makeBlade();
		}
		putBeeper();
		
	}
	
	public void makeBlade(){
		move(5);
		turnLeft();
		move(5);
		makeDiagonal();
	}
	public void move(int num){
		for (int i = 0; i < num; i++) {
			move();
			putBeeper();
		}
	}
	
	public void makeDiagonal() {
		turnLeft();
		for (int i = 0; i < 4; i++) {
			shiftDiagonalUpperRight();
			putBeeper();
		}
		shiftDiagonalUpperRight();
		turnRight();
	}
	
	public void shiftDiagonalUpperRight() {
		turnLeft();
		move();
		turnRight();
		move();
	}
	
	
	
}

import stanford.karel.*;

public class WelcomeToKarel extends Karel {

	/*
	 * It's stealing newspapers. And then, it brings them home. Throw them on the ground.
	 * 
	 * Precondition: Karel is facing East at (2, 2).
	 * Postcondition: Karel has moved all the beepers into his house. Karel is facing East at (2, 1).
	 */
	public void run() {
		moveThree();
		pickBeeper();
		turnLeft();
		moveThree();
		pickBeeper();
		moveThree();
		pickBeeper();
		turnLeft();
		moveThree();
		pickBeeper();
		turnLeft();
		turnLeft();
		move();
		turnRight();
		moveThree();
		moveThree();
		turnRight();
		move();
		putBeeper();
		move();
		putBeeper();
		turnLeft();
		move();
		putBeeper();
		turnLeft();
		move();
		putBeeper();	
	}
	
	/*
	 * Turns Karel right. 
	 */
	private void turnRight() {
		turnLeft();
		turnLeft();
		turnLeft();
	}
	
	/*
	 * Moves Karel forward three times.
	 */
	private void moveThree(){
		move();
		move();
		move();
	}
}









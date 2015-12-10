import stanford.karel.SuperKarel;

public class DiamondsAreForKarel extends SuperKarel {
	
	/*
	 * makes 3 diamonds, each composed of smaller beepers, 4 on each side.
	 */
	public void run() {
		moveThree();
		buildDiamond();
		moveEight();
		buildDiamond();
		moveEight();
		buildDiamond();
	}
	
	/*
	 * Moves Karel forward three times.
	 */
	private void moveThree(){
		move();
		move();
		move();
	}
	
	private void moveEight(){
		move();
		move();
		move();
		move();
		move();
		move();
		move();
		move();
	}
	
	private void diagonalPut(){
		if (noBeepersPresent()) {
			putBeeper();
		}
		move();
		turnLeft();
		move();
		turnRight();
	}
	
	private void buildEdge(){
		diagonalPut();
		diagonalPut();
		diagonalPut();
		turnLeft();
	}
	
	private void buildDiamond(){
		buildEdge();
		buildEdge();
		buildEdge();
		buildEdge();
	}
}
import stanford.karel.SuperKarel;

public class RunKarel extends SuperKarel {

	public void run() {
		handleTwoRows();
		leftSideCorner();
		
		handleTwoRows();
		leftSideCorner();
		
		handleTwoRows();
		leftSideCorner();
		
		handleTwoRows();
	}
	
	public void handleRow() {
		move();
		move();
		move();
		move();
		move();
		pickBeeper();
		move();
		move();
		move();
		move();
		pickBeeper();
	}
	
	public void rightSideCorner() {
		turnRight();
		move();
		turnRight();
	}
	
	public void leftSideCorner(){
		turnLeft();
		move();
		turnLeft();
	}
	
	public void handleTwoRows(){
		handleRow();
		rightSideCorner();
		handleRow();
	}
	
}
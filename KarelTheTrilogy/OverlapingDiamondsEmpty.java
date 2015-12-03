import stanford.karel.SuperKarel;

public class OverlapingDiamondsEmpty extends SuperKarel {

	public void run() {
		makeDiamond();
		move4();
		
		makeDiamond();
		turnLeft();
		move4();
		turnRight();
		
		makeDiamond();
		turnAround();
		move4();
		turnAround();
		
		makeDiamond();
		
	}
	private void move4() {
		move();
		move();
		move();
		move();
	}
	
	// At the beginning of method, Karel facing East and at bottom of diamond.
	public void	makeDiamond() {
		makeSide();
		makeSide();
		makeSide();
		makeSide();		
	}
	
	// After side is created, Karel is rotated 90 degrees left from his starting direction.
	// This is to allow him to make the next side in the right spot.
	public void makeSide(){
		placeBeeperMove();
		placeBeeperMove();
		placeBeeperMove();
		placeBeeperMove();
		turnLeft();
	}
	
	// If there is no beeper in the spot Karel is, Karel will place a beeper and move to the
	// next location for a beeper.
	public void placeBeeperMove(){
		move();
		turnLeft();
		move();
		turnRight();
		if (noBeepersPresent())	{
			putBeeper();
		}
		
	}
	
	
}
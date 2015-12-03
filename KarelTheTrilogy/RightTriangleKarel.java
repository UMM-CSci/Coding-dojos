import stanford.karel.SuperKarel;

public class RightTriangleKarel extends SuperKarel {

	public void run() {
		makeRightTriangle(5);
		
	}
	public void makeRightTriangle(int size) {
		makeBottomAndReturn(size);
		for (int i = (size - 1); i > 0; i--) {
			moveUp();
			makeBottomAndReturn(i);
		}
	}
	public void makeBottomAndReturn(int num) {
		putBeeper();
		for (int i=1; i<num; i++) {
			move();
			putBeeper();
		}
		turnAround();
		
		move(num-1);
		
	
	}
	public void moveUp(){
		turnRight();
		move();
		turnRight();
	}
	
	public void move(int x) {
		for (int i=0; i<x; i++) {
			move();
		}
	}
}
import stanford.karel.SuperKarel;

public class DetectiveKarel extends SuperKarel {

	public void run() {
		while(!cornerColorIs(GREEN)) {
			while(frontIsClear() && !cornerColorIs(GREEN)) {
				move();
			}
			if (cornerColorIs(GREEN)){
				break;
			}
			if (facingWest()) {
				turnRight();
				move();
				turnRight();
			}
			else {
				turnLeft();
				move();
				turnLeft();
			}
		}
	}
}
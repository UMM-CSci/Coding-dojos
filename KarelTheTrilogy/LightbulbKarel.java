import stanford.karel.SuperKarel;

public class LightbulbKarel extends SuperKarel {

	public void run() {
		while (frontIsClear()) {
			replaceBeeper();
			move(); 	

		}
		replaceBeeper();
	}

	private void replaceBeeper(){
		if(leftIsClear()) {
			turnLeft();
			move();
			if (beepersPresent()){
				pickBeeper();
			}else{
				putBeeper();
			}
			turnAround();
			move();
			turnLeft();
		}
	}

}
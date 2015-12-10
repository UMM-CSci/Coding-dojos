
public class Frame {
	
	private Integer firstRoll;
	private Integer secondRoll;
	private Integer lastRoll;
	int frame;
	
	public Frame(int frame) {
		this.frame = frame;
	}

	public void addScore(int i) throws OverTenException {
		if (frame == 10){
			addTenthFrameScore(i);
		}
		if (firstRoll == null) {
			firstRoll = i;
			if(i > 10) {
				throw new OverTenException();
			}
		} else if (secondRoll == null) {
			secondRoll = i;
			if((i + firstRoll) > 10) {
				throw new OverTenException();
			}
		} else {
			System.err.println("No more rolls allowed in this frame.");
			//TODO: Throw new IllegalArgumentException
		}
	}
	
	
	private void addTenthFrameScore(int i) throws OverTenException {
		if (firstRoll == null) {
			firstRoll = i;
			if(i > 10) {
				throw new OverTenException();
			}
		} else if (secondRoll == null) {
			secondRoll = i;
			if((i + firstRoll) > 20) {
				throw new OverTenException();
			}
		} else if (lastRoll == null) {
			lastRoll = i;
			if((firstRoll + secondRoll + lastRoll) > 30) {
				throw new OverTenException();
			}
		}
	}
	
	
	public Integer getRoll(int i) {
		if(i==1){
			return firstRoll;
		} else if(i==2){
			return secondRoll;
		} else if(i==3 && frame==10){
			return lastRoll;
		} else{
			return 0;
		}
		
	}
}

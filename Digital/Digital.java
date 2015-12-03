
public class Digital {

	public int convertToDigit(String top3, String mid3, String bot3) {
		String fullNum = top3 + mid3 + bot3;
		switch (fullNum) {
			case " _ | ||_|": return 0;
			case "    |  | ": return 1;
			case " _  _||_ ": return 2;
			case " _  _| _|": return 3;
			case "   |_|  |": return 4;
			case " _ |_  _|": return 5;
			case " _ |_ |_|": return 6;
			case " _   |  |": return 7;
			case " _ |_||_|": return 8;
			case " _ |_|  |": return 9;
			default: throw new IllegalArgumentException("Not a correct digital number.");
		}
	}

	public int convertSeriesToInteger(String topChars, String midChars, String botChars) {
		int returnInt = 0;
		for (int i = 0; i < topChars.length(); i += 3) {
			returnInt *= 10;
			returnInt += convertToDigit(topChars.substring(i, i+3), midChars.substring(i, i+3), botChars.substring(i, i+3));
		}
		return returnInt;
	}

}

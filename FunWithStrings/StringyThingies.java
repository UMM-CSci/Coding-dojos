public class StringyThingies {

	public static boolean isCharacterInString(char c, String str) {
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == c)
			{
				return true;
			}
		}
		return false;
	}

	public static int countCharacterOccurrencesInString(char c, String str) {
		int counter = 0;
		for(int i = 0; i < str.length();i++)
		{
			if (str.charAt(i) == c) {
				counter++;
			}
		}
		return counter;
	}

	public static boolean hasEveryLetterOfAlphabet(String string) {
		String upStr = string.toUpperCase();
		if (string.length() < 26) {
			return false;
		}
		String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < alph.length(); i++){
			if (!isCharacterInString(alph.charAt(i), upStr)) {
				return false;
			}
		}
		
		return true;
		
	}

	public static boolean isPalindrome(String string) {
		for (int i = 0; i < string.length() / 2; i++) {
			if (string.charAt(i) != string.charAt(string.length() - i - 1)){
				return false;
			}
		}
		return true;
	}

	public static boolean areAnagrams(String string, String string2) {
		String upStr = string.toUpperCase();
		String upStr2 = string2.toUpperCase();
		if (string.length() != string2.length()) {
			return false;
		}
		
		for (int i = 0; i < upStr.length(); i++){
			if (countCharacterOccurrencesInString(upStr.charAt(i), upStr) != countCharacterOccurrencesInString(upStr.charAt(i), upStr2)) {
				return false;
			}
		}
		
		return true;
	}
	
	// We can assume a hand is 5 cards

	public static boolean hasFullHouse(String hand) {
		if (!allAreCards(hand)) {
			return false;
		}
		for (int i = 0; i < hand.length(); i++) {
			int count = countCharacterOccurrencesInString(hand.charAt(i), hand);
			if (!(count == 2 || count == 3)) {
				return false;
			}
		}
		return true;
		
	}
	
	public static boolean allAreCards(String hand) {
		String cards = "23456789TJQKA";
		for (int i = 0; i < hand.length(); i++){
			if (!isCharacterInString(hand.charAt(i), cards)) {
				return false;
			}
		}
		return true;
	}

//	public static String switcharoo(String input) {
//		String result = "";		
//		for (int i = 0; i < input.length(); i++) {
//			if ( input.charAt(i) == ' ' ) {
//				result += " ";
//			}
//			if ( input.charAt(input.length() - i - 1) != ' ') {
//				result += input.charAt(input.length() - i - 1);
//			}
//		}
//		return result;
//	}
	
	public static String switcharoo(String str) {
		int i = 0;
		int j = str.length() - 1;
		String result = "";
		
		while (i < str.length()) {
			if (str.charAt(i) == ' ' && str.charAt(j) != ' ') {
				result += " ";
				i++;
			} 
			else if (str.charAt(i) != ' ' && str.charAt(j) == ' ') {
				j--;
			}
			else {
				result += str.charAt(j);
				i++;
				j--;
			}
		}
		
		return result;
	}

}

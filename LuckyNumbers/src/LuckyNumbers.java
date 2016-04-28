public class LuckyNumbers {
	public static int[] findLuckyNumbers(int[] array) {
		int[] resultArray = new int[array.length];
		
		int first = 0;
		int second = (array.length / 2) - 1;
		int third = array.length / 2;
		int fourth = array.length - 1;
		
//		Option 1:
//		for (int i = 0; i < array.length; i++) {
//			switch (i % 4) {
//				case 0:
//					resultArray[first] = array[i];
//					first++;
//					break;
//				case 1:
//					resultArray[fourth] = array[i];
//					fourth--;
//					break;
//				case 2:
//					resultArray[second] = array[i];
//					second--;
//					break;
//				case 3:
//					resultArray[third] = array[i];
//					third++;
//					break;
//			}
//		}
		
//		Option 2:
		for (int i = 0; i < array.length / 4; i++) {
			resultArray[first + i] = array[i * 4];
			resultArray[fourth - i] = array[i * 4 + 1];
			resultArray[second - i] = array[i * 4 + 2];
			resultArray[third + i] = array[i * 4 + 3];
		}
		
		return resultArray;
	}
}

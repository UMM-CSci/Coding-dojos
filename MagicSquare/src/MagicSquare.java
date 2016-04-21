
public class MagicSquare {

	public static boolean isMagicSquare(int[] inputList) {
		int n = (int) Math.sqrt(inputList.length);
		if (n * n != inputList.length) {
			throw new IllegalArgumentException("Array size must be a perfect square.");
		}
		int magicSum = ((n * n * n) + n) / 2;
		return (diagonalsAreMagic(inputList, n, magicSum) && rowsAreMagic(inputList, n, magicSum) && columnsAreMagic(inputList, n, magicSum));
	}
	
	private static boolean diagonalsAreMagic(int[] inputList, int n, int magicSum) {
		int sumLR = 0;
		int sumRL = 0;
		
		for (int number=0; number < n; number++) {
			sumLR += inputList[(number * n) + number];
			int column = n - 1 - number;
			sumRL += inputList[(number * n) + column];	
		}
		
		return sumRL == magicSum && sumLR == magicSum;
	}

	private static boolean rowsAreMagic(int[] inputList, int n, int magicSum) {
		for (int rowNumber=0; rowNumber < n; rowNumber++) {
			int sum = 0;
			for (int colNumber=0; colNumber < n; colNumber++) {
				sum += inputList[(rowNumber * n) + colNumber];
			}
			if (sum != magicSum) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean columnsAreMagic(int[] inputList, int n, int magicSum) {
		for (int colNumber=0; colNumber < n; colNumber++) {
			int sum = 0;
			for (int rowNumber=0; rowNumber < n; rowNumber++) {
				sum += inputList[(rowNumber * n) + colNumber];
			}
			if (sum != magicSum) {
				return false;
			}
		}
		return true;
	}

}

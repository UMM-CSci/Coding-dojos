
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
	
	public static boolean isMagicSquare2(int[] inputList) {
		int n = (int) Math.sqrt(inputList.length);
		if (n * n != inputList.length) {
			throw new IllegalArgumentException("Array size must be a perfect square.");
		}
		int magicSum = ((n * n * n) + n) / 2;
		int[] rowSums = new int[n];
		int[] colSums = new int[n];
		int LRDiagSum = 0;
		int RLDiagSum = 0;
		
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				int currentNum = inputList[(row * n) + col];
				rowSums[row] += currentNum;
				colSums[col] += currentNum;
				if (row == col) {
					LRDiagSum += currentNum;
				}
				if (row == n - 1 - col) {
					RLDiagSum += currentNum;
				}
			}
		}
		
		for (int item : rowSums) {
			if (item != magicSum) {
				return false;
			}
		}
		
		for (int item : colSums) {
			if (item != magicSum) {
				return false;
			}
		}
		
		return LRDiagSum == magicSum && RLDiagSum == magicSum;
	}
	
	// Doesn't work yet
//	public static boolean isMagicSquare(int[] inputList) {
//		int n = (int) Math.sqrt(inputList.length);
//		if (n * n != inputList.length) {
//			throw new IllegalArgumentException("Array size must be a perfect square.");
//		}
//		int magicSum = ((n * n * n) + n) / 2;
//		
//		// first n are row sums, second n are column sums, second to last is RL diag, last is LR diag
//		int[] sums = new int[n*2 + 2];
//		System.out.println(sums.length);
//		
//		for (int i = 0; i < inputList.length; i++) {
//			int currentNum = inputList[i];
//			sums[i / n] += currentNum; // row
//			sums[i % n + n] += currentNum; // col, shifted over
//			if (i % (n+1) == 0) {
//				sums[2*n] += currentNum; // RL diag
//			}
//			if (i % (n-1) == 0) {
//				sums[2*n + 1] += currentNum; // LR diag
//			}
//		}
//		
//		for (int item : sums) {
//			if (item != magicSum) {
//				return false;
//			}
//			System.out.println(item);
//		}
//		return true;
//	}

}

import java.util.ArrayList;


public class EightQueens {
	private ArrayList<int[]> boardStates;
	private final int numberOfRows;
	private final int numberOfColumns;
	
	public EightQueens(int numberOfRows, int numberOfColumns){
		this.numberOfRows = numberOfRows;
		this.numberOfColumns = numberOfColumns;
	}
	
	public ArrayList<int[]> getAllBoardStates() {
		if (boardStates != null) {
			return boardStates;
		}

		boardStates = new ArrayList<int[]>();
		handleAllRowPositions(0, new int[numberOfRows]); // First row
		return boardStates;
	}

	private void handleAllRowPositions(int rowNum, int[] activeBoard) {
		for (int colNum=0; colNum<numberOfColumns; colNum++){
			//if we can put a queen in this position without conflicting with other queens, do so
			//If we put down a queen and this is the last row, copypasta up this to the return arraylist
			//If its not the last row, do the recursive call on the next row
			//If we can't put a queen down, do nothing
			
			if (canPutQueenHere(rowNum, colNum, activeBoard)) {
				activeBoard[rowNum] = colNum;
				if (rowNum == numberOfRows-1){
					boardStates.add(activeBoard.clone());
				} else {
					handleAllRowPositions(rowNum+1, activeBoard);
				}
			}
		}
	}

	private static boolean canPutQueenHere(int rowNum, int colNum, int[] activeBoard) {
		for (int row = 0; row < rowNum; row++) {
			int diagonalOffset = rowNum - row; // Always positive
			int leftDiagonal = colNum - diagonalOffset;
			int rightDiagonal = colNum + diagonalOffset;
			if (colNum == activeBoard[row] || leftDiagonal == activeBoard[row] || rightDiagonal == activeBoard[row]) {
				return false;
			}
		}
		return true;
	}

}

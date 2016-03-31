import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Searcher {
	private char[] searchArray;
	private ArrayList<Character> toReturn;

	public Searcher(char[] input) {
		searchArray = input;
	}

	public ArrayList<Character> search() {
		toReturn = new ArrayList<Character>();
		if (indexInBounds(0)) {
			breadthFirstSearch(0);
		}
		return toReturn;
	}

	private boolean indexInBounds(int index) {
		return (0 <= index) && (index < searchArray.length);
	}

	private void breadthFirstSearch(int startNodeIndex) {
//		if (!indexInBounds(startNodeIndex)) {
//			return;
//		}
//		if (searchArray[startNodeIndex] != '\0') {
//			toReturn.add(searchArray[startNodeIndex]);
//		}
//
//		Queue<Integer> bfsQueue = new LinkedList<Integer>();
//
//		int leftChildIndex = (2 * startNodeIndex) + 1;
//		if (indexInBounds(leftChildIndex)) {
//			bfsQueue.add(leftChildIndex);
//		}
//
//		int rightChildIndex = (2 * startNodeIndex) + 2;
//		if (indexInBounds(rightChildIndex)) {
//			bfsQueue.add(rightChildIndex);
//		}
//
//		evaluateQueue(bfsQueue);
				int leftChildIndex = (2 * startNodeIndex) + 1;
				int rightChildIndex = (2 * startNodeIndex) + 2;
				if (searchArray[startNodeIndex] != '\0') {
					toReturn.add(searchArray[startNodeIndex]);
					if (indexInBounds(leftChildIndex)) {
						depthFirstSearch(leftChildIndex);
					}
					if (indexInBounds(rightChildIndex)) {
						depthFirstSearch(rightChildIndex);
					}
				} else {
					Queue<Integer> bfsQueue = new LinkedList<Integer>();
					if (indexInBounds(leftChildIndex)) {
						bfsQueue.add(leftChildIndex);
					}
					if (indexInBounds(rightChildIndex)) {
						bfsQueue.add(rightChildIndex);
					}
					evaluateQueue(bfsQueue);
				}
	}

	private void evaluateQueue(Queue<Integer> bfsQueue) {
		if (bfsQueue.isEmpty()) {
			return;
		}

		int currentIndex = bfsQueue.remove();
		char currentVal = searchArray[currentIndex];
		int leftChildIndex = (2 * currentIndex) + 1;
		int rightChildIndex = (2 * currentIndex) + 2;

		if (currentVal != '\0') {
			toReturn.add(currentVal);
			if (indexInBounds(leftChildIndex)) {
				depthFirstSearch(leftChildIndex);
			}
			if (indexInBounds(rightChildIndex)) {
				depthFirstSearch(rightChildIndex);
			}
		} else {
			if (indexInBounds(leftChildIndex)) {
				bfsQueue.add(leftChildIndex);
			}
			if (indexInBounds(rightChildIndex)) {
				bfsQueue.add(rightChildIndex);
			}
		}
		evaluateQueue(bfsQueue);
	}

	private void depthFirstSearch(int startNodeIndex) {
		int leftChildIndex = (2 * startNodeIndex) + 1;
		int rightChildIndex = (2 * startNodeIndex) + 2;
		if (searchArray[startNodeIndex] != '\0') {
			toReturn.add(searchArray[startNodeIndex]);
			Queue<Integer> bfsQueue = new LinkedList<Integer>();
			if (indexInBounds(leftChildIndex)) {
				bfsQueue.add(leftChildIndex);
			}
			if (indexInBounds(rightChildIndex)) {
				bfsQueue.add(rightChildIndex);
			}
			evaluateQueue(bfsQueue);
		} else {
			if (indexInBounds(leftChildIndex)) {
				depthFirstSearch(leftChildIndex);
			}
			if (indexInBounds(rightChildIndex)) {
				depthFirstSearch(rightChildIndex);
			}
		}
	}

}

import java.util.ArrayList;
import java.util.Arrays;


public class Tree {
	int[] parentArray;

	public Tree(String string) {
		String[] nums = string.split(" ");
		this.parentArray = new int[Integer.parseInt(nums[0]) + 1];
		for (int n = 1; n < nums.length; n += 2) {
			this.parentArray[Integer.parseInt(nums[n + 1])] = Integer.parseInt(nums[n]);
		}
	}
	
	public void printTree() {
		System.out.println(Arrays.toString(this.parentArray));
	}

	public int getCommonAncestor(int i, int j) {
		int parent = 0;
		ArrayList<Integer> iParents = new ArrayList<Integer>();
		ArrayList<Integer> jParents = new ArrayList<Integer>();
		int iParent = i;
		int jParent = j;
		if (i == j) {
			return i;
		}
		while (iParent != 0) {
			iParents.add(iParent);
			iParent = this.parentArray[iParent];
		}
		while (jParent != 0) {
			jParents.add(jParent);
			jParent = this.parentArray[jParent];
		}
		
		int distanceFromEnd = 1;
		
		int currentI = iParents.get(iParents.size() - distanceFromEnd);
		int currentJ = jParents.get(jParents.size() - distanceFromEnd);
		while(currentI == currentJ) {
			// can't go any further
			if (distanceFromEnd == iParents.size() || distanceFromEnd == jParents.size()) {
				return currentI; // should be same as currentJ
			}
			distanceFromEnd++;
			currentI = iParents.get(iParents.size() - distanceFromEnd);
			currentJ = jParents.get(jParents.size() - distanceFromEnd);
		}
		
		
		return iParents.get(iParents.size() - (distanceFromEnd - 1));
	}

}

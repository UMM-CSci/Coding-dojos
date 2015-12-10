import static org.junit.Assert.*;

import org.junit.Test;


public class AncestorTest {

	@Test
	public void bigTreeTest() {
		Tree tree = new Tree("16 1 14 8 5 10 16 5 9 4 6 8 4 4 10 1 13 6 15 10 11 6 7 10 2 16 3 8 1 16 12");
		tree.printTree();
		assertEquals(4, tree.getCommonAncestor(16, 7));
		assertEquals(9, tree.getCommonAncestor(9,9));
		assertEquals(1, tree.getCommonAncestor(14,1));
		assertEquals(8, tree.getCommonAncestor(9,16));
		assertEquals(4, tree.getCommonAncestor(15,10));
	}
	
	@Test
	public void littleTreeTest() {
		Tree tree = new Tree("5 2 3 3 4 3 1 1 5");
		assertEquals(3, tree.getCommonAncestor(3, 5));
		assertEquals(2, tree.getCommonAncestor(2, 2));
		assertEquals(3, tree.getCommonAncestor(4, 5));
		assertEquals(1, tree.getCommonAncestor(1, 5));
	}

}

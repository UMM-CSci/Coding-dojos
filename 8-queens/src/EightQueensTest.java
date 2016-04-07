import static org.junit.Assert.*;

import org.junit.Test;


public class EightQueensTest {

	@Test
	public void test() {
		assertEquals(0, new EightQueens(2,2).getAllBoardStates().size());
		assertEquals(0, new EightQueens(3,3).getAllBoardStates().size());
		assertEquals(2, new EightQueens(4,4).getAllBoardStates().size());
		assertEquals(92, new EightQueens(8,8).getAllBoardStates().size());
		
		assertEquals(0, new EightQueens(10,8).getAllBoardStates().size());
		
		assertEquals(7828, new EightQueens(8,10).getAllBoardStates().size());
		
		assertEquals(7828, new EightQueens(20,20).getAllBoardStates().size());
	}

}

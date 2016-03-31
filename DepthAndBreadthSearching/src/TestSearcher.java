import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class TestSearcher {

	@Test
	public void test() {
		char[] input = {'\0', '\0', 'A', 'I', '\0', '\0', 'F', 'J', 'L', '\0', '\0', 'B',
				'E', '\0', 'G', '\0', 'K', '\0', '\0', '\0', '\0', '\0', '\0', 'C', 'D',
				'\0', '\0', '\0', 'H', '\0', '\0'};

		ArrayList<Character> expected = new ArrayList<Character>();
		for (char letter = 'A'; letter <= 'L'; letter++) {
			expected.add(letter);
		}
		
		ArrayList<Character> output = new Searcher(input).search();
		
		assertEquals(expected, output);
	}
	
	@Test
	public void test2() {
		char[] input = {'A', 'B', 'I', '\0', 'C', 'J', 'M', '\0', 'G', '\0', 'E', '\0',
				'L', 'N', 'Q', 'H', '\0', '\0', '\0', '\0', 'D', '\0', 'F', 'K', '\0',
				'\0', '\0', 'O', 'P', 'R', 'S'};
		
		ArrayList<Character> expected = new ArrayList<Character>();
		for (char letter = 'A'; letter <= 'S'; letter++) {
			expected.add(letter);
		}
		
		ArrayList<Character> output = new Searcher(input).search();
		
		assertEquals(expected, output);
	}

}

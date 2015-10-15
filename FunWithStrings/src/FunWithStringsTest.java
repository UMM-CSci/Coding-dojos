import static org.junit.Assert.*;

import org.junit.Test;


public class FunWithStringsTest {

	@Test
	public void testIsCharacterInString_a() {
		assertTrue(StringyThingies.isCharacterInString('a', "apple"));
	}
	
	@Test
	public void testIsCharacterInString_Empty() {
		assertFalse(StringyThingies.isCharacterInString('a', ""));
	}
	
	@Test
	public void testIsCharacterInString_b() {
		assertFalse(StringyThingies.isCharacterInString('b', "apple"));
	}
	
	@Test
	public void testIsCharacterInString_F() {
		assertFalse(StringyThingies.isCharacterInString('F', "fffff"));
	}
	
	@Test
	public void testIsCharacterInString_WeirdCharacter() {
		assertTrue(StringyThingies.isCharacterInString('$', "ke$ha"));
	}
	
	// Next Block!
	
	@Test
	public void testCountCharacterOccurrencesInString_a() {
		assertEquals(2, StringyThingies.countCharacterOccurrencesInString('a', "animal"));
	}
	
	@Test
	public void testCountCharacterOccurrencesInString_Q() {
		assertEquals(1, StringyThingies.countCharacterOccurrencesInString('Q', "Quill quarters"));
	}
	
//	// Next Block!
	
	@Test
	public void testHasEveryLetterOfAlphabet_Fox() {
		assertTrue(StringyThingies.hasEveryLetterOfAlphabet("the quick brown fox jumps over the lazy dog"));
	}
	
	@Test
	public void testHasEveryLetterOfAlphabet_Burger() {
		assertFalse(StringyThingies.hasEveryLetterOfAlphabet("burger"));
	}
	
//	// Next Block!
//	
	@Test
	public void testIsPalindrome_OddLetters() {
		assertTrue(StringyThingies.isPalindrome("level"));
	}
	
	@Test
	public void testIsPalindrome_EvenLetters() {
		assertTrue(StringyThingies.isPalindrome("noon"));
	}
	
	@Test
	public void testIsPalindrome_NotPalindrome() {
		assertFalse(StringyThingies.isPalindrome("batman"));
	}
	
	// Next Block!
	
	@Test
	public void testAreAnagrams_True() {
		assertTrue(StringyThingies.areAnagrams("silent", "listen"));
	}
	
	@Test
	public void testAreAnagrams_False() {
		assertFalse(StringyThingies.areAnagrams("dinner", "breakfast"));
	}
	
	@Test
	public void testAreAnagrams_True2() {
		assertTrue(StringyThingies.areAnagrams("silentt", "listent"));
	}
	
	@Test
	public void testAreAnagrams_False2() {
		assertFalse(StringyThingies.areAnagrams("silentt", "listenn"));
	}
	
	// Next Block!
	
	@Test
	public void testFullHouse1() {
		assertTrue(StringyThingies.hasFullHouse("TT333"));
	}
	
	@Test
	public void testFullHouse2() {
		assertTrue(StringyThingies.hasFullHouse("24242"));
	}
	
	@Test
	public void testFullHouse3() {
		assertFalse(StringyThingies.hasFullHouse("YYZZZ"));
	}
	
	@Test
	public void testFullHouse4() {
		assertFalse(StringyThingies.hasFullHouse("23456"));
	}
	
	@Test
	public void testAllAreCards() {
		assertTrue(StringyThingies.allAreCards("23456789TJQKA"));
		assertFalse(StringyThingies.allAreCards("Nope"));
	}
	
	// Next Block!
	
	@Test
	public void testSwitcharoo1() {
		assertEquals("tsa fsnur esro hehT", StringyThingies.switcharoo("The horse runs fast"));
	}
	
	@Test
	public void testSwitcharoo2() {
		assertEquals(" s emiT ojo dehtevolI ", StringyThingies.switcharoo(" I love the dojoTimes "));
	}
	
	@Test
	public void testSwitcharoo3() {
		assertEquals("K oo rKat onm'Idn are lge iZk c aJmaI", StringyThingies.switcharoo("I am Jack Ziegler and I'm not a KrooK"));
	}
	
	@Test
	public void testSwitcharoo4() {
		assertEquals("YOLO SWAGGING", StringyThingies.switcharoo("GNIG GAWSOLOY"));
	}
	
	@Test
	public void testSwitcharoo5() {
		assertEquals("  YD  DUBIH ", StringyThingies.switcharoo("  HI  BUDDY "));
	}
	
	@Test
	public void testSwitcharoo6() {
		assertEquals("B Q", StringyThingies.switcharoo("Q B"));
	}
	
	@Test
	public void testSwitcharoo7() {
		assertEquals("B  Q", StringyThingies.switcharoo("Q  B"));
	}
	
	@Test
	public void testSwitcharoo8() {
		assertEquals("BQ A  Q", StringyThingies.switcharoo("QA Q  B"));
	}
	
	@Test
	public void testExclusiveOr() {
		assertTrue(true ^ false);
		assertTrue(false ^ true);
		assertFalse(true ^ true);
		assertFalse(false ^ false);
	}
	
	@Test
	public void testExclusiveOrBitwise() {
		assertEquals(0x11111111, 0x10101010 ^ 0x01010101);
	}
}

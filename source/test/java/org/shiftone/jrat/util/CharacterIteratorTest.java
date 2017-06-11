package org.shiftone.jrat.util;

import org.junit.Test;
import static org.junit.Assert.*;

public class CharacterIteratorTest {

	@Test
	public void testGet(){
		CharacterIterator ci = new CharacterIterator("abc123");
		
		boolean bresult = ci.next();
		assertEquals(true, bresult);
		
		char cresult = ci.get();		
		assertEquals('a', cresult);
	}
	
	@Test
	public void testGetEnd(){
		CharacterIterator ci = new CharacterIterator(new char[]{'a'});
		
		boolean bresult = ci.next();
		assertEquals(true, bresult);
		
		char cresult = ci.get();		
		assertEquals('a', cresult);
		
		bresult = ci.next();
		assertEquals(false, bresult);
		
		cresult = ci.get();		
		assertEquals('a', cresult);
		
	}
	
	@Test
	public void testGetEmpty(){
		CharacterIterator ci = new CharacterIterator("");
		
		boolean bresult = ci.next();
		assertEquals(false, bresult);
	}
	
}

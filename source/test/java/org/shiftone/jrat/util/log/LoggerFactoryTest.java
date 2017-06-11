package org.shiftone.jrat.util.log;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoggerFactoryTest {

	@Test
	public void testGetLoggerClass(){
		LoggerFactoryManager.setLevel(4);
		Logger g = LoggerFactory.getLogger(String.class);
		
		assertEquals(true, g.isLevelEnabled("String", 4));
	}
	
	@Test
	public void testGetLoggerString(){
		LoggerFactoryManager.setLevel(4);
		Logger g = LoggerFactory.getLogger("test1");
		
		assertEquals(true, g.isLevelEnabled("test1", 4));
	}	
}

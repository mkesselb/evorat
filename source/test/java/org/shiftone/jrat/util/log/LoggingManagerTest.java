package org.shiftone.jrat.util.log;

import org.junit.Test;
import org.shiftone.jrat.core.JRatException;
import org.shiftone.jrat.util.log.target.NullLogTarget;
import org.shiftone.jrat.util.log.target.WriterLogTarget;

import static org.junit.Assert.*;

public class LoggingManagerTest {

	@Test
	public void testMakeLevelLoud(){
		LoggingManager m = new LoggingManager();
		
		m.makeLevelLoud();
		String level = m.getLevel();
		assertEquals("TRACE", level);
	}
	
	@Test
	public void testSetLevel(){
		LoggingManager m = new LoggingManager();
		
		m.setLevel("ERROR");
		String level = m.getLevel();
		assertEquals("ERROR", level);
	}
	
	@Test(expected=JRatException.class)
	public void testSetLevelWrong(){
		LoggingManager m = new LoggingManager();
		
		m.setLevel("SDF");
	}
	
	@Test
	public void testGetLevel(){
		LoggingManager m = new LoggingManager();
		
		m.setLevel("INFO");
		String level = m.getLevel();
		assertEquals("INFO", level);
	}
	
	@Test
	public void testDisableLogging(){
		LoggingManager m = new LoggingManager();
		
		m.disableLogging();
		assertEquals(NullLogTarget.class, LoggerFactoryManager.getLogTarget().getClass());
	}
	
	@Test
	public void testEnableSystemOutLogging(){
		LoggingManager m = new LoggingManager();
		
		m.enableSystemOutLogging();
		assertEquals(WriterLogTarget.class, LoggerFactoryManager.getLogTarget().getClass());
	}
	
}

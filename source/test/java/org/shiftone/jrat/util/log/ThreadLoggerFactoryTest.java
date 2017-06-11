package org.shiftone.jrat.util.log;

import org.junit.Test;
import org.shiftone.jrat.util.log.target.ThreadLocalLogTarget;

import static org.junit.Assert.*;

public class ThreadLoggerFactoryTest {

	@Test
	public void testExecuteInThreadScope(){
		LoggerFactoryManager.enableThreadBasedLogging();
		
		Runnable r = new Runnable(){
			public void run(){
				
			}
		};
		
		ThreadLoggerFactory.executeInThreadScope(new ThreadLocalLogTarget(), r);
		assertEquals(true, true);
	}
	
}

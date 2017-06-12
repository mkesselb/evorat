package org.shiftone.jrat.util.log;

import org.junit.Test;
import org.shiftone.jrat.util.log.target.LogTarget;
import org.shiftone.jrat.util.log.target.TandemTarget;

import static org.junit.Assert.*;

import java.io.PrintWriter;

public class LoggerFactoryManagerTest {
	
	//rest of LoggerFactoryManager already tested through LoggingManagerTest
	
	@Test
	public void testRedirectLogging(){
		LoggerFactoryManager.redirectLogging(new PrintWriter(System.out));
		
		LogTarget t = LoggerFactoryManager.getLogTarget();
		assertTrue(t instanceof TandemTarget);
	}
	
}

package org.shiftone.jrat.util;

import static org.junit.Assert.*;

import java.io.PrintWriter;

import org.junit.Test;
import org.shiftone.jrat.core.JRatException;
import org.shiftone.jrat.util.log.Logger;
import org.shiftone.jrat.util.log.LoggerFactory;
import org.shiftone.jrat.util.log.target.LogTarget;
import org.shiftone.jrat.util.log.target.ProxyLogTarget;
import org.shiftone.jrat.util.log.target.TandemTarget;
import org.shiftone.jrat.util.log.target.WriterLogTarget;

public class LoggerFactorTest {

	@Test
	public void getLevelFromName() {
		String testCase = "ERROR";
		int result = LoggerFactory.getLevelFromName(testCase);
		assertEquals(4, result);
	}
		
    public void testSetLevel() {
    	int testCase = 4; 
    	LoggerFactory.setLevel(testCase);
    	int result = LoggerFactory.getLevel();
    	assertEquals(result, testCase);
    }

/*
    public void testGetLevel() {
    	
    	LoggerFactory.setLevel(4);
    	assertEquals(4, LoggerFactory.getLevel());
    }


    public static void disableLogging() {
        setLogTarget(NULL_LOG_TARGET);
    }


    public static void enableThreadBasedLogging() {
        setLogTarget(THREAD_TARGET);
    }


    public static void enableSystemOutLogging() {
        setLogTarget(SYSTEM_OUT_TARGET);
    }

    public static synchronized void setLogTarget(LogTarget logTarget) {
        PROXY_LOG_TARGET.setLogTarget(logTarget);
    }

    public static synchronized LogTarget getLogTarget() {
        return PROXY_LOG_TARGET.getLogTarget();
    }

    public static void redirectLogging(PrintWriter printWriter) {

        TandemTarget tandemTarget = new TandemTarget(SYSTEM_OUT_TARGET, new WriterLogTarget(printWriter));

        setLogTarget(tandemTarget);
    }
*/
}

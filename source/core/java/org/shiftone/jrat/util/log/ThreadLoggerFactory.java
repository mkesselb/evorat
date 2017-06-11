package org.shiftone.jrat.util.log;

import org.shiftone.jrat.util.log.target.LogTarget;

public class ThreadLoggerFactory extends AbstractLoggerFactory {
	
	private ThreadLoggerFactory() {
		//prevent instance
	}
	
    /**
     * this will only have any effect on logging if the current mode is using
     * the ThreadLocalLogTarget - meaning a call to enableDesktopLoggingMode was
     * made.
     */
    public static void executeInThreadScope(LogTarget newTarget, Runnable runnable) {
        THREAD_TARGET.executeInScope(newTarget, runnable);
    }

}
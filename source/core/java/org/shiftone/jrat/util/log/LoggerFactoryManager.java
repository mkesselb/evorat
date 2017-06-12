package org.shiftone.jrat.util.log;

import java.io.PrintWriter;

import org.shiftone.jrat.core.JRatException;
import org.shiftone.jrat.util.Assert;
import org.shiftone.jrat.util.log.target.LogTarget;
import org.shiftone.jrat.util.log.target.TandemTarget;
import org.shiftone.jrat.util.log.target.WriterLogTarget;

public class LoggerFactoryManager extends AbstractLoggerFactory {
	
	private LoggerFactoryManager(){
		//prevent instance
	}

    public static void setLevel(int level) {
        PROXY_LOG_TARGET.setCurrentLevel(level);
    }
    
    public static void setLevelFromName(String levelName){
    	int level = getLevelFromName(levelName);
    	setLevel(level);
    }

    public static int getLevel() {
        return PROXY_LOG_TARGET.getCurrentLevel();
    }
    
    private static int getLevelFromName(String levelName) {

        Assert.assertNotNull("levelName", levelName);
        Assert.assertNotNull("LEVEL_NAMES", LEVEL_NAMES);

        levelName = levelName.toUpperCase();

        for (int i = 0; i < LEVEL_NAMES.length; i++) {
            if (levelName.equals(LEVEL_NAMES[i])) {
                return i;
            }
        }

        throw new JRatException("log level '" + levelName + "' is not known");
    }
    
    public static void enableThreadBasedLogging() {
        LoggerFactoryManager.setLogTarget(THREAD_TARGET);
    }
    
    public static void disableLogging() {
        setLogTarget(NULL_LOG_TARGET);
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
    
}

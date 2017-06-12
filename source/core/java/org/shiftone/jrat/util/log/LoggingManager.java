package org.shiftone.jrat.util.log;


/**
 * @author jeff@shiftone.org (Jeff Drost)
 */
public class LoggingManager implements Constants, LoggingManagerMBean {

    public void makeLevelLoud() {
        LoggerFactoryManager.setLevel(LEVEL_TRACE);
    }

    public void setLevel(String levelName) {
    	LoggerFactoryManager.setLevelFromName(levelName);
    }

    public String getLevel() {
        return LEVEL_NAMES[LoggerFactoryManager.getLevel()];
    }

    public void disableLogging() {
    	LoggerFactoryManager.disableLogging();
    }

    public void enableSystemOutLogging() {
    	LoggerFactoryManager.enableSystemOutLogging();
    }
}

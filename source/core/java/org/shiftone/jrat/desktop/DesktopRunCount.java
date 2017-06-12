package org.shiftone.jrat.desktop;

/**
* Refactoring: added whole class, so resolve schizophrenic class 
* DesktopPreferences (s2paster)
*/
public class DesktopRunCount extends DesktopPreferences {
	public static int getRunCount() {
        return PREFS.getInt(RUN_COUNT, 0);
    }

    public static void setRunCount(int runCount) {
        PREFS.putInt(RUN_COUNT, runCount);
    }
    
    public static void incrementRunCount() {
        setRunCount(getRunCount() + 1);
    }
    
    public static long getLastRunTime() {
        return PREFS.getLong(LAST_RUN_TIME, 0);
    }

    public static void setLastRunTime(long lastRunTime) {
        PREFS.putLong(LAST_RUN_TIME, lastRunTime);
    }
}

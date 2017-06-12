package org.shiftone.jrat.desktop;

/**
* Refactoring: added whole class, so resolve schizophrenic class 
* DesktopPreferences (s2paster)
*/
public class DesktopTips extends DesktopPreferences {
	public static boolean isShowTipsOnStartup() {
        return PREFS.getBoolean(TIPS_ON_START, true);
    }

    public static void setShowTipsOnStartup(boolean showTipsOnStartup) {
        PREFS.putBoolean(TIPS_ON_START, showTipsOnStartup);
    }
}

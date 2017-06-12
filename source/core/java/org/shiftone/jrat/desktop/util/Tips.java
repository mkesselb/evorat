package org.shiftone.jrat.desktop.util;

import org.jdesktop.swingx.JXTipOfTheDay;
import org.jdesktop.swingx.tips.TipLoader;
import org.jdesktop.swingx.tips.TipOfTheDayModel;
import org.shiftone.jrat.desktop.DesktopTips;
import org.shiftone.jrat.util.io.ResourceUtil;

import java.awt.*;
import java.util.Random;

/**
 * @author (jeff@shiftone.org) Jeff Drost
 */
public class Tips {

    private static final TipOfTheDayModel MODEL = TipLoader.load(
            ResourceUtil.getResourceAsProperties(
                    "org/shiftone/jrat/desktop/tips.properties"
            )
    );

    private static final JXTipOfTheDay TOTD = new JXTipOfTheDay(MODEL);

    public static void show(Component parent, boolean force) {
        TOTD.setCurrentTip(new Random().nextInt(MODEL.getTipCount() - 1));
        TOTD.showDialog(parent, new Choice(), force);
    }

    private static class Choice implements JXTipOfTheDay.ShowOnStartupChoice {
    	// Refactoring: changed DesktopPreferences to DesktopTips (s2paster)
        public void setShowingOnStartup(boolean showOnStartup) {
            DesktopTips.setShowTipsOnStartup(showOnStartup);
        }

        // Refactoring: changed DesktopPreferences to DesktopTips (s2paster)
        public boolean isShowingOnStartup() {
            return DesktopTips.isShowTipsOnStartup();
        }
    }
}

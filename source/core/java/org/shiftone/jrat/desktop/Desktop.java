package org.shiftone.jrat.desktop;

import org.shiftone.jrat.desktop.util.Tips;
import org.shiftone.jrat.util.log.LoggerFactoryManager;

/**
 * @author jeff@shiftone.org (Jeff Drost)
 */
public class Desktop {

    public static void main(String[] args) {
    	LoggerFactoryManager.enableThreadBasedLogging();
        DesktopFrame frame = new DesktopFrame();
        frame.setVisible(true);
        Tips.show(frame, false);
    }
}

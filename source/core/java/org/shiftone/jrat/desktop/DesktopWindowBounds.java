package org.shiftone.jrat.desktop;

import java.awt.Rectangle;

import org.shiftone.jrat.util.StringUtil;

/**
* Refactoring: added whole class, so resolve schizophrenic class 
* DesktopPreferences (s2paster)
*/
public class DesktopWindowBounds extends DesktopPreferences {
	public static Rectangle getWindowBounds() {

        String text = PREFS.get(WINDOW_BOUNDS, null);
        if (text != null) {
            String[] values = StringUtil.tokenize(text, ",", false);
            // x, y, width, height
            return new Rectangle(
                    Integer.parseInt(values[0]),
                    Integer.parseInt(values[1]),
                    Integer.parseInt(values[2]),
                    Integer.parseInt(values[3]));
        }
        return null;
    }

    public static void setWindowBounds(Rectangle bounds) {
        PREFS.put(WINDOW_BOUNDS, bounds.x + "," + bounds.y + "," + bounds.width + "," + bounds.height);
    }
}

package org.shiftone.jrat.desktop;

import org.shiftone.jrat.util.StringUtil;

import java.awt.*;
import java.io.File;
import java.util.prefs.Preferences;

/**
 * @author jeff@shiftone.org (Jeff Drost)
 *
 *
 * Refactoring: changed all private constants to public (s2paster)
 */
public class DesktopPreferences {
    protected static final Preferences PREFS = Preferences.userNodeForPackage(DesktopPreferences.class);
    protected static final String RUN_COUNT = "run_count";
    protected static final String TIPS_ON_START = "show_tips_on_startup";
    protected static final String LAST_RUN_TIME = "last_run_time";
    protected static final String LAST_OPENED_FILE = "last_opened_file";
    protected static final String WINDOW_BOUNDS = "window_bounds";
    protected static final String LAST_INJECTED_FILE = "last_injected_file";
    protected static final String LAST_INJECTED_DIR = "last_injected_dir";

}

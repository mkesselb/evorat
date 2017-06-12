package org.shiftone.jrat.desktop;

import java.io.File;

/**
* Refactoring: added whole class, so resolve schizophrenic class 
* DesktopPreferences (s2paster)
*/
public class DesktopLastFile extends DesktopPreferences {
	public static File getLastOpenedFile() {
        return getFile(LAST_OPENED_FILE);
    }

    public static void setLastOpenedFile(File file) {
        setFile(LAST_OPENED_FILE, file);
    }

    public static File getLastInjectedFile() {
        return getFile(LAST_INJECTED_FILE);
    }

    public static void setLastInjectedFile(File file) {
        setFile(LAST_INJECTED_FILE, file);
    }

    public static File getLastInjectedDir() {
        return getFile(LAST_INJECTED_DIR);
    }

    public static void setLastInjectedDir(File file) {
        setFile(LAST_INJECTED_DIR, file);
    }


    private static File getFile(String key) {
        String name = PREFS.get(key, null);
        return name == null ? null : new File(name);
    }

    private static void setFile(String key, File value) {
        PREFS.put(key, value == null ? null : value.getAbsolutePath());
    }
}

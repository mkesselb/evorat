package org.shiftone.jrat.desktop.action.inject;

import org.shiftone.jrat.desktop.DesktopFrame;
import org.shiftone.jrat.desktop.DesktopLastFile;

import javax.swing.*;
import java.io.File;

/**
 * @author (jeff@shiftone.org) Jeff Drost
 */
public class InjectDirectoryAction extends AbstractInjectAction {

    public InjectDirectoryAction(DesktopFrame desktopFrame) {
        super("Inject Directory",
                desktopFrame,
                JFileChooser.DIRECTORIES_ONLY,
                "Select Directory to Inject");
    }

    protected void setLastInjected(File file) {
    	// Refactoring: changed DesktopPreferences to DesktopLastFile (s2paster)
    	DesktopLastFile.setLastInjectedDir(file);
    }

    protected File getLastInjected() {
    	// Refactoring: changed DesktopPreferences to DesktopLastFile (s2paster)
    	return DesktopLastFile.getLastInjectedDir();
    }


}

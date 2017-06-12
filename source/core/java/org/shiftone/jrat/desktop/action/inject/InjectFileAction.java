package org.shiftone.jrat.desktop.action.inject;

import org.shiftone.jrat.desktop.DesktopFrame;
import org.shiftone.jrat.desktop.DesktopLastFile;

import javax.swing.*;
import java.io.File;

/**
 * @author (jeff@shiftone.org) Jeff Drost
 */
public class InjectFileAction extends AbstractInjectAction {

    public InjectFileAction(DesktopFrame desktopFrame) {
        super("Inject File",
                desktopFrame,
                JFileChooser.FILES_ONLY,
                "Select File to Inject");
    }

    protected void setLastInjected(File file) {
    	// Refactoring: changed DesktopPreferences to DesktopLastFile (s2paster)
    	DesktopLastFile.setLastInjectedFile(file);
    }

    protected File getLastInjected() {
    	// Refactoring: changed DesktopPreferences to DesktopLastFile (s2paster)
    	return DesktopLastFile.getLastInjectedFile();
    }
}

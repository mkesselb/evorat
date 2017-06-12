package org.shiftone.jrat.desktop;

import org.junit.Test;
import org.shiftone.jrat.desktop.DesktopPreferences;
import static org.junit.Assert.*;
import java.awt.Rectangle;
import java.io.File;

public class DesktopPreferencesTest {
	
	@Test
	public void testGetRunCount(){
		DesktopPreferences.setRunCount(2);
		int result = DesktopPreferences.getRunCount();
		assertEquals(2, result);
	}
	
	@Test
	public void testSetRunCount(){
		DesktopPreferences.setRunCount(2);
		assertEquals(DesktopPreferences.getRunCount(), 2);
	}
	
	
	@Test
	public void testIncrementRunCount() {
		int beforeIncrement = DesktopPreferences.getRunCount();
		DesktopPreferences.incrementRunCount();
		int afterIncrement = DesktopPreferences.getRunCount();
		
		assertEquals(beforeIncrement+1, afterIncrement);
	}

	@Test
    public void testIsShowTipsOnStartup() {
		DesktopPreferences.setShowTipsOnStartup(true);	
		boolean tips = DesktopPreferences.isShowTipsOnStartup();
		
		assertEquals(true, tips);
    }

	@Test
    public void testSetShowTipsOnStartup() {
		DesktopPreferences.setShowTipsOnStartup(false);
		
		assertEquals(DesktopPreferences.isShowTipsOnStartup(), false);
    }

	@Test
    public void testGetLastRunTime() {
		DesktopPreferences.setLastRunTime(2147483648L);
		long result = DesktopPreferences.getLastRunTime();
		assertEquals(2147483648L, result);
    }

	@Test
    public void testSetLastRunTime() {
		DesktopPreferences.setLastRunTime(2147483648L);
		assertEquals(DesktopPreferences.getLastRunTime(),2147483648L);
    }

	@Test
    public void testGetWindowBounds() {
		Rectangle testCase = new Rectangle(0, 0, -1, -1);
		DesktopPreferences.setWindowBounds(testCase);
		Rectangle result = DesktopPreferences.getWindowBounds();
		assertEquals(testCase, result);
    }
	
	@Test
    public void testSetWindowBounds() {
		Rectangle testCase = new Rectangle(0, 0, -1, -1);
		DesktopPreferences.setWindowBounds(testCase);
		assertEquals(DesktopPreferences.getWindowBounds(),testCase);
    }

	@Test
    public void testGetLastOpenedFile() {
		File testCase = new File("C:/Users/stefan/Documents/Eclipse-Workspace/Jevorat/testFile");
		DesktopPreferences.setLastOpenedFile(testCase);
		File result = DesktopPreferences.getLastOpenedFile();
		assertEquals(testCase, result);
    }

	@Test
    public void testSetLastOpenedFile() {
		File testCase = new File("C:/Users/stefan/Documents/Eclipse-Workspace/Jevorat/testFile");
		DesktopPreferences.setLastOpenedFile(testCase);
		assertEquals(DesktopPreferences.getLastOpenedFile(),testCase);
    }

	@Test
    public void testGetLastInjectedFile() {
		File testCase = new File("C:/Users/stefan/Documents/Eclipse-Workspace/Jevorat/testFile");
		DesktopPreferences.setLastInjectedFile(testCase);
		File result = DesktopPreferences.getLastInjectedFile();
		assertEquals(testCase, result);
    }

	@Test
    public void testSetLastInjectedFile() {
		File testCase = new File("C:/Users/stefan/Documents/Eclipse-Workspace/Jevorat/testFile");
		DesktopPreferences.setLastInjectedFile(testCase);
		assertEquals(DesktopPreferences.getLastInjectedFile(),testCase);
    }

	@Test
    public void testGetLastInjectedDir() {
		File testCase = new File("C:/Users/stefan/Documents/Eclipse-Workspace/Jevorat/testFile");
		DesktopPreferences.setLastInjectedDir(testCase);
		File result = DesktopPreferences.getLastInjectedDir();
		assertEquals(testCase, result);
    }

	@Test
    public void testSetLastInjectedDir() {
		File testCase = new File("C:/Users/stefan/Documents/Eclipse-Workspace/Jevorat/testFile");
		DesktopPreferences.setLastInjectedDir(testCase);
		assertEquals(DesktopPreferences.getLastInjectedDir(),testCase);
    }
}
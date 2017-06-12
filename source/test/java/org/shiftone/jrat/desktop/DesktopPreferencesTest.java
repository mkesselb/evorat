package org.shiftone.jrat.desktop;

import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.Rectangle;
import java.io.File;

public class DesktopPreferencesTest {
	
	@Test
	public void testGetRunCount(){
		DesktopRunCount.setRunCount(2);
		int result = DesktopRunCount.getRunCount();
		assertEquals(2, result);
	}
	
	@Test
	public void testSetRunCount(){
		DesktopRunCount.setRunCount(2);
		assertEquals(DesktopRunCount.getRunCount(), 2);
	}
	
	
	@Test
	public void testIncrementRunCount() {
		int beforeIncrement = DesktopRunCount.getRunCount();
		DesktopRunCount.incrementRunCount();
		int afterIncrement = DesktopRunCount.getRunCount();
		
		assertEquals(beforeIncrement+1, afterIncrement);
	}

	@Test
    public void testIsShowTipsOnStartup() {
		DesktopTips.setShowTipsOnStartup(true);	
		boolean tips = DesktopTips.isShowTipsOnStartup();
		
		assertEquals(true, tips);
    }

	@Test
    public void testSetShowTipsOnStartup() {
		DesktopTips.setShowTipsOnStartup(false);
		
		assertEquals(DesktopTips.isShowTipsOnStartup(), false);
    }

	@Test
    public void testGetLastRunTime() {
		DesktopRunCount.setLastRunTime(2147483648L);
		long result = DesktopRunCount.getLastRunTime();
		assertEquals(2147483648L, result);
    }

	@Test
    public void testSetLastRunTime() {
		DesktopRunCount.setLastRunTime(2147483648L);
		assertEquals(DesktopRunCount.getLastRunTime(),2147483648L);
    }

	@Test
    public void testGetWindowBounds() {
		Rectangle testCase = new Rectangle(0, 0, -1, -1);
		DesktopWindowBounds.setWindowBounds(testCase);
		Rectangle result = DesktopWindowBounds.getWindowBounds();
		assertEquals(testCase, result);
    }
	
	@Test
    public void testSetWindowBounds() {
		Rectangle testCase = new Rectangle(0, 0, -1, -1);
		DesktopWindowBounds.setWindowBounds(testCase);
		assertEquals(DesktopWindowBounds.getWindowBounds(),testCase);
    }

	@Test
    public void testGetLastOpenedFile() {
		File testCase = new File("C:/Users/stefan/Documents/Eclipse-Workspace/Jevorat/testFile");
		DesktopLastFile.setLastOpenedFile(testCase);
		File result = DesktopLastFile.getLastOpenedFile();
		assertEquals(testCase, result);
    }

	@Test
    public void testSetLastOpenedFile() {
		File testCase = new File("C:/Users/stefan/Documents/Eclipse-Workspace/Jevorat/testFile");
		DesktopLastFile.setLastOpenedFile(testCase);
		assertEquals(DesktopLastFile.getLastOpenedFile(),testCase);
    }

	@Test
    public void testGetLastInjectedFile() {
		File testCase = new File("C:/Users/stefan/Documents/Eclipse-Workspace/Jevorat/testFile");
		DesktopLastFile.setLastInjectedFile(testCase);
		File result = DesktopLastFile.getLastInjectedFile();
		assertEquals(testCase, result);
    }

	@Test
    public void testSetLastInjectedFile() {
		File testCase = new File("C:/Users/stefan/Documents/Eclipse-Workspace/Jevorat/testFile");
		DesktopLastFile.setLastInjectedFile(testCase);
		assertEquals(DesktopLastFile.getLastInjectedFile(),testCase);
    }

	@Test
    public void testGetLastInjectedDir() {
		File testCase = new File("C:/Users/stefan/Documents/Eclipse-Workspace/Jevorat/testFile");
		DesktopLastFile.setLastInjectedDir(testCase);
		File result = DesktopLastFile.getLastInjectedDir();
		assertEquals(testCase, result);
    }

	@Test
    public void testSetLastInjectedDir() {
		File testCase = new File("C:/Users/stefan/Documents/Eclipse-Workspace/Jevorat/testFile");
		DesktopLastFile.setLastInjectedDir(testCase);
		assertEquals(DesktopLastFile.getLastInjectedDir(),testCase);
    }
}
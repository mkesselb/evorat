package org.shiftone.jrat.desktop;

import org.junit.Test;
import org.shiftone.jrat.desktop.util.Column;

import static org.junit.Assert.*;

public class ColumnTest {
	
	@Test
	public void testGetIndex(){
		Column c = new Column(0, "column1", String.class, true);
		
		int result = c.getIndex();
		assertEquals(0, result);
	}
	
	@Test
	public void testGetName(){
		Column c = new Column(0, "column1", String.class, true);
		
		String result = c.getName();
		assertEquals("column1", result);
	}
	
	@Test
	public void testGetType(){
		Column c = new Column(0, "column1", String.class, true);
		
		Class<?> result = c.getType();
		assertEquals(String.class, result);
	}
	
	@Test
	public void testIsDefaultVisible(){
		Column c = new Column(0, "column1", String.class, true);
		
		boolean result = c.isDefaultVisible();
		assertEquals(true, result);
	}
}

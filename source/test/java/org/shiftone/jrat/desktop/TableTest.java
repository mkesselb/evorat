package org.shiftone.jrat.desktop;

import org.junit.Test;
import org.shiftone.jrat.desktop.util.tables.AbstractTable;
import org.shiftone.jrat.desktop.util.tables.Column;
import org.shiftone.jrat.desktop.util.tables.Table;

import static org.junit.Assert.*;

import java.util.List;

public class TableTest {

	@Test
	public void testGetColumns(){
		AbstractTable t = new Table();
		
		t.column("1");
		t.column("2");
		
		List<Column> lc = t.getColumns();
		int count = lc.size();
		Column c = lc.get(0);
		int index = c.getIndex();
		assertEquals(2, count);
		assertEquals(0, index);
	}
	
	@Test
	public void testGetColumn(){
		AbstractTable t = new Table();
		
		t.column("1");
		t.column("2");
		
		Column c = t.getColumn(1);
		
		String name = c.getName();
		assertEquals("2", name);
	}
	
	@Test
	public void testGetColumnCount(){
		AbstractTable t = new Table();
		
		t.column("1");
		t.column("2");
		
		int count = t.getColumnCount();
		assertEquals(2, count);
	}
	
	@Test
	public void testGetColumnCountEmpty(){
		AbstractTable t = new Table();
		
		int count = t.getColumnCount();
		assertEquals(0, count);
	}
	
	@Test
	public void testSmallColumnCall(){
		AbstractTable t = new Table();
		t.column("column1");
		
		Column c = t.getColumn(0);
		int index = c.getIndex();
		String name = c.getName();
		Class<?> clas = c.getType();
		boolean visible = c.isDefaultVisible();
		
		assertEquals(0, index);
		assertEquals("column1", name);
		assertEquals(Object.class, clas);
		assertEquals(true, visible);
	}
	
	@Test
	public void testMediumColumnCall(){
		AbstractTable t = new Table();
		t.column("column1", false);
		
		Column c = t.getColumn(0);
		int index = c.getIndex();
		String name = c.getName();
		Class<?> clas = c.getType();
		boolean visible = c.isDefaultVisible();
		
		assertEquals(0, index);
		assertEquals("column1", name);
		assertEquals(Object.class, clas);
		assertEquals(false, visible);
	}
}

package org.shiftone.jrat.provider.tree;

import org.junit.Test;
import org.shiftone.jrat.desktop.util.tables.Column;
import org.shiftone.jrat.desktop.util.tables.SummaryTable;
import org.shiftone.jrat.provider.tree.ui.TraceTreeNode;
import org.shiftone.jrat.provider.tree.ui.summary.IMethodSummaryModel;
import org.shiftone.jrat.provider.tree.ui.summary.MethodSummaryModel;
import org.shiftone.jrat.provider.tree.ui.summary.SummaryTableModel;

import static org.junit.Assert.*;

import java.util.List;

public class SummaryTableModelTest {
	
	@Test
	public void testGetColumns(){
		List<Column> c = SummaryTableModel.getColumns();
		assertEquals(17, c.size());
	}
	
	@Test
	public void testGetRowCountEmpty(){
		TraceTreeNode t = new TraceTreeNode(new TreeNode());
		IMethodSummaryModel m = new MethodSummaryModel(t);
		SummaryTableModel s = new SummaryTableModel(m);
		
		int r = s.getRowCount();
		assertEquals(0, r);
	}
	
	@Test
	public void testGetRowCount(){
		IMethodSummaryModel m = new TestMethodSummaryModel();
		SummaryTableModel s = new SummaryTableModel(m);
		
		int r = s.getRowCount();
		assertEquals(1, r);
	}
	
	@Test
	public void testGetColumnCount(){
		TraceTreeNode t = new TraceTreeNode(new TreeNode());
		IMethodSummaryModel m = new MethodSummaryModel(t);
		SummaryTableModel s = new SummaryTableModel(m);
		
		int c = s.getColumnCount();
		assertEquals(17, c);
	}
	
	@Test
	public void testGetColumnName(){
		TraceTreeNode t = new TraceTreeNode(new TreeNode());
		IMethodSummaryModel m = new MethodSummaryModel(t);
		SummaryTableModel s = new SummaryTableModel(m);
		
		String n = s.getColumnName(16);
		assertEquals("Total Callers", n);
	}
	
	@Test
	public void testGetValueAtMethodSummary(){
		IMethodSummaryModel m = new TestMethodSummaryModel();
		SummaryTableModel s = new SummaryTableModel(m);
		
		Object o = s.getValueAt(0, 3);
		assertEquals("int,char", o.toString());
	}
	
	@Test
	public void testGetValueAtPercent(){
		IMethodSummaryModel m = new TestMethodSummaryModel();
		SummaryTableModel s = new SummaryTableModel(m);
		
		Object o = s.getValueAt(0, 14);
		assertEquals("100,0", o.toString());
	}
	
	@Test
	public void testGetColumn(){
		IMethodSummaryModel m = new TestMethodSummaryModel();
		SummaryTableModel s = new SummaryTableModel(m);
		
		Column c = s.getColumn(SummaryTable.AVERAGE);
		assertEquals("Average ms", c.getName());
	}
	
	@Test
	public void testGetColumnNull(){
		IMethodSummaryModel m = new TestMethodSummaryModel();
		SummaryTableModel s = new SummaryTableModel(m);
		
		Column c = s.getColumn("sdf");
		assertEquals(null, c);
	}
}
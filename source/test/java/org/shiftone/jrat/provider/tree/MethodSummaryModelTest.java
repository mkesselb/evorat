package org.shiftone.jrat.provider.tree;

import org.junit.Test;
import org.shiftone.jrat.core.MethodKey;
import org.shiftone.jrat.provider.tree.ui.TraceTreeNode;
import org.shiftone.jrat.provider.tree.ui.summary.IMethodSummary;
import org.shiftone.jrat.provider.tree.ui.summary.IMethodSummaryModel;
import org.shiftone.jrat.provider.tree.ui.summary.MethodSummaryModel;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

public class MethodSummaryModelTest {
	
	@Test
	public void testCreateMethodSummaryModelEmpty(){
		TraceTreeNode t = new TraceTreeNode(new TreeNode());
		IMethodSummaryModel m = new MethodSummaryModel(t);
		
		long d = m.getTotalMethodDuration();
		assertEquals(0L, d);
	}
	
	@Test
	public void testGetMethodSummaryListEmpty(){
		TraceTreeNode t = new TraceTreeNode(new TreeNode());
		IMethodSummaryModel m = new MethodSummaryModel(t);
		
		List<IMethodSummary> sum = m.getMethodSummaryList();
		assertEquals(0, sum.size());
	}
	
	@Test
	public void testGetMethodSummaryMapEmpty(){
		TraceTreeNode t = new TraceTreeNode(new TreeNode());
		IMethodSummaryModel m = new MethodSummaryModel(t);
		
		Map<MethodKey, IMethodSummary> map = m.getMethodSummaryMap();
		assertEquals(0, map.size());
		
	}

}

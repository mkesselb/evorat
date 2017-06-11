package org.shiftone.jrat.provider.tree.ui.summary;

import org.shiftone.jrat.core.MethodKey;
import org.shiftone.jrat.provider.tree.ui.TraceTreeNode;
import org.shiftone.jrat.util.Percent;

public interface IMethodSummary {

	void addStatistics(TraceTreeNode node);

	/**
	 * It the method has been entered but not exited, then it is
	 * possible that the method time would end up negative.  I'm not
	 * showing it at all in this case to avoid confusion.
	 */
	Long getTotalMethodDuration();

	Double getAverageMethodDuration();

	Double getAverageDuration();

	Percent getErrorRate();

	long getUncompletedCalls();

	long getTotalEnters();

	long getTotalExists();

	long getTotalErrors();

	Long getMinDuration();

	Long getMaxDuration();

	long getTotalDuration();

	int getTotalCallers();

	MethodKey getMethodKey();
	
	Object getFromMap(String key) throws IllegalArgumentException;

}
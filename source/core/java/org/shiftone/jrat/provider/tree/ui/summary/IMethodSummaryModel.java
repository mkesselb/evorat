package org.shiftone.jrat.provider.tree.ui.summary;

import java.util.List;
import java.util.Map;

import org.shiftone.jrat.core.MethodKey;

public interface IMethodSummaryModel {

	long getTotalMethodDuration();

	List<IMethodSummary> getMethodSummaryList();

	Map<MethodKey, IMethodSummary> getMethodSummaryMap();

}

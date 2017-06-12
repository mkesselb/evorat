package org.shiftone.jrat.provider.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.shiftone.jrat.core.MethodKey;
import org.shiftone.jrat.provider.tree.ui.summary.IMethodSummary;
import org.shiftone.jrat.provider.tree.ui.summary.IMethodSummaryModel;

public class TestMethodSummaryModel implements IMethodSummaryModel {

    private final List<IMethodSummary> methodList = new ArrayList<>();
    private final Map<MethodKey, IMethodSummary> methodMap = new HashMap<>();
    private final long totalMethodDuration;

    public TestMethodSummaryModel(){
    	IMethodSummary m = new TestMethodSummary();
    	this.methodList.add(m);
    	this.methodMap.put(m.getMethodKey(), m);
        totalMethodDuration = calculateTotalMethodDuration();
    }

    public long getTotalMethodDuration() {
        return totalMethodDuration;
    }

    private long calculateTotalMethodDuration() {
        long duration = 0;
        for (Iterator<IMethodSummary> i = methodList.iterator(); i.hasNext();) {
            IMethodSummary summary = i.next();
            Long d = (Long) summary.getTotalMethodDuration();
            if (d != null) {
                duration += d.longValue();
            }
        }
        return duration;
    }

    public List<IMethodSummary> getMethodSummaryList() {
        return Collections.unmodifiableList(methodList);
    }

    public Map<MethodKey, IMethodSummary> getMethodSummaryMap() {
        return Collections.unmodifiableMap(methodMap);
    }
}

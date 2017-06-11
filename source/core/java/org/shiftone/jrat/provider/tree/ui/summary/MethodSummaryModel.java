package org.shiftone.jrat.provider.tree.ui.summary;

import org.shiftone.jrat.core.MethodKey;
import org.shiftone.jrat.provider.tree.ui.TraceTreeNode;

import java.util.*;

/**
 * @author (jeff@shiftone.org) Jeff Drost
 */
public class MethodSummaryModel implements IMethodSummaryModel {

    private final List<IMethodSummary> methodList = new ArrayList<>();
    private final Map<MethodKey, IMethodSummary> methodMap = new HashMap<>();
    private final long totalMethodDuration;

    public MethodSummaryModel(TraceTreeNode node) {
        process(node);
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

    private void process(TraceTreeNode node) {

        if (!node.isRootNode()) {
            MethodKey methodKey = node.getMethodKey();
            IMethodSummary method = getMethod(methodKey);
            method.addStatistics(node);
        }

        for (int i = 0; i < node.getChildCount(); i++) {
            TraceTreeNode child = node.getChildNodeAt(i);
            process(child);
        }
    }

    private IMethodSummary getMethod(MethodKey methodKey) {
        MethodSummary summary = (MethodSummary) methodMap.get(methodKey);
        if (summary == null) {
            summary = new MethodSummary(methodKey);
            methodMap.put(methodKey, summary);
            methodList.add(summary);
        }
        return summary;
    }

    public List<IMethodSummary> getMethodSummaryList() {
        return Collections.unmodifiableList(methodList);
    }

    public Map<MethodKey, IMethodSummary> getMethodSummaryMap() {
        return Collections.unmodifiableMap(methodMap);
    }
}

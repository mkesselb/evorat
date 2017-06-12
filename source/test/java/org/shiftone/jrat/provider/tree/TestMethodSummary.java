package org.shiftone.jrat.provider.tree;

import java.util.HashMap;
import java.util.Map;

import org.shiftone.jrat.core.Accumulator;
import org.shiftone.jrat.core.MethodKey;
import org.shiftone.jrat.provider.tree.ui.TraceTreeNode;
import org.shiftone.jrat.provider.tree.ui.summary.IMethodSummary;
import org.shiftone.jrat.util.Percent;

public class TestMethodSummary implements IMethodSummary {

    private final MethodKey methodKey;
    private long totalEnters;
    private long totalExists;
    private long totalErrors;
    private long minDuration = Long.MAX_VALUE;
    private long maxDuration = Long.MIN_VALUE;
    private long totalDuration;
    private long totalMethodDuration;
    private int totalCallers;
    
    private Map<String, Object> valueMap = new HashMap<String, Object>();

    public TestMethodSummary() {
        this.methodKey = MethodKey.getInstance("La/b.method", "method", "(IC)V");
        totalEnters = 3L;
        totalExists = 3L;
        totalErrors = 4;
        minDuration = 5L;
        maxDuration = 6L;
        totalDuration = 7L;
        totalMethodDuration = 8L;
        totalCallers = 9;
        this.updateMap();
    }
    
    public void addStatistics(TraceTreeNode node) {
        Accumulator accumulator = node.getAccumulator();
        totalEnters += accumulator.getTotalEnters();
        totalExists += accumulator.getTotalExits();
        totalErrors += accumulator.getTotalErrors();
        if (totalExists > 0) {
            // if the node has not been existed, then the min and max times
            // will only have the MAX_VALUE and MIN_VALUE.
            minDuration = Math.min(minDuration, accumulator.getMinDuration());
            maxDuration = Math.max(maxDuration, accumulator.getMaxDuration());
        }
        totalDuration += accumulator.getTotalDuration();
        totalMethodDuration += node.getTotalMethodDuration();
        totalCallers++;
    }

    public Long getTotalMethodDuration() {
        return totalEnters != totalExists
                ? null
                : new Long(totalMethodDuration);
    }

    public Double getAverageMethodDuration() {
        return (totalExists == 0) || (totalEnters != totalExists)
                ? null
                : new Double((double) totalMethodDuration / (double) totalExists);
    }

    public Double getAverageDuration() {
        return totalExists == 0
                ? null
                : new Double((double) totalDuration / (double) totalExists);
    }

    public Percent getErrorRate() {
        return (totalExists == 0)
                ? null
                : new Percent(((double) totalErrors * 100.0) / (double) totalExists);
    }

    public long getUncompletedCalls() {
        return totalEnters - totalExists;
    }

    public long getTotalEnters() {
        return totalEnters;
    }

    public long getTotalExists() {
        return totalExists;
    }

    public long getTotalErrors() {
        return totalErrors;
    }

    public Long getMinDuration() {
        return minDuration == Long.MAX_VALUE ? null : new Long(minDuration);
    }

    public Long getMaxDuration() {
        return maxDuration == Long.MIN_VALUE ? null : new Long(maxDuration);
    }

    public long getTotalDuration() {
        return totalDuration;
    }

    public int getTotalCallers() {
        return totalCallers;
    }

    public MethodKey getMethodKey() {
        return methodKey;
    }
    
    private void updateMap(){
    	valueMap.put("Package", this.getMethodKey().getPackageName());
    	valueMap.put("Class", this.getMethodKey().getClassName());
    	valueMap.put("Method", this.getMethodKey().getShortMethodDescription());
    	valueMap.put("Signature", this.getMethodKey().getSig().getShortText());
    	valueMap.put("Enters", new Long(this.totalEnters));
    	valueMap.put("Exits", new Long(this.totalExists));
    	valueMap.put("Exceptions Thrown", new Long(this.totalErrors));
    	valueMap.put("Exception Rate", this.getErrorRate());
    	valueMap.put("Uncompleted Calls", new Long(this.getUncompletedCalls()));
    	valueMap.put("Total ms", new Long(this.getTotalDuration()));
    	valueMap.put("Min ms", this.getMinDuration());
    	valueMap.put("Max ms", this.getMaxDuration());
    	valueMap.put("Average ms", this.getAverageDuration());
    	valueMap.put("Total Method ms", this.getTotalMethodDuration());
    	valueMap.put("Average Method ms", this.getAverageMethodDuration());
    	valueMap.put("Total Callers", new Integer(this.totalCallers));
    }
    
    public Object getFromMap(String key) throws IllegalArgumentException{
    	if(valueMap.containsKey(key)){
    		return valueMap.get(key);
    	}
    	
    	throw new IllegalArgumentException("key not supported: " + key);
    }
}

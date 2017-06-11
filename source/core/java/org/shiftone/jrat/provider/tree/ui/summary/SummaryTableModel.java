package org.shiftone.jrat.provider.tree.ui.summary;

import org.shiftone.jrat.desktop.util.tables.Column;
import org.shiftone.jrat.desktop.util.tables.SummaryTable;
import org.shiftone.jrat.desktop.util.tables.AbstractTable;
import org.shiftone.jrat.util.Percent;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * @author jeff@shiftone.org (Jeff Drost)
 */
public class SummaryTableModel extends AbstractTableModel {

    private static final AbstractTable TABLE = new SummaryTable();
    private final IMethodSummaryModel summaryModel;
    private final List<IMethodSummary> methodSummaryList;

    public SummaryTableModel(IMethodSummaryModel summaryModel) {
        this.summaryModel = summaryModel;
        this.methodSummaryList = summaryModel.getMethodSummaryList();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        IMethodSummary summary = (IMethodSummary) methodSummaryList.get(rowIndex);
        
        String column = TABLE.getNameAtIndex(columnIndex);
        
        if(column.equals("Method Time %")){
        	return getPercent(summary);
        } else{
        	try{
        		return summary.getFromMap(column);
        	} catch(IllegalArgumentException e){
        		throw new IllegalArgumentException("columnIndex = " + columnIndex);
        	}        	
        }
    }

    private Percent getPercent(IMethodSummary summary) {
        Long tmd = summary.getTotalMethodDuration();
        return (tmd == null)
                ? null
                : new Percent((double) tmd.longValue() * 100.0 / (double) summaryModel.getTotalMethodDuration());
    }

    public static List<Column> getColumns() {
        return TABLE.getColumns();
    }

    public int getRowCount() {
        return methodSummaryList.size();
    }

    public int getColumnCount() {
        return TABLE.getColumnCount();
    }

    public String getColumnName(int column) {
        return TABLE.getColumn(column).getName();
    }
    
    public Column getColumn(String name){
    	int col = TABLE.getIndexForName(name);
    	return (col != -1 ? TABLE.getColumn(col) : null);
    }
}

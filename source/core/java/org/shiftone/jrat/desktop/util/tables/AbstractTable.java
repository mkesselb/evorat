package org.shiftone.jrat.desktop.util.tables;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractTable {
	
	protected List<Column> columns = new ArrayList<>();
	
    public List<Column> getColumns() {
        return Collections.unmodifiableList(columns);
    }

    public Column getColumn(int index) {
        return (Column) columns.get(index);
    }

    public int getColumnCount() {
        return columns.size();
    }
    
    public synchronized Column column(String name) {
        return column(name, true);
    }

    public synchronized Column column(String name, boolean defaultVisible) {
        return column(name, Object.class, defaultVisible);
    }

    public synchronized Column column(String name, Class<?> type, boolean defaultVisible) {
        Column column = new Column(columns.size(), name, type, defaultVisible);
        columns.add(column);
        return column;
    }
    
	public int getIndexForName(String name){
		for(Column c : this.getColumns()){
			if(c.getName().equals(name)){
				return c.getIndex();
			}
		}
		
		return -1;
	}
	
	public String getNameAtIndex(int index){
		if(index >= 0 && index < columns.size()){
			return columns.get(index).getName();
		}
		
		return null;
	}
}
package org.shiftone.jrat.desktop.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author (jeff@shiftone.org) Jeff Drost
 */
public class Table {


    private List<Column> columns = new ArrayList<>();

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

    public List<Column> getColumns() {
        return Collections.unmodifiableList(columns);
    }

    public Column getColumn(int index) {
        return (Column) columns.get(index);
    }

    public int getColumnCount() {
        return columns.size();
    }

}

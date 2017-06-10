package org.shiftone.jrat.desktop.util;

public class Column {

    private final int index;
    private final String name;
    private final Class<?> type;
    private final boolean defaultVisible;

    public Column(int index, String name, Class<?> type, boolean defaultVisible) {
        this.index = index;
        this.name = name;
        this.type = type;
        this.defaultVisible = defaultVisible;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public Class<?> getType() {
        return type;
    }

    public boolean isDefaultVisible() {
        return defaultVisible;
    }
	
}
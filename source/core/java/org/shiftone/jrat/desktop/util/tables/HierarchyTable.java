package org.shiftone.jrat.desktop.util.tables;

public class HierarchyTable extends AbstractTable{
	
    public static final String CLASS = "Class";
    public static final String METHODS = "Methods";
    public static final String TOTAL_EXITS = "Exists";
    public static final String UNCALLED = "Uncalled";
    public static final String COVERAGE = "Coverage %";
    public static final String EXCEPTIONS = "Exceptions";
    public static final String ERROR_RATE = "Error Rate";
    public static final String TOTAL = "Total ms";
    public static final String TOTAL_METHOD = "Total Method ms";
    public static final String PERCENT_METHOD = "Method Time %";

	public HierarchyTable(){
		column("Class");
		column("Methods");
		column("Exists", false);
		column("Uncalled", false);
		column("Coverage %", false);
		column("Exceptions", false);
		column("Error Rate", false);
		column("Total ms", false);
		column("Total Method ms");
		column("Method Time %");
	}
	
}

package org.shiftone.jrat.desktop.util.tables;

public class StackTable extends AbstractTable{

    public static final String PACKAGE = "Package";
    public static final String CLASS = "Class";
    public static final String METHOD = "Method";
    public static final String SIGNATURE = "Signature";
    public static final String ENTERS = "Enters";
    public static final String EXITS = "Exits";
    public static final String ERRORS = "Errors";
    public static final String THREADS = "Concurrent Threads";
    public static final String TOTAL = "Total ms";
    public static final String AVERAGE = "Average ms";
    public static final String TOTAL_METHOD = "Total Method ms";
    public static final String AVERAGE_METHOD = "Average Method ms";
    public static final String STANDARD_DEVIATION = "Standard Deviation";
    public static final String MIN = "Min ms";
    public static final String MAX = "Max ms";
    public static final String PERCENT_OF_PARENT = "% of Parent";
    public static final String PERCENT_OF_ROOT = "% of Root";
    
    public StackTable(){
    	column("Package", false);
    	column("Class");
    	column("Method");
    	column("Signature");
    	column("Enters", false);
    	column("Exits");
    	column("Errors", false);
    	column("Concurrent Threads", false);
    	column("Total ms");
    	column("Average ms", false);
    	column("Total Method ms");
    	column("Average Method ms");
    	column("Standard Deviation", false);
    	column("Min ms", false);
    	column("Max ms", false);
    	column("% of Parent");
    	column("% of Root");
    }
    
}
package org.shiftone.jrat.desktop.util.tables;

public class SummaryTable extends AbstractTable {
	
	public static final String PACKAGE = "Package";
	public static final String CLASS = "Class";
	public static final String METHOD = "Method";
	public static final String SIGNATURE = "Signature";
	public static final String ENTERS = "Enters";
	public static final String EXITS = "Exits";
	public static final String EXCEPTIONS = "Exceptions Thrown";
	public static final String EXCEPTION_RATE = "Exception Rate";
	public static final String UNCOMPLETED = "Uncompleted Calls";
	public static final String TOTAL = "Total ms";
	public static final String MIN = "Min ms";
	public static final String MAX = "Max ms";
	public static final String AVERAGE = "Average ms";
	public static final String TOTAL_METHOD = "Total Method ms";
	public static final String PERCENT_METHOD = "Method Time %";
	public static final String AVERAGE_METHOD = "Average Method ms";
	public static final String TOTAL_CALLERS = "Total Callers";

	public SummaryTable(){
		column("Package", false);
		column("Class");
		column("Method");
		column("Signature", false);
		column("Enters", false);
		column("Exits");
		column("Exceptions Thrown", false);
		column("Exception Rate", false);
		column("Uncompleted Calls", false);
		column("Total ms");
		column("Min ms", false);
		column("Max ms", false);
		column("Average ms");
		column("Total Method ms");
		column("Method Time %");
		column("Average Method ms");
		column("Total Callers", false);
	}
}
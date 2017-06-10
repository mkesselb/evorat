package org.shiftone.jrat.desktop.util.tables;

public class SummaryTable extends AbstractTable {

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
	
	public String getNameAtIndex(int index){
		if(index >= 0 && index < columns.size()){
			return columns.get(index).getName();
		}
		
		return null;
	}
}
package main.po.storepo;

import java.util.Calendar;

/*
 * Created By ZHR
 * 2015/10/26
 */
public class AdjustPO {
	private Calendar date;
	private StorePlacePO start;
	private StorePlacePO end;
	
	public AdjustPO(StorePlacePO start, StorePlacePO end){
		this.start = start;
		this.end = end;
		this.date = Calendar.getInstance(); 
	}
	
	public StorePlacePO getStart(){
		return this.start;
	}
	
	public StorePlacePO getEnd(){
		return this.end;
	}
	
	public Calendar getDate(){
		return this.date;
	}
}

package test.mockObject.mockstoreobject;

import java.util.Calendar;

public class MockAdjustPO {
	private Calendar date;
	private MockStorePlacePO start;
	private MockStorePlacePO end;
	
	public MockAdjustPO(MockStorePlacePO start, MockStorePlacePO end){
		this.start = start;
		this.end = end;
		this.date = Calendar.getInstance();
	}
	
	public MockStorePlacePO getStart(){
		return this.start;
	}
	
	public MockStorePlacePO getEnd(){
		return this.end;
	}
	
	public Calendar getDate(){
		return this.date;
	}
}

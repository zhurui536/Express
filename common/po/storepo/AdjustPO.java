package po.storepo;

import java.util.Calendar;

import po.UserPO;

/*
 * Created By ZHR
 * 2015/10/26
 */
public class AdjustPO {
	private Calendar date;
	private StorePlacePO start;
	private StorePlacePO end;
	private UserPO user;
	
	public AdjustPO(StorePlacePO start, StorePlacePO end, UserPO user){
		this.start = start;
		this.end = end;
		this.date = Calendar.getInstance(); 
		this.user = user;
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
	
	public UserPO getUser(){
		return this.user;
	}
}

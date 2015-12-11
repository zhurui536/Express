package po.storepo;

import java.io.Serializable;
import java.util.Calendar;

/*
 * Created By ZHR
 * 2015/10/26
 */
public class AdjustPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 837644380528938877L;
	private Calendar date;
	private StorePlacePO start;
	private StorePlacePO end;
	private String user;
	
	public AdjustPO(StorePlacePO start, StorePlacePO end, String user){
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
	
	public String getUser(){
		return this.user;
	}
}

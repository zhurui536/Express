package main.po;

import main.bussinesslogic.util.BillState;
import main.bussinesslogic.util.BillType;

/*
 * Created By ZHR
 * 2015/10/26
 */
public class BillPO {
	private String id;
	private BillType bt;
	private BillState bs;
	
	public BillPO(String id, BillType bt){
		this.id = id;
		this.bt = bt;
		bs = BillState.draft;
	}
	
	public String getID(){
		return id;
	}
	
	public BillType getBillType(){
		return bt;
	}
	
	public void setBillState(BillState bs){
		this.bs = bs;
	}

}

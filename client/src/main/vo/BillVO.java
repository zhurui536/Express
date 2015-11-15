package main.vo;

import main.bussinesslogic.util.BillType;

/**
 * Created By ZHR
 * 2015/10/26
 */
public class BillVO {
	private String id;
	private BillType bt;
	
	public BillVO(String id, BillType bt){
		this.id = id;
		this.bt = bt;
	}
	
	public String getID(){
		return id;
	}
	
	public BillType getBillType(){
		return bt;
	}

}

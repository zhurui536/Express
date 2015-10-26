package main.po;

import java.io.Serializable;

import main.bussinesslogic.util.BillType;

/*
 * Created By ZHR
 * 2015/10/26
 */
@SuppressWarnings("serial")
public class BillPO implements Serializable{
	private String id;
	private BillType bt;
	
	public BillPO(String id, BillType bt){
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

package main.po;

import main.bussinesslogic.util.BillState;
import main.bussinesslogic.util.BillType;
import java.io.Serializable;

/*
 * Created By ZHR
 * 2015/10/26
 */
@SuppressWarnings("serial")
public class BillPO implements Serializable{
	//单据编号
	private String id;
	//单据类型
	private BillType bt;
	//单据状态
	private BillState bs;
	
	public BillPO(String id, BillType bt){
		this.id = id;
		this.bt = bt;
		bs = BillState.DRAFT;
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

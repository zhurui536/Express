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
	//单据编写者
	private String writer;
	
	public BillPO(String id, BillType bt, String writer){
		this.id = id;
		this.bt = bt;
		this.writer = writer;
		bs = BillState.DRAFT;
	}
	
	public String getID(){
		return id;
	}
	
	public BillType getBillType(){
		return bt;
	}
	
	public String getWriter(){
		return writer;
	}
	
	public void setBillState(BillState bs){
		this.bs = bs;
	}

}

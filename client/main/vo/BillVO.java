package main.vo;

import main.bussinesslogic.util.BillType;

/**总经理审批单据时显示的信息
 * Created By ZHR
 * 2015/10/26
 */
public class BillVO {
	//单据编号
	private String billid;
	private BillType bt;
	private String userid;
	
	public BillVO(String billid, BillType bt, String userid){
		this.billid = billid;
		this.bt = bt;
		this.userid = userid;
	}
	
	public String getBillID(){
		return this.billid;
	}
	
	public BillType getBillType(){
		return bt;
	}
	
	public String getUserID(){
		return this.userid;
	}

}

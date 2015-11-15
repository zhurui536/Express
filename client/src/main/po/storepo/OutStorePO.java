package main.po.storepo;

import main.bussinesslogic.util.Trans;
/*
 * Created By ZHR
 * 2015/10/26
 */
import main.po.GoodsPO;

public class OutStorePO extends IORecordPO{

	//货物出库后的装运方式
	private Trans trans;
	//中转单货号或者汽运编号
	private String billid;
	
	public OutStorePO(GoodsPO goods, String destination, Trans trans, String billid) {
		super(goods, destination);
		// TODO Auto-generated constructor stub
		
		this.trans = trans;
		this.billid = billid;
	}
	
	public Trans getTrans(){
		return this.trans;
	}
	
	public String getBillid(){
		return this.billid;
	}

}

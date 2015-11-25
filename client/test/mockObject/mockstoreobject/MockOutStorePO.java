package test.mockObject.mockstoreobject;

import test.mockObject.MockGoodsPO;
import main.bussinesslogic.util.Trans;

public class MockOutStorePO extends MockIORecordPO{
	//货物出库后的装运方式
	private Trans trans;
	//中转单货号或者汽运编号
	private String billid;
	
	public MockOutStorePO(MockGoodsPO goods, String destination, Trans trans, String billid) {
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

package po.storepo;

import java.util.ArrayList;

import po.BillPO;
import util.BillType;

public class InStoreBillPO extends BillPO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3312534581845321792L;
	
	private String userid;
	private ArrayList<InStorePO> pos;
	private String billid;
	
	public InStoreBillPO(String userid, ArrayList<InStorePO> pos){
		super(BillType.INSTORE, userid);
		this.userid = userid;
		this.pos = pos;
		this.billid = super.getBillID();
	}
	
	public ArrayList<InStorePO> getPOS(){
		return this.pos;
	}
	
	public String getUser(){
		return this.userid;
	}
	
	public String getBill(){
		return this.billid;
	}
	
	//填写对于库存对象修改的实现
	@Override
	public void approve(){
		super.approve();
	}
}

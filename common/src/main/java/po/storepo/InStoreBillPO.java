package po.storepo;

import po.BillPO;
import util.BillType;

import java.util.ArrayList;

public class InStoreBillPO extends BillPO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3312534581845321792L;
	
	private String userid;
	private ArrayList<InStorePO> pos;
	private String billid;
	
	public InStoreBillPO(String userid, ArrayList<InStorePO> pos, String billid){
		super(billid, BillType.INSTORE, userid);
		this.userid = userid;
		this.pos = pos;
		this.billid = billid;
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
}

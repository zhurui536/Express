package po.storepo;

import po.BillPO;
import util.BillType;

import java.util.ArrayList;

public class OutStoreBillPO extends BillPO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1107054620205858780L;
	
	private String userid;
	private String billid;
	private ArrayList<OutStorePO> pos;
	
	public OutStoreBillPO(String userid, ArrayList<OutStorePO> pos, String billid){
		super(billid, BillType.OUTSTORE, userid);
		this.userid = userid;
		this.pos = pos;
		this.billid = billid;
	}
	
	public String getUser(){
		return this.userid;
	}
	
	public String getBill(){
		return this.billid;
	}
	
	public ArrayList<OutStorePO> getPOS(){
		return this.pos;
	}
}

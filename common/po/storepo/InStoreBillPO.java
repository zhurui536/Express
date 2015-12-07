package po.storepo;

import java.io.Serializable;
import java.util.ArrayList;

import main.bussinesslogic.util.BillState;
import main.bussinesslogic.util.BillType;
import main.vo.BillVO;

public class InStoreBillPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3312534581845321792L;
	
	private String userid;
	private ArrayList<InStorePO> pos;
	private String billid;
	private BillState state;
	
	public InStoreBillPO(String userid, ArrayList<InStorePO> pos, String billid){
		this.userid = userid;
		this.pos = pos;
		this.billid = billid;
		this.state = BillState.DRAFT;
	}
	
	public BillVO toVO(){
		return new BillVO(billid, BillType.INSTORE, userid);
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
	
	public BillState getState(){
		return this.state;
	}
	
	public void setState(BillState state){
		this.state = state;
	}
}

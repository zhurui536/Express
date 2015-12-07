package po.storepo;

import java.io.Serializable;
import java.util.ArrayList;

import main.bussinesslogic.util.BillState;
import main.bussinesslogic.util.BillType;
import main.vo.BillVO;

public class OutStoreBillPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1107054620205858780L;
	
	private String userid;
	private String billid;
	private ArrayList<OutStorePO> pos;
	private BillState state;
	
	public OutStoreBillPO(String userid, ArrayList<OutStorePO> pos, String billid){
		this.userid = userid;
		this.pos = pos;
		this.billid = billid;
		this.state = BillState.DRAFT;
	}
	
	public BillVO toVO(){
		return new BillVO(billid, BillType.OUTSTORE, userid);
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
	
	public BillState getState(){
		return this.state;
	}
	
	public void setState(BillState state){
		this.state = state;
	}
}

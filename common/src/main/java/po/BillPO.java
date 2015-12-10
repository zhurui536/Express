package po;

import util.BillState;
import util.BillType;
import vo.BillVO;

import java.io.Serializable;

public class BillPO implements Serializable {

	private static final long serialVersionUID = 186782065848074416L;

	private String billid;
	private String userid;
	private BillType type;
	private BillState state;
	
	public BillPO(String billid, BillType type, String userid){
		this.billid = billid;
		this.userid = userid;
		this.type = type;
		this.state = BillState.DRAFT;
	}
	
	public String getBillID(){
		return this.billid;
	}
	
	public String getUserID(){
		return this.userid;
	}
	
	public BillType getType(){
		return this.type;
	}
	
	public BillVO toVO(){
		return new BillVO(billid, type, userid);
	}
	
	public BillState getState(){
		return this.state;
	}
	
	public void setState(BillState state){
		this.state = state;
	}
}

package po;

import main.bussinesslogic.util.BillType;
import main.vo.BillVO;

public class BillPO {
	private String billid;
	private String userid;
	private BillType type;
	
	public BillPO(String billid, BillType type, String userid){
		this.billid = billid;
		this.userid = userid;
		this.type = type;
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
}

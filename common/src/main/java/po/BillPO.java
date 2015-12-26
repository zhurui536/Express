package po;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import util.BillState;
import util.BillType;
import util.PublicMessage;
import vo.BillVO;

public class BillPO implements Serializable {

	private static final long serialVersionUID = 186782065848074416L;

	private String billid;
	private String userid;
	private BillType type;
	private BillState state;
	
	public BillPO(BillType type, String userid){
		this.userid = userid;
		this.type = type;
		this.state = BillState.DRAFT;
		this.billid = PublicMessage.institutionID + df.format(Calendar.getInstance()) + BillType.BillTypeToTypeNum(type) + df2.format(Calendar.getInstance());
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
	
	public void approve(){
		this.state = BillState.APPROVED;
	}
	
	private SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
	private SimpleDateFormat df2 = new SimpleDateFormat("HHmmss");
}

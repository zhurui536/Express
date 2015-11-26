package po.storepo;

import java.util.ArrayList;

import main.vo.CheckVO;

public class IORecordPO {
	private ArrayList<InStorePO> in;
	private ArrayList<OutStorePO> out;
	
	public IORecordPO(ArrayList<InStorePO> in, ArrayList<OutStorePO> out){
		this.in = in;
		this.out = out;
	}
	
	public CheckVO setCheckVO(){
		return new CheckVO(this);
	}
	
	public ArrayList<InStorePO> getIn(){
		return in;
	}
	
	public ArrayList<OutStorePO> getOut(){
		return out;
	}
}

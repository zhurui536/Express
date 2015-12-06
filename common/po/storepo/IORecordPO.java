package po.storepo;

import java.io.Serializable;
import java.util.ArrayList;

import main.vo.storevo.CheckVO;

public class IORecordPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2410150916943792501L;
	
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

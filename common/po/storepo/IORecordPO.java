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
	
	public void setCheckVO(CheckVO cv){
		int ni = in.size();
		int no = out.size();
		double vi, vo;
		
		for(int i=0;i<ni;i++){
			
		}
		
		for(int i=0;i<no;i++){
			
		}
	}
}

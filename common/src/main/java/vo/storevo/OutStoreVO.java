package vo.storevo;

import java.util.ArrayList;

import po.storepo.OutStorePO;
import util.Trans;

public class OutStoreVO {
	private ArrayList<String> goodsid;
	private ArrayList<String> destination;
	private ArrayList<String> trans;
	
	public OutStoreVO(ArrayList<OutStorePO> goodslist){
		goodsid = new ArrayList<String>();
		destination = new ArrayList<String>();
		trans = new ArrayList<String>();
		
		for(int i=0;i<goodslist.size();i++){
			goodsid.add(goodslist.get(i).getGoodsID());
			destination.add(goodslist.get(i).getDestination());
			trans(goodslist.get(i).getTrans());
		}
	}
	
	private void trans(Trans trans){
		if(trans == Trans.PLANE){
			this.trans.add("飞机");
		}
		else if(trans == Trans.TRAIN){
			this.trans.add("火车");
		}
		else if(trans == Trans.TRUCK){
			this.trans.add("货车");
		}
	}
	
	public ArrayList<String> getGoodsID(){
		return this.goodsid;
	}
	
	public ArrayList<String> getTrans(){
		return this.trans;
	}
	
	public ArrayList<String> getDestination(){
		return this.destination;
	}
}

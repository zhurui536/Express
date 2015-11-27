package main.vo.storevo;

import java.util.ArrayList;
import java.util.Calendar;

import main.bussinesslogic.util.Trans;
import po.storepo.OutStorePO;

public class OutStoreVO {
	private ArrayList<String> goodsid;
	private ArrayList<Calendar> date;
	private ArrayList<String> user;
	private ArrayList<String> trans;
	
	public OutStoreVO(ArrayList<OutStorePO> goodslist){
		goodsid = new ArrayList<String>();
		date = new ArrayList<Calendar>();
		user = new ArrayList<String>();
		trans = new ArrayList<String>();
		
		for(int i=0;i<goodslist.size();i++){
			goodsid.add(goodslist.get(i).getGoodsID());
			date.add(goodslist.get(i).getDate());
			user.add(goodslist.get(i).getUser().getid());
			trans(goodslist.get(i).getTrans());
		}
	}
	
	private void trans(Trans trans){
		if(trans == Trans.PLANE){
			this.trans.add("plane");
		}
		else if(trans == Trans.TRAIN){
			this.trans.add("train");
		}
		else if(trans == Trans.TRUCK){
			this.trans.add("truck");
		}
	}
}

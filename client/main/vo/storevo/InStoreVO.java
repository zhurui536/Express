package main.vo.storevo;

import java.util.ArrayList;

import po.storepo.InStorePO;
import po.storepo.StorePlacePO;

/**
 * Created by Away
 * 2015/11/16
 */

public class InStoreVO {
	private ArrayList<String> goodsid;
	private ArrayList<int[]> place;
	
	public InStoreVO(ArrayList<InStorePO> goodslist){
		goodsid = new ArrayList<String>();
		place = new ArrayList<int[]>();
		
		for(int i=0;i<goodslist.size();i++){
			goodsid.add(goodslist.get(i).getGoodsID());
			StorePlacePO temp = goodslist.get(i).getStorePlace();
			int[] list = new int[]{
				temp.getArea(), temp.getRow(), temp.getShelf(), temp.getPlace()
			};
			place.add(list);
		}
	}
}

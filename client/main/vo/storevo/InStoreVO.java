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
	private ArrayList<String> destination;
	
	public InStoreVO(ArrayList<InStorePO> goodslist){
		goodsid = new ArrayList<String>();
		place = new ArrayList<int[]>();
		destination = new ArrayList<String>();
		
		for(int i=0;i<goodslist.size();i++){
			goodsid.add(goodslist.get(i).getGoodsID());
			StorePlacePO temp = goodslist.get(i).getStorePlace();
			int[] list = new int[]{
				temp.getArea()+1, temp.getRow()+1, temp.getShelf()+1, temp.getPlace()+1
			};
			place.add(list);
			destination.add(goodslist.get(i).getDestination());
		}
	}
	
	public  ArrayList<String> getIDs(){
		return this.goodsid;
	}
	
	public ArrayList<int[]> getPlace(){
		return this.place;
	}
	
	public ArrayList<String> getDestination(){
		return this.destination;
	}
}

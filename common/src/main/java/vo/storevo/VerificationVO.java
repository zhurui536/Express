package vo.storevo;

import po.GoodsPO;
import po.storepo.StorePO;
import po.storepo.StorePlacePO;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Away
 * 2015/11/16
 */

public class VerificationVO {
	public ArrayList<int[]> storeplace;
	public ArrayList<String> goodsid;
	public ArrayList<String> destination;
	public ArrayList<Calendar> date;
	public String pici;
	public int pihao;
	
	public VerificationVO(StorePO store, String pici, int pihao){
		storeplace = new ArrayList<int[]>();
		goodsid = new ArrayList<String>();
		destination = new ArrayList<String>();
		date = new ArrayList<Calendar>();
		this.pici = pici;
		this.pihao = pihao;
		
		for(int area=0;area<store.getArea();area++){
			for(int row=0;row<store.getRow();row++){
				for(int shelf=0;shelf<store.getShelf();shelf++){
					for(int place=0;place<store.getPlace();place++){
						StorePlacePO temp = store.getStorePlace(area, row, shelf, place);
						GoodsPO goods = temp.getGoods();
						if(goods != null){
							int[] places = new int[4];
							places[0] = area + 1;
							places[1] = row + 1;
							places[2] = shelf + 1;
							places[3] = place + 1;
							storeplace.add(places);
							
							goodsid.add(goods.getId());
							destination.add(goods.getDestination());
							date.add(temp.getDate());
						}
					}
				}
			}
		}
	}
	
	public ArrayList<int[]> getStorePlace(){
		return this.storeplace;
	}
	
	public ArrayList<String> getGoodsID(){
		return this.goodsid;
	}
	
	public ArrayList<String> getDestination(){
		return this.destination;
	}
	
	public ArrayList<Calendar> getDate(){
		return this.date;
	}
}

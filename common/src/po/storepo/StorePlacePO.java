package po.storepo;

import po.GoodsPO;

/**
 * Created by ZHR
 * 2015/10/26
 */
public class StorePlacePO {
	//区号
	private int area;
	//排号
	private int row;
	//架号
	private int shelf;
	//位号
	private int place;
	//该位置存放的货物
	private GoodsPO goods;
	
	public StorePlacePO(int area, int row, int shelf, int place){
		this.area = area;
		this.row = row;
		this.shelf = shelf;
		this.place = place;
		this.goods = null;
	}

	public boolean ifEmpty(){
		if(goods==null)
			return true;
		else
			return false;
	}
	
	public GoodsPO getGoods(){
		return this.goods;
	}
	
	public boolean setGoods(GoodsPO goods){
		this.goods = goods;
		
		return true;
	}
	
	public int getArea(){
		return this.area;
	}
	
	public int getRow(){
		return this.row;
	}
	
	public int getShelf(){
		return this.shelf;
	}
	
	public int getPlace(){
		return this.place;
	}
}

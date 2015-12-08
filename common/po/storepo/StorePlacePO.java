package po.storepo;

import main.vo.GoodsVO;
import main.vo.storevo.StorePlaceVO;
import po.GoodsPO;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by ZHR
 * 2015/10/26
 */
public class StorePlacePO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1975714771845618135L;
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
	//货物的存放日期
	private Calendar date;
	
	public StorePlacePO(int area, int row, int shelf, int place){
		this.area = area;
		this.row = row;
		this.shelf = shelf;
		this.place = place;
		this.goods = null;
		this.date = Calendar.getInstance();
	}

	public StorePlacePO(StorePlaceVO storePlaceVO) {
		this.area = storePlaceVO.area;
		this.row = storePlaceVO.row;
		this.shelf = storePlaceVO.shelf;
		this.place = storePlaceVO.place;
		this.goods = null;
		this.date = Calendar.getInstance();
	}

	public StorePlaceVO poToVo() {
		GoodsVO goodsVO = this.goods.poToVo();
		return new StorePlaceVO(area, row, shelf, place, goodsVO, date);
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
		this.date = Calendar.getInstance();
		
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
	
	public Calendar getDate(){
		return this.date;
	}
}

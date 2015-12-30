package vo.storevo;

import java.util.Calendar;

import vo.GoodsVO;

public class StorePlaceVO {
	public int area;
	public int row;
	public int shelf;
	public int place;
	//该位置存放的货物
	public GoodsVO goodsVO;
	//货物的存放日期
	public Calendar date;

	public StorePlaceVO(int area, int row, int shelf, int place){
		this.area = area;
		this.row = row;
		this.shelf = shelf;
		this.place = place;
	}

	public StorePlaceVO(int area, int row, int shelf, int place, GoodsVO goodsVO, Calendar date) {
		this(area, row, shelf, place);
		this.goodsVO = goodsVO;
		this.date = date;
	}

	public StorePlaceVO() {

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

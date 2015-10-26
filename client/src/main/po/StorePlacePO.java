package main.po;

/**
 * Created by ZHR
 * 2015/10/26
 */
public class StorePlacePO {
	private int area;
	private int row;
	private int shelf;
	private int place;
	
	public StorePlacePO(int area, int row, int shelf, int place){
		this.area = area;
		this.row = row;
		this.shelf = shelf;
		this.place = place;
	}

	public boolean ifEmpty(){
		return true;
	}
	
	public GoodsPO getGood(){
		return null;
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

package main.vo.storevo;

public class StorePlaceVO {
	private int area;
	private int row;
	private int shelf;
	private int place;
	
	public StorePlaceVO(int area, int row, int shelf, int place){
		this.area = area;
		this.row = row;
		this.shelf = shelf;
		this.place = place;
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

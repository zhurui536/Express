package main.po;

import java.util.Calendar;

public class IORecordPO {
	//出入库的货物
	private GoodsPO goods;
	//出入库的时间
	private Calendar date;
	//出入库货物的目的地
	private String destination;
	
	public IORecordPO(GoodsPO goods, String destination){
		this.goods = goods;
		this.destination = destination;
		this.date = Calendar.getInstance();
	}
	
	public GoodsPO getGoods(){
		return this.goods;
	}
	
	public Calendar getDate(){
		return this.date;
	}
	
	public String getDestination(){
		return this.destination;
	}
}

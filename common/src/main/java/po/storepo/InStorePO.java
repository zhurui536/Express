package po.storepo;

import po.GoodsPO;
import po.UserPO;

import java.io.Serializable;
import java.util.Calendar;

/*
 * Created By ZHR
 * 2015/10/26
 */

public class InStorePO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -979063192905781325L;
	//出入库的货物
	private GoodsPO goods;
	//出入库的时间
	private Calendar date;
	//出入库货物的目的地
	private String destination;
	//出入库的管理员
	private UserPO user;
	//货物的存储位置
	private StorePlacePO place;
	
	public InStorePO(GoodsPO goods, String destination, StorePlacePO place, UserPO user) {
		this.goods = goods;
		this.destination = destination;
		this.date = Calendar.getInstance();
		this.user = user;
		this.place = place;
	}
	
	public GoodsPO getGoods(){
		return this.goods;
	}
	
	public String getGoodsID(){
		return this.goods.getId();
	}
	
	public Calendar getDate(){
		return this.date;
	}
	
	public String getDestination(){
		return this.destination;
	}
	
	public UserPO getUser(){
		return this.user;
	}
	
	public StorePlacePO getStorePlace(){
		return this.place;
	}
	
	public double getPrice(){
		return goods.getPrice();
	}

}

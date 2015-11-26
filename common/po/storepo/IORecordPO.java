package po.storepo;

import java.util.Calendar;

import po.GoodsPO;
import po.UserPO;

public class IORecordPO {
	//出入库的货物
	private GoodsPO goods;
	//出入库的时间
	private Calendar date;
	//出入库货物的目的地
	private String destination;
	//出入库的管理员
	private UserPO user;
	
	public IORecordPO(GoodsPO goods, String destination, UserPO user){
		this.goods = goods;
		this.destination = destination;
		this.date = Calendar.getInstance();
		this.user = user;
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
}

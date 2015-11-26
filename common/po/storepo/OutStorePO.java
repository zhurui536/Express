package po.storepo;

import java.util.Calendar;

import main.bussinesslogic.util.Trans;
/*
 * Created By ZHR
 * 2015/10/26
 */
import po.GoodsPO;
import po.UserPO;

public class OutStorePO{
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
	//货物出库后的装运方式
	private Trans trans;
	//中转单货号或者汽运编号
	private String billid;
	
	public OutStorePO(GoodsPO goods, StorePlacePO place, String destination, UserPO user, Trans trans, String billid) {
		this.goods = goods;
		this.destination = destination;
		this.date = Calendar.getInstance();
		this.user = user;
		this.place = place;
		this.trans = trans;
		this.billid = billid;
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
	
	public Trans getTrans(){
		return this.trans;
	}
	
	public String getBillid(){
		return this.billid;
	}

}

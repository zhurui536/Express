package po.storepo;

import po.GoodsPO;
import po.UserPO;

/*
 * Created By ZHR
 * 2015/10/26
 */

public class InStorePO extends IORecordPO{
	//货物的存储位置
	private StorePlacePO place;
	
	public InStorePO(GoodsPO goods, String destination, StorePlacePO place, UserPO user) {
		super(goods, destination, user);
		// TODO Auto-generated constructor stub
		
		this.place = place;
	}
	
	public StorePlacePO getPlace(){
		return this.place;
	}

}

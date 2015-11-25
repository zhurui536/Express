package po.storepo;

import po.GoodsPO;

/*
 * Created By ZHR
 * 2015/10/26
 */

public class InStorePO extends IORecordPO{
	//货物的存储位置
	private StorePlacePO place;
	
	public InStorePO(GoodsPO goods, String destination, StorePlacePO place) {
		super(goods, destination);
		// TODO Auto-generated constructor stub
		
		this.place = place;
	}
	
	public StorePlacePO getPlace(){
		return this.place;
	}

}

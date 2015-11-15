package test.mockObject.mockstoreobject;

import java.util.Calendar;

import test.mockObject.MockGoodsPO;

public class MockIORecordPO {
	//出入库的货物
		private MockGoodsPO goods;
		//出入库的时间
		private Calendar date;
		//出入库货物的目的地
		private String destination;
		
		public MockIORecordPO(MockGoodsPO goods, String destination){
			this.goods = goods;
			this.destination = destination;
			this.date = Calendar.getInstance();
		}
		
		public MockGoodsPO getGoods(){
			return this.goods;
		}
		
		public Calendar getDate(){
			return this.date;
		}
		
		public String getDestination(){
			return this.destination;
		}
}

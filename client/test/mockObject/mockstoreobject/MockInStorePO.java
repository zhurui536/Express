package test.mockObject.mockstoreobject;

import test.mockObject.MockGoodsPO;

public class MockInStorePO extends MockIORecordPO{

	private MockStorePlacePO place;
	public MockInStorePO(MockGoodsPO goods, String destination, MockStorePlacePO place) {
		super(goods, destination);
		// TODO Auto-generated constructor stub
		this.place = place;
	}
	
	public MockStorePlacePO getPlace(){
		return this.place;
	}
}

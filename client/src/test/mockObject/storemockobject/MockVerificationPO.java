package test.mockObject.storemockobject;

import java.util.ArrayList;

import main.po.storepo.StorePlacePO;

public class MockVerificationPO {
	private ArrayList<MockStorePlacePO> goodslist;
	
	public MockVerificationPO(MockStorePO store){
		goodslist = new ArrayList<MockStorePlacePO>();
		
		int area = store.getArea();
		int row = store.getRow();
		int shelf = store.getShelf();
		int place = store.getPlace();
		
		for(int a=0;a<area;a++){
			for(int r=0;r<row;r++){
				for(int s=0;s<shelf;s++){
					for(int p=0;p<place;p++){
						MockStorePlacePO temp = store.getStorePlace(a, r, s, p);
						if(temp.getGoods()!=null){
							goodslist.add(temp);
						}
					}
				}
			}
		}
		
	}
	
	public ArrayList<MockStorePlacePO> getGoodslist(){
		return this.goodslist;
	}
}

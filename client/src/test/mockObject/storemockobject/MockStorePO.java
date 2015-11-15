package test.mockObject.storemockobject;

import java.util.ArrayList;

import test.mockObject.MockGoodsPO;
import main.po.storepo.StorePlacePO;



public class MockStorePO{

	//将所有库存位置整合到一起成为一个仓库对象
		private ArrayList<MockStorePlacePO> store = new ArrayList<MockStorePlacePO>();
		//区数
		private int areas = 2;
		//排数
		private int rows = 3;
		//架数
		private int shelfs = 4;
		//位数
		private int places = 5;
		
		/*构造一个固定尺寸的仓库对象*/
		public MockStorePO(){
			for(int area=1;area<=areas;area++){
				for(int row=1;row<=rows;row++){
					for(int shelf=1;shelf<=shelfs;shelf++){
						for(int place=1;place<=places;place++){
							MockStorePlacePO storeplace = new MockStorePlacePO(area, row, shelf, place);
							
							if((area+row+shelf+place)%2==0){
								storeplace.setGoods(new MockGoodsPO(""+area+" "+row+" "+shelf+" "+place));
							}
							store.add(storeplace);
						}
					}
				}
			}

		}
		
		/*获得在某一位置上的库存信息*/
		public MockStorePlacePO getStorePlace(int area, int row, int shelf, int place){
			int index = 0;
			index = areas*(area-1) + rows*(row-1) + shelfs*(shelf-1) + place - 1;
			
			return store.get(index);
		}
		
		/*改变某一位置上的库存状态*/
		public boolean setStorePlace(MockStorePlacePO storeplace){
			int area = storeplace.getArea();
			int row = storeplace.getRow();
			int shelf = storeplace.getShelf();
			int place = storeplace.getPlace();
			
			int index = 0;
			index = areas*(area-1) + rows*(row-1) + shelfs*(shelf-1) + place - 1;
			
			store.set(index, storeplace);
			return true;
		}
		
		/*获得关于库存的参数*/
		public int getArea(){
			return this.areas;
		}
		
		public int getRow(){
			return this.rows;
		}
		
		public int getShelf(){
			return this.shelfs;
		}
		
		public int getPlace(){
			return this.places;
		}
}

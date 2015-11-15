package test.mockObject.storemockobject;

import test.mockObject.MockGoodsPO;
import main.po.GoodsPO;
import main.po.storepo.StorePlacePO;

public class MockStorePlacePO {

		//区号
		private int area;
		//排号
		private int row;
		//架号
		private int shelf;
		//位号
		private int place;
		//该位置存放的货物
		private MockGoodsPO goods;
		
		public MockStorePlacePO(int area, int row, int shelf, int place){
			this.area = area;
			this.row = row;
			this.shelf = shelf;
			this.place = place;
			this.goods = null;
		}

		public boolean ifEmpty(){
			return true;
		}
		
		public MockGoodsPO getGoods(){
			return this.goods;
		}
		
		public boolean setGoods(MockGoodsPO goods){
			this.goods = goods;
			
			return true;
		}
		
		public int getArea(){
			return this.area;
		}
		
		public int getRow(){
			return this.row;
		}
		
		public int getShelf(){
			return this.shelf;
		}
		
		public int getPlace(){
			return this.place;
		}

}

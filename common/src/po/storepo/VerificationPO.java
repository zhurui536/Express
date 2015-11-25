package po.storepo;

import java.util.ArrayList;

/*
 * Created By ZHR
 * 2015/10/26
 */
public class VerificationPO {
	/*库存中现有货物的列表*/
	private ArrayList<StorePlacePO> goodslist;
	
	public VerificationPO(StorePO store){
		int area = store.getArea();
		int row = store.getRow();
		int shelf = store.getShelf();
		int place = store.getPlace();
		
		goodslist = new ArrayList<StorePlacePO>();
		
		for(int a=0;a<area;a++){
			for(int r=0;r<row;r++){
				for(int s=0;s<shelf;s++){
					for(int p=0;p<place;p++){
						StorePlacePO temp = store.getStorePlace(a, r, s, p);
						if(temp.getGoods()!=null){
							goodslist.add(temp);
						}
					}
				}
			}
		}
		
	}
	
	/*获得现有货物列表*/
	public ArrayList<StorePlacePO> getGoodslist(){
		return this.goodslist;
	}
}
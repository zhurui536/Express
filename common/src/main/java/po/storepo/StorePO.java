package po.storepo;

import vo.storevo.StorePlaceVO;
import vo.storevo.StoreVO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 库存PO
 * Created by Away
 * 2015/10/26
 */

public class StorePO implements Serializable {

	private static final long serialVersionUID = 6300225166368635096L;

	//将所有库存位置整合到一起成为一个仓库对象
	private ArrayList<StorePlacePO> store;
	//区数
	private int areas;
	//排数
	private int rows;
	//架数
	private int shelfs;
	//位数
	private int places;
	
	/*构造一个固定尺寸的仓库对象*/
	public StorePO(int areas, int rows, int shelfs, int places){
		this.areas = areas;
		this.rows = rows;
		this.shelfs = shelfs;
		this.places = places;
		store = new ArrayList<StorePlacePO>();
		for(int area=0;area<areas;area++){
			for(int row=0;row<rows;row++){
				for(int shelf=0;shelf<shelfs;shelf++){
					for(int place=0;place<places;place++){
						StorePlacePO storeplace = new StorePlacePO(area, row, shelf, place);
						
						store.add(storeplace);
					}
				}
			}
		}
		
	}

	public StorePO(StoreVO storeVO) {
		this.areas = storeVO.areas;
		this.places = storeVO.areas;
		this.rows = storeVO.rows;
		this.shelfs = storeVO.shelfs;
		this.store = new ArrayList<>();
		List<StorePlaceVO> storePlaceVOs = storeVO.store;
		for (StorePlaceVO vo : storePlaceVOs) {
			store.add(new StorePlacePO(vo));
		}
	}

	public StoreVO poToVo() {
		List<StorePlaceVO> storePlaceVOs = new ArrayList<>();
		for (StorePlacePO po : store) {
			storePlaceVOs.add(po.poToVo());
		}
		return new StoreVO(storePlaceVOs, areas, rows, shelfs, places);
	}

	/*获得在某一位置上的库存信息*/
	public StorePlacePO getStorePlace(int area, int row, int shelf, int place){
		for(int i=0;i<store.size();i++){
			StorePlacePO temp = store.get(i);
			
			if(temp.getArea() == area&&temp.getRow() == row&&temp.getShelf() == shelf&&temp.getPlace() == place){
				return temp;
			}
		}
		
		return null;
	}
	
	/*改变某一位置上的库存状态*/
	public boolean setStorePlace(StorePlacePO storeplace){
		int area = storeplace.getArea();
		int row = storeplace.getRow();
		int shelf = storeplace.getShelf();
		int place = storeplace.getPlace();
		
		for(int i=0;i<store.size();i++){
			StorePlacePO temp = store.get(i);
			if(temp.getArea() == area&&temp.getRow() == row&&temp.getShelf() == shelf&&temp.getPlace() == place){
				temp.setGoods(storeplace.getGoods());
				return true;
			}
		}
		
		return false;
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
	
	public int getNumOfEmpty(){
		int ne = 0;
		for(int i=0;i<store.size();i++){
			if(store.get(i).ifEmpty()){
				ne++;
			}
		}
		
		return ne;
	}
	
	public int getNumOfUsed(){
		int nu = 0;
		for(int i=0;i<store.size();i++){
			if(!store.get(i).ifEmpty()){
				nu++;
			}
		}
		
		return nu;
	}
	
	public void show(){
//		System.out.println();
//		
//		for(int a=0;a<areas;a++){
//			for(int r=0;r<rows;r++){
//				for(int s=0;s<shelfs;s++){
//					for(int p=0;p<places;p++){
//						if(this.getStorePlace(a, r, s, p)==null){
//							System.out.print("* ");
//						}
//						else if(this.getStorePlace(a, r, s, p).ifEmpty()){
//							System.out.print(0+" ");
//						}
//						else{
//							System.out.print(1+" ");
//						}
//					}
//					
//					System.out.println();
//				}
//			}
//		}
//		
//		System.out.println();
	}
	
	
}

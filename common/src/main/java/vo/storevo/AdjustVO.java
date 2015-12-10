package vo.storevo;

import java.util.ArrayList;

import po.storepo.AdjustPO;
import po.storepo.StorePlacePO;

public class AdjustVO {
	private ArrayList<int[]> start;
	private ArrayList<int[]> end;
	
	public AdjustVO(ArrayList<AdjustPO> goodslist){
		start = new ArrayList<int[]>();
		end = new ArrayList<int[]>();
		
		for(int i=0;i<goodslist.size();i++){
			AdjustPO temp = goodslist.get(i);
			StorePlacePO start = temp.getStart();
			StorePlacePO end = temp.getEnd();
			
			this.start.add(new int[]{start.getArea()+1, start.getRow()+1, start.getShelf()+1, start.getPlace()+1});
			this.end.add(new int[]{end.getArea()+1, end.getRow()+1, end.getShelf()+1, end.getPlace()+1});
		}
	}
	
	public ArrayList<int[]> getStarts(){
		return this.start;
	}
	
	public ArrayList<int[]> getEnds(){
		return this.end;
	}

}

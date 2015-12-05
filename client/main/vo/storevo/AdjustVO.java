package main.vo.storevo;

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
			
			this.start.add(new int[]{start.getArea(), start.getRow(), start.getShelf(), start.getPlace()});
			this.end.add(new int[]{end.getArea(), end.getRow(), end.getShelf(), end.getPlace()});
		}
	}
	
	public ArrayList<int[]> getStarts(){
		return this.start;
	}
	
	public ArrayList<int[]> getEnds(){
		return this.end;
	}

}

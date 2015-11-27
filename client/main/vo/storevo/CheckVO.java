package main.vo.storevo;

import java.util.ArrayList;

import po.storepo.IORecordPO;
import po.storepo.InStorePO;
import po.storepo.OutStorePO;
import po.storepo.StorePlacePO;

public class CheckVO {
	private int numOfIn;
	private int numOfOut;
	private double valueOfIn;
	private double valueOfOut;
	private int numOfEmpty;
	private int numOfUsed;
	
	private ArrayList<String> records;
	
	public CheckVO(IORecordPO record){
		ArrayList<InStorePO> in = record.getIn();
		ArrayList<OutStorePO> out = record.getOut();
		records = new ArrayList<String>();
		numOfIn = in.size();
		numOfOut = out.size();
		valueOfIn = 0;
		valueOfOut = 0;
		
		for(int i=0;i<in.size();i++){
			valueOfIn += in.get(i).getPrice();
			StorePlacePO place = in.get(i).getStorePlace();
			records.add("入库："+" "+in.get(i).getGoodsID()+" "+place.getArea()+" "+place.getRow()+" "+place.getShelf()+" "+place.getPlace());
		}
		
		for(int i=0;i<out.size();i++){
			valueOfOut += out.get(i).getPrice();
			StorePlacePO place = out.get(i).getStorePlace();
			records.add("出库："+" "+out.get(i).getGoodsID()+" "+place.getArea()+" "+place.getRow()+" "+place.getShelf()+" "+place.getPlace());
		}
	}
	
	public int getNumOfIn(){
		return this.numOfIn;
	}
	
	public int getNumOfOut(){
		return this.numOfOut;
	}
	
	public double getValueOfIn(){
		return this.valueOfIn;
	}
	
	public double getValueOfOut(){
		return this.valueOfOut;
	}

	public int getNumOfEmpty() {
		return numOfEmpty;
	}

	public void setNumOfEmpty(int numOfEmpty) {
		this.numOfEmpty = numOfEmpty;
	}

	public int getNumOfUsed() {
		return numOfUsed;
	}

	public void setNumOfUsed(int numOfUsed) {
		this.numOfUsed = numOfUsed;
	}

}

package vo.storevo;

import java.util.ArrayList;
import java.util.Calendar;

import po.storepo.IORecordPO;
import po.storepo.InStorePO;
import po.storepo.OutStorePO;
import po.storepo.StorePlacePO;

public class CheckVO {
	private double valueOfIn;
	private double valueOfOut;
	private int numOfEmpty;
	private int numOfUsed;
	
	private ArrayList<Calendar> timeOfIn;
	private ArrayList<Calendar> timeOfOut;
	private ArrayList<int[]> placeOfIn;
	private ArrayList<int[]> placeOfOut;
	private ArrayList<String> idOfIn;
	private ArrayList<String> idOfOut;
	
	
	public CheckVO(IORecordPO record){
		ArrayList<InStorePO> in = record.getIn();
		ArrayList<OutStorePO> out = record.getOut();
		idOfIn = new ArrayList<String>();
		idOfOut = new ArrayList<String>();
		placeOfIn = new ArrayList<int[]>();
		placeOfOut = new ArrayList<int[]>();
		timeOfIn = new ArrayList<Calendar>();
		timeOfOut = new ArrayList<Calendar>();
		valueOfIn = 0;
		valueOfOut = 0;
		
		for(int i=0;i<in.size();i++){
			valueOfIn += in.get(i).getPrice();
			StorePlacePO place = in.get(i).getStorePlace();
			placeOfIn.add(new int[]{place.getArea()+1, place.getRow()+1, place.getShelf()+1, place.getPlace()+1});
			idOfIn.add(place.getGoods().getId());
			timeOfIn.add(in.get(i).getDate());
		}
		
		for(int i=0;i<out.size();i++){
			valueOfOut += out.get(i).getPrice();
			StorePlacePO place = out.get(i).getStorePlace();
			placeOfOut.add(new int[]{place.getArea()+1, place.getRow()+1, place.getShelf()+1, place.getPlace()+1});
			idOfOut.add(place.getGoods().getId());
			timeOfOut.add(out.get(i).getDate());
		}
	}
	
	public ArrayList<Calendar> getTimeOfIn(){
		return this.timeOfIn;
	}
	
	public ArrayList<Calendar> getTimeOfOut(){
		return this.timeOfOut;
	}
	
	public ArrayList<int[]> getPlaceOfIn(){
		return this.placeOfIn;
	}
	
	public ArrayList<int[]> getPlaceOfOut(){
		return this.placeOfOut;
	}
	
	public ArrayList<String> getIDOfIn(){
		return this.idOfIn;
	}
	
	public ArrayList<String> getIDOfOut(){
		return this.idOfOut;
	}
	
	public int getNumOfIn(){
		return this.idOfIn.size();
	}
	
	public int getNumOfOut(){
		return this.idOfOut.size();
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

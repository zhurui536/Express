package po.storepo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/*
 * Created By ZHR
 * 2015/10/26
 */
public class VerificationPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3037996975225884855L;
	/*库存中现有货物的列表*/
	private ArrayList<StorePlacePO> goodslist;
	/*盘点的用户*/
	private String user;
	/*盘点的时间*/
	private Calendar time;
	/*批次和批号*/
	private String pici;
	private String pihao;
	
	public VerificationPO(StorePO store, String user){
		time = Calendar.getInstance();
		this.pici = df.format(time.getTime());
		this.pihao = time.getTime().getHours()+"";
		this.user = user;
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
	
	/*获得盘点时间*/
	public Calendar getTime(){
		return this.time;
	}
	
	/*获得盘点用户*/
	public String getUser(){
		return this.user;
	}
	
	public String getPici(){
		return this.pici;
	}
	
	public String getPihao(){
		return this.pihao;
	}
	
	private final SimpleDateFormat df= new SimpleDateFormat("yyyyMMdd");
}

package presentation.storeui.datapanel;

import vo.storevo.VerificationVO;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


@SuppressWarnings("serial")
public class VerificationDataPane extends JPanel {
	public VerificationDataPane(VerificationVO store){
		ArrayList<String> goodsid = store.getGoodsID();
		ArrayList<int[]> place = store.getStorePlace();
		ArrayList<Calendar> time = store.getDate();
		ArrayList<String> destination = store.getDestination();
		
		this.setLayout(null);
		this.setSize(810, 60+60*goodsid.size());
		//第一行放置对应的目录
		JPanel type = new JPanel();
		type.setSize(810, 60);
		type.setLocation(0, 0);
		type.setLayout(null);
		
		JLabel number = new JLabel("货物编号");
		number.setSize(150, 57);
		number.setLocation(10, 0);
		type.add(number);
		
		JLabel[] places = new JLabel[4];
		for(int i=0;i<4;i++){
			places[i] = new JLabel(this.places[i]);
			places[i].setSize(50, 57);
			places[i].setBackground(Color.PINK);
			places[i].setLocation(260 + 50*i, 0);
			type.add(places[i]);
		}
		
		JLabel dest = new JLabel("入库时间");
		dest.setSize(200, 57);
		dest.setLocation(550, 0);
		type.add(dest);
		 
		this.add(type);
		
		for(int i=0;i<goodsid.size();i++){
			JPanel item = makeItem(goodsid.get(i), place.get(i), time.get(i), destination.get(i));
			item.setLocation(0, 60+60*i);
			
			if(i%2==0){
				item.setBackground(Color.CYAN);
			}
			else{
				item.setBackground(Color.PINK);
			}
			this.add(item);
		}
	}
	
	private JPanel makeItem(String id, int[] place, Calendar time, String destination){
		JPanel item = new JPanel();
		item.setSize(810, 60);
		item.setLayout(null);
		
		//加入id
		JLabel number = new JLabel(id);
		number.setSize(120, 57);
		number.setLocation(10, 0);
		item.add(number);
		
		//加入存储位置
		JLabel[] places = new JLabel[4];
		for(int i=0;i<4;i++){
			places[i] = new JLabel(place[i]+"");
			places[i].setSize(30, 57);
			places[i].setBackground(Color.PINK);
			places[i].setLocation(150 + 35*i, 0);
			item.add(places[i]);
		}
		
		//加入入库时间
		JLabel timeOfIn = new JLabel(df.format(time.getTime()));
		timeOfIn.setSize(200, 57);
		timeOfIn.setLocation(340, 0);
		item.add(timeOfIn);
		
		//加入目的地
		JLabel dest = new JLabel(destination);
		dest.setSize(210, 57);
		dest.setLocation(550, 0);
		item.add(dest);
		
		return item;
	}
	
	private final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private String[] places = {"区号", "排号", "架号", "位号"};
}

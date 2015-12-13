package presentation.billui.datapanel;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import po.storepo.InStoreBillPO;
import po.storepo.InStorePO;
import vo.storevo.InStoreVO;

@SuppressWarnings("serial")
public class InStoreBillDataPane extends JPanel {
	public InStoreBillDataPane(InStoreBillPO bill){
		String userid = bill.getUserID();
		String billid = bill.getBillID();
		ArrayList<InStorePO> pos = bill.getPOS();
		InStoreVO list = new InStoreVO(pos);
		
		this.setLayout(null);
		
		JPanel ids = new JPanel();
		ids.setLayout(null);
		ids.setBounds(10, 0, 800, 40);
		
		JLabel user = new JLabel("单据编写人：" + userid);
		user.setBounds(0, 0, 250, 40);
		ids.add(user);
		
		JLabel billID = new JLabel("单据编号：" + billid);
		billID.setBounds(280, 0, 250, 40);
		ids.add(billID);
		
		JPanel data = this.makedata(list);
		data.setLocation(10, 40);
		
		this.setBounds(140, 100, 830, ids.getHeight() + data.getHeight());
	}
	
	private JPanel makedata(InStoreVO list){
		ArrayList<int[]> place = list.getPlace();
		ArrayList<String> destination = list.getDestination();
		ArrayList<String> goodslist = list.getIDs();
		
		JPanel data = new JPanel();
		data.setSize(810, goodslist.size()*40 + 40);
		data.setLayout(null);
		
		//第一行放置对应的目录
		JPanel type = new JPanel();
		type.setSize(810, 40);
		type.setLocation(0, 0);
		type.setLayout(null);
		 
		 
		JLabel number = new JLabel("货物编号");
		number.setSize(150, 40);
		number.setLocation(10, 0);
		type.add(number);
		 
		JLabel[] places = new JLabel[4];
		for(int i=0;i<4;i++){
			places[i] = new JLabel(this.places[i]);
			places[i].setSize(50, 40);
			places[i].setLocation(260 + 50*i, 0);
			type.add(places[i]);
		}
		 
		JLabel dest = new JLabel("目的地");
		dest.setSize(200, 40);
		dest.setLocation(550, 0);
		type.add(dest);
		 
		data.add(type);
		 
		//接着加入入库项
		for(int i=0;i<goodslist.size();i++){
			JPanel item = makeItem(goodslist.get(i), place.get(i), destination.get(i));
			item.setLocation(10, 40*i + 40);
			
			if(i%2==1){
				item.setBackground(Color.YELLOW);
			}
			else{
				item.setBackground(Color.CYAN);
			}
			 
			data.add(item);
		}
		
		return data;
	}
	
	//制作入库项的panel的方法
	private JPanel makeItem(String id, int[] place, String destination){
		JPanel item = new JPanel();
		item.setSize(810, 40);
		item.setLayout(null);
		
		//加入id
		JLabel number = new JLabel(id);
		number.setSize(150, 40);
		number.setLocation(10, 0);
		item.add(number);
		
		//加入存储位置
		JLabel[] places = new JLabel[4];
		for(int i=0;i<4;i++){
			places[i] = new JLabel(place[i]+"");
			places[i].setSize(50, 40);
			places[i].setBackground(Color.PINK);
			places[i].setLocation(230 + 50*i, 0);
			item.add(places[i]);
		}
		
		//加入目的地
		JLabel dest = new JLabel(destination);
		dest.setSize(200, 40);
		dest.setLocation(530, 0);
		item.add(dest);
		
		return item;
	}
	
	private String[] places = {"区号", "排号", "架号", "位号"};
}

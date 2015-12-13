package presentation.billui.datapanel;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import po.storepo.OutStoreBillPO;
import po.storepo.OutStorePO;
import vo.storevo.OutStoreVO;

public class OutStoreBillDataPane extends JPanel {
	public OutStoreBillDataPane(OutStoreBillPO bill){
		//先进行一些简单的数据处理，因为懒不想再写单据的VO了。。。
		String userid = bill.getUserID();
		String billid = bill.getBillID();
		ArrayList<OutStorePO> pos = bill.getPOS();
		OutStoreVO vo = new OutStoreVO(pos);
		
		this.setLayout(null);
		
		//开头显示单据的简单信息
		JPanel ids = new JPanel();
		ids.setLayout(null);
		ids.setBounds(10, 0, 800, 40);
		
		JLabel user = new JLabel("单据编写人：" + userid);
		user.setBounds(0, 0, 250, 40);
		ids.add(user);
		
		JLabel billID = new JLabel("单据编号：" + billid);
		billID.setBounds(280, 0, 250, 40);
		ids.add(billID);
		
		JPanel data = this.makedata(vo);
		data.setLocation(10, 40);
		
		this.setBounds(140, 100, 830, ids.getHeight() + data.getHeight());
	}
	
	private JPanel makedata(OutStoreVO vo){
		ArrayList<String> goodslist = vo.getGoodsID();
		ArrayList<String> destination = vo.getDestination();
		ArrayList<String> trans = vo.getTrans();
		
		JPanel data = new JPanel();
		//将容器的大小设计为货物数量加1对应的大小
		data.setSize(810, goodslist.size()*60 + 60);
		data.setLayout(null);
		 
		//第一行放置对应的目录
		JPanel type = new JPanel();
		type.setSize(810, 60);
		type.setLocation(0, 0);
		type.setLayout(null);
		type.setBackground(Color.MAGENTA);
		 
		JLabel number = new JLabel("货物编号");
		number.setSize(150, 57);
		number.setLocation(10, 0);
		type.add(number);
		
		JLabel tran = new JLabel("装运方式");
		tran.setSize(200, 57);
		tran.setLocation(200, 0);
		type.add(tran);
		
		JLabel dest = new JLabel("目的地");
		dest.setSize(200, 57);
		dest.setLocation(430, 0);
		type.add(dest);
		
		data.add(type);
		
		for(int i=0;i<goodslist.size();i++){
			JPanel temp = makeItem(goodslist.get(i), trans.get(i), destination.get(i));
			temp.setLocation(10, 60*i+60);
			if(i%2==0){
				temp.setBackground(Color.cyan);
			}
			else{
				temp.setBackground(Color.LIGHT_GRAY);
			}
			this.add(temp);
		}
		
		return data;
	}
	
	//制作一个出库项显示的方法
	private JPanel makeItem(String id, String trans, String destination){
		JPanel item = new JPanel();
		item.setSize(810, 60);
		item.setLayout(null);
		
		//加入id
		JLabel number = new JLabel(id);
		number.setSize(150, 57);
		number.setLocation(10, 0);
		item.add(number);
		
		//加入转运方式
		JLabel tran = new JLabel(trans);
		tran.setSize(100, 57);
		tran.setLocation(200, 0);
		item.add(tran);
		
		//加入目的地
		JLabel dest = new JLabel(destination);
		dest.setSize(200, 57);
		dest.setLocation(430, 0);
		item.add(dest);
		
		return item;
	}
}

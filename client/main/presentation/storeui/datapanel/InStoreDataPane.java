package main.presentation.storeui.datapanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.presentation.storeui.listener.toollistener.InStoreToolListener;
import main.vo.storevo.InStoreVO;

public class InStoreDataPane extends JPanel implements ActionListener{
	//删除按钮
	private ArrayList<JButton> deletes;
	//保存了与删除按钮对应的货物编号作为删除依据
	private ArrayList<String> goodslist;
	//删除指令的执行者
	private InStoreToolListener listener;
	
	public InStoreDataPane(InStoreVO list, InStoreToolListener listener){
		this.listener = listener;
		goodslist = list.getIDs();
		ArrayList<int[]> place = list.getPlace();
		ArrayList<String> destination = list.getDestination();
		deletes = new ArrayList<JButton>();
		 
		//将容器的大小设计为货物数量加1对应的大小
		this.setSize(810, goodslist.size()*60 + 60);
		this.setLayout(null);
		
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
		 
		JLabel dest = new JLabel("目的地");
		dest.setSize(200, 57);
		dest.setLocation(550, 0);
		type.add(dest);
		 
		this.add(type);
		 
		//接着加入入库项
		for(int i=0;i<goodslist.size();i++){
			JPanel item = makeItem(goodslist.get(i), place.get(i), destination.get(i));
			item.setLocation(10, 60*i + 60);
			
			if(i%2==1){
				item.setBackground(Color.YELLOW);
			}
			else{
				item.setBackground(Color.CYAN);
			}
			 
			this.add(item);
		}
		 
	}
	
	//制作入库项的panel的方法
	private JPanel makeItem(String id, int[] place, String destination){
		JPanel item = new JPanel();
		item.setSize(810, 60);
		item.setLayout(null);
		
		//加入id
		JLabel number = new JLabel(id);
		number.setSize(150, 57);
		number.setLocation(10, 0);
		item.add(number);
		
		//加入存储位置
		JLabel[] places = new JLabel[4];
		for(int i=0;i<4;i++){
			places[i] = new JLabel(place[i]+"");
			places[i].setSize(50, 57);
			places[i].setBackground(Color.PINK);
			places[i].setLocation(230 + 50*i, 0);
			item.add(places[i]);
		}
		
		//加入目的地
		JLabel dest = new JLabel(destination);
		dest.setSize(200, 57);
		dest.setLocation(530, 0);
		item.add(dest);
		
		//删除按钮
		JButton delete = new JButton("删除");
		delete.setSize(75, 30);
		delete.setLocation(735, 15);
		delete.addActionListener(this);
		delete.setBackground(Color.red);
		item.add(delete);
		deletes.add(delete);
		
		return item;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int i=0;
		for(i=0;i<deletes.size();i++){
			if(arg0.getSource() == deletes.get(i)){
				break;
			}
		}
		
		listener.delete(goodslist.get(i));
	}
	
	private String[] places = {"区号", "排号", "架号", "位号"};
}

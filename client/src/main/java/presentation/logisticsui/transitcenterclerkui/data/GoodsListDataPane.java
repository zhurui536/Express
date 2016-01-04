package presentation.logisticsui.transitcenterclerkui.data;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.logisticsui.transitcenterclerkui.listener.toollistener.GoodsLoadToolListener;
import presentation.logisticsui.transitcenterclerkui.listener.toollistener.GoodsTranToolListener;
import presentation.mainui.component.ToolButton;

@SuppressWarnings("serial")
public class GoodsListDataPane extends JPanel implements ActionListener{
	//删除按钮
	private ArrayList<ToolButton> deletes;
	//保存了与删除按钮对应的货物编号作为删除依据
	private ArrayList<String> goodslist;
	
	private GoodsTranToolListener listener1;
	private GoodsLoadToolListener listener2;
	
	public GoodsListDataPane(ArrayList<String> ids, GoodsTranToolListener listener){
		goodslist = ids;
		listener1 = listener;
		
		initialize();
	}
	public GoodsListDataPane(ArrayList<String> ids, GoodsLoadToolListener listener){
		goodslist = ids;
		listener2 = listener;
		
		initialize();
	}
	
	
	private void initialize(){
		deletes = new ArrayList<ToolButton>();
		
		//将容器的大小设计为货物数量加1对应的大小
		this.setSize(810, goodslist.size()*40 + 40);
		this.setLayout(null);
		
		JPanel header = new JPanel();
		header.setLayout(null);
		header.setBounds(0, 0, 810, 40);
		JLabel number = new JLabel("序号");
		number.setBounds(10, 0, 60, 40);
		header.add(number);
		JLabel id = new JLabel("货物编号");
		id.setBounds(200, 0, 200, 40);
		header.add(id);
		this.add(header);
		
		//接着加入货物项
		for(int i=0;i<goodslist.size();i++){
			JPanel item = makeItem(i+1, goodslist.get(i));
			item.setLocation(0, 40*i + 40);
			
			if(i%2==1){
				item.setBackground(new Color(20, 30, 30, 40));
			}
			else{
				item.setBackground(new Color(30, 30, 20, 40));
			}
			 
			this.add(item);
		}
	}
	
	private JPanel makeItem(int i, String s){
		JPanel item = new JPanel();
		item.setLayout(null);
		item.setSize(810, 40);
		
		JLabel number = new JLabel(i+"");
		number.setBounds(10, 0, 60, 40);
		item.add(number);
		
		JLabel id = new JLabel(s);
		id.setBounds(200, 0, 200, 40);
		item.add(id);
		
		//删除按钮
		ToolButton delete = new ToolButton(735, 5, "删除");
		delete.setSize(75, 30);
		delete.addActionListener(this);
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
			
			if(listener1!=null){
				listener1.deleteID(goodslist.get(i));
			}
			else{
				listener2.deleteID(goodslist.get(i));
			}
		}
	}
}

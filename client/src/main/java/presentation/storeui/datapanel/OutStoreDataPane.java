package presentation.storeui.datapanel;

import presentation.storeui.listener.toollistener.OutStoreToolListener;
import vo.storevo.OutStoreVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


@SuppressWarnings("serial")
public class OutStoreDataPane extends JPanel implements ActionListener {
	
	//删除按钮的数组
	private ArrayList<JButton> deletes;
	//并非监听者，作为上一级，处理这里发生点击时的事务
	private OutStoreToolListener listener;
	//方便与按钮相对应
	private ArrayList<String> goodslist;
	
	public OutStoreDataPane(OutStoreVO vo, OutStoreToolListener listener){
		this.listener = listener;
		this.goodslist = vo.getGoodsID();
		ArrayList<String> destination = vo.getDestination();
		ArrayList<String> trans = vo.getTrans();
		
		deletes = new ArrayList<JButton>();
		 
		//将容器的大小设计为货物数量加1对应的大小
		this.setSize(810, goodslist.size()*60 + 60);
		this.setLayout(null);
		 
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
		
		this.add(type);
		
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
		
		//加入删除按钮
		JButton delete = new JButton("删除");
		delete.setSize(75, 30);
		delete.setLocation(705, 15);
		delete.addActionListener(this);
		delete.setBackground(Color.red);
		item.add(delete);
		deletes.add(delete);
		
		return item;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int i=0;
		for(i=0;i<deletes.size();i++){
			if(e.getSource() == deletes.get(i)){
				break;
			}
		}
		
		//将发生的事件交给上一级监听者控制
		listener.delete(goodslist.get(i));
	}

}

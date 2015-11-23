package main.presentation.storeui;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolMaker {
	public static JPanel getTool(int i){
		if(i==0)
			return instore();
		else if(i==1)
			return outstore();
		else
			return null;
	}
	
	public static JPanel instore(){
		JPanel tool = new JPanel();
		tool.setLayout(null);
		tool.setSize(1000, 100);
		tool.setLocation(0, 0);
		
		JButton add = new JButton("新建入库项");
		add.setSize(105, 25);
		add.setLocation(145, 40);
		tool.add(add);
		
		JButton del = new JButton("删除入库项");
		del.setSize(105, 25);
		del.setLocation(265, 40);
		tool.add(del);
		
		JButton confirm = new JButton("确定");
		confirm.setSize(100, 30);
		confirm.setLocation(770, 35);
		tool.add(confirm);
		
		JButton cancle = new JButton("取消入库");
		cancle.setSize(100, 30);
		cancle.setLocation(880, 35);
		tool.add(cancle);
		
		return tool;
	}
	
	public static JPanel outstore(){
		JPanel tool = new JPanel();
		tool.setLayout(null);
		tool.setSize(1000, 100);
		tool.setLocation(0, 0);
		
		JButton add = new JButton("新建出库项");
		add.setSize(105, 25);
		add.setLocation(145, 40);
		tool.add(add);
		
		JButton del = new JButton("删除出库项");
		del.setSize(105, 25);
		del.setLocation(265, 40);
		tool.add(del);
		
		JButton confirm = new JButton("确定");
		confirm.setSize(100, 30);
		confirm.setLocation(770, 35);
		tool.add(confirm);
		
		JButton cancle = new JButton("取消出库");
		cancle.setSize(100, 30);
		cancle.setLocation(880, 35);
		tool.add(cancle);
		
		return tool;
	}
}

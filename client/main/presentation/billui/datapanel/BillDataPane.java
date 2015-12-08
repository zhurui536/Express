package main.presentation.billui.datapanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.bussinesslogic.util.BillType;
import main.presentation.billui.listener.BillJudgeToolListener;
import main.vo.BillVO;

public class BillDataPane extends JPanel implements ActionListener {
	//审批按钮
	private ArrayList<JButton> approves;
	//保存了与删除按钮对应的单据编号与单据类型作为审批依据
	private ArrayList<String> billslist;
	private ArrayList<BillType> billstype;
	//上一级的监听者，负责处理按钮事件
	private BillJudgeToolListener listener;
	
	public BillDataPane(ArrayList<BillVO> bills, BillJudgeToolListener tl){
		this.billslist = new ArrayList<String>();
		this.billstype = new ArrayList<BillType>();
		this.approves = new ArrayList<JButton>();
		this.listener = tl;
		
		this.setSize(810, 60*bills.size()+60);
		this.setLayout(null);
		
		//制作信息显示目录
		JPanel type = new JPanel();
		type.setSize(810, 60);
		type.setLocation(0, 0);
		type.setLayout(null);
		type.setBackground(Color.CYAN);
		
		JLabel number = new JLabel("单据编号");
		number.setSize(200, 57);
		number.setLocation(10, 0);
		type.add(number);
		
		JLabel billtype = new JLabel("单据类型");
		billtype.setSize(100, 57);
		billtype.setLocation(250, 0);
		type.add(billtype);
		
		JLabel userid = new JLabel("编写者编号");
		userid.setSize(200, 57);
		userid.setLocation(400, 0);
		type.add(userid);
		//把目录加到大panel的开头
		this.add(type);
		
		//制作单据列表
		for(int i=0;i<bills.size();i++){
			BillVO temp = bills.get(i);
			billslist.add(temp.getBillID());
			billstype.add(temp.getBillType());
			
			JPanel item = this.makeItem(temp);
			item.setLocation(10, 60*i+60);
			if(i%2==0)
				item.setBackground(Color.LIGHT_GRAY);
			else
				item.setBackground(Color.PINK);
			
			this.add(item);
		}
	}
	
	private JPanel makeItem(BillVO vo){
		JPanel item = new JPanel();
		item.setSize(810, 60);
		item.setLocation(0, 0);
		item.setLayout(null);
		
		JLabel number = new JLabel(vo.getBillID());
		number.setSize(200, 57);
		number.setLocation(10, 0);
		item.add(number);
		
		JLabel billtype = new JLabel(this.typeToString(vo.getBillType()));
		billtype.setSize(100, 57);
		billtype.setLocation(250, 0);
		item.add(billtype);
		
		JLabel userid = new JLabel(vo.getUserID()+"");
		userid.setSize(200, 57);
		userid.setLocation(400, 0);
		item.add(userid);
		
		//审批按钮，用于单个审批
		JButton approve = new JButton("审批");
		approve.setSize(75, 30);
		approve.setLocation(635, 15);
		approve.addActionListener(this);
		approve.setBackground(Color.GREEN);
		item.add(approve);
		approves.add(approve);
		
		return item;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int i=0;
		
		for(i=0;i<approves.size();i++){
			if(e.getSource() == approves.get(i))
				break;
		}
		
		String billid = this.billslist.get(i);
		BillType type = this.billstype.get(i);
	}
	
	private String typeToString(BillType type){
		String billname;
		if(type == BillType.INSTORE){
			billname = "入库单";
		}
		else if(type == BillType.OUTSTORE){
			billname = "出库单";
		}
		else if(type == BillType.PAYMENT){
			billname = "付款单";
		}
		else if(type == BillType.RECEIPT){
			billname = "接收单";
		}
		else
			billname = "未知类型";
		
		return billname;
	}

}

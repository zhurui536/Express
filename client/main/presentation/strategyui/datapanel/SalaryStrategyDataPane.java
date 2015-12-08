package main.presentation.strategyui.datapanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SalaryStrategyDataPane extends JPanel implements ActionListener {
	private JTextArea[] input;
	private JComboBox<String> job;
	
	private JButton confirm;
	private JButton cancle;
	
	public SalaryStrategyDataPane(){
		this.setBounds(140, 100, 810, 500);
		this.setLayout(null);
		this.initialize();
	}
	
	private void initialize(){
		JLabel[] list = new JLabel[4];
		
		for(int i=0;i<4;i++){
			list[i] = new JLabel(listname[i]);
			list[i].setBounds(10, 10+50*i, 80, 40);
			this.add(list[i]);
		}
		
		input = new JTextArea[2];
		input[0] = new JTextArea();
		input[0].setBounds(120, 60, 200, 40);
		this.add(input[0]);
		
		input[1] = new JTextArea();
		input[1].setBounds(120, 160, 200, 40);
		this.add(input[1]);
		
		job = new JComboBox<String>(jobs);
		job.setBounds(120, 110, 170, 40);
		this.add(job);
		
		confirm = new JButton("确定");
		confirm.setBounds(70, 240, 70, 30);
		confirm.addActionListener(this);
		this.add(confirm);
		
		cancle = new JButton("取消");
		cancle.setBounds(160, 240, 70, 30);
		cancle.addActionListener(this);
		this.add(cancle);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancle){
			
		}
		if(e.getSource() == confirm){
			
		}
	}
	
	private final String[] jobs ={ "快递员", "营业厅业务员", "中转中心业务员", "中转中心库存管理人员","财务人员","总经理","司机" };
	private final String[] listname = {"薪水制定", "用户名", "职位", "薪水"};
}

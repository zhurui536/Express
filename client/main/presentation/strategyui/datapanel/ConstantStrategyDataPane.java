package main.presentation.strategyui.datapanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ConstantStrategyDataPane extends JPanel implements ActionListener {
	private JButton confirm;
	private JButton cancle;
	
	JTextArea[] city;
	JTextArea[] input;
	
	JComboBox<String>[] cities;
	
	public ConstantStrategyDataPane(){
		this.setBounds(140, 100, 810, 500);
		this.setLayout(null);
		this.initialize();
	}
	
	private void initialize(){
		confirm = new JButton("确定");
		confirm.setBounds(70, 340, 70, 30);
		confirm.addActionListener(this);
		this.add(confirm);
		
		cancle = new JButton("取消");
		cancle.setBounds(160, 340, 70, 30);
		cancle.addActionListener(this);
		this.add(cancle);
		
		JLabel list1 = new JLabel("城市带选项");
		list1.setBounds(10, 20, 100, 50);
		this.add(list1);
		
		city = new JTextArea[2];
		city[0] = new JTextArea("城市A");
		city[0].setBounds(30, 80, 80, 40);
		this.add(city[0]);
		
		city[1] = new JTextArea("城市B");
		city[1].setBounds(30, 130, 80, 40);
		this.add(city[1]);
		
		cities = new JComboBox[2];
		cities[0] = new JComboBox<String>(icons);
		cities[0].setBounds(135, 80, 80, 40);
		this.add(cities[0]);
		
		cities[1] = new JComboBox<String>(icons);
		cities[1].setBounds(135, 130, 80, 40);
		this.add(cities[1]);
		
		JLabel list2 = new JLabel("拟定运费");
		list2.setBounds(10, 190, 80, 40);
		this.add(list2);
		
		JLabel list3 = new JLabel("城市距离");
		list3.setBounds(10, 245, 80, 40);
		this.add(list3);
		
		input = new JTextArea[2];
		input[0] = new JTextArea();
		input[0].setBounds(110, 190, 260, 40);
		this.add(input[0]);
		
		input[1] = new JTextArea();
		input[1].setBounds(110, 245, 260, 40);
		this.add(input[1]);
	}
	
	private final String[] icons = {"南京", "上海", "广州", "杭州","北京"};

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancle){
			
		}
		if(e.getSource() == confirm){
			
		}
		
	}
}

package main.presentation.strategyui.datapanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import main.bussinesslogic.util.City;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.strategyblservice.StrategyConstantBLService;
import main.presentation.managerui.ManagerFrame;
import main.vo.DistanceVO;

@SuppressWarnings("serial")
public class ConstantStrategyDataPane extends JPanel implements ActionListener {
	private JButton confirm;
	private JButton cancle;
	private JButton setprice;
	
	private JTextArea[] city;
	private JTextArea[] input;
	
	private JComboBox<String>[] cities;
	
	private StrategyConstantBLService bl;
	private ManagerFrame ui;
	
	public ConstantStrategyDataPane(ManagerFrame ui,  StrategyConstantBLService bl){
		this.ui = ui;
		this.bl = bl;
		this.setBounds(140, 100, 810, 500);
		this.setLayout(null);
		this.initialize();
	}
	
	@SuppressWarnings("unchecked")
	private void initialize(){
		//鎷熷畾鍩庡競璺濈閮ㄥ垎
		confirm = new JButton("纭畾");
		confirm.setBounds(70, 245, 70, 30);
		confirm.addActionListener(this);
		this.add(confirm);
		
		JLabel list1 = new JLabel("鍩庡競寰呴�夐」");
		list1.setBounds(10, 20, 100, 50);
		this.add(list1);
		
		city = new JTextArea[2];
		city[0] = new JTextArea("鍩庡競A");
		city[0].setBounds(30, 80, 80, 40);
		this.add(city[0]);
		
		city[1] = new JTextArea("鍩庡競B");
		city[1].setBounds(30, 130, 80, 40);
		this.add(city[1]);
		
		cities = new JComboBox[2];
		cities[0] = new JComboBox<String>(icons);
		cities[0].setBounds(135, 80, 80, 40);
		this.add(cities[0]);
		
		cities[1] = new JComboBox<String>(icons);
		cities[1].setBounds(135, 130, 80, 40);
		this.add(cities[1]);
		
		JLabel list2 = new JLabel("鍩庡競璺濈");
		list2.setBounds(10, 190, 80, 40);
		this.add(list2);
		
		input = new JTextArea[2];
		input[0] = new JTextArea();
		input[0].setBounds(110, 190, 260, 40);
		this.add(input[0]);
		
		//鎷熷畾杩愯垂閮ㄥ垎
		JLabel list3 = new JLabel("鎷熷畾杩愯垂");
		list3.setBounds(10, 340, 80, 40);
		this.add(list3);
		
		input[1] = new JTextArea();
		input[1].setBounds(110, 340, 260, 40);
		this.add(input[1]);
		
		setprice = new JButton("璁惧畾");
		setprice.setBounds(100, 390, 70, 30);
		setprice.addActionListener(this);
		this.add(setprice);
		
		//閫�鍑烘寜閽�
		cancle = new JButton("缁撴潫");
		cancle.setBounds(160, 440, 70, 30);
		cancle.addActionListener(this);
		this.add(cancle);
	}
	
	private final String[] icons = {"鍗椾含", "涓婃捣", "骞垮窞", "鍖椾含"};

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancle){
			ui.paintdata(null);
		}
		if(e.getSource() == confirm){
			try{
				double distance = Double.parseDouble(input[0].getText());
				City a = this.boxToCity(0);
				City b = this.boxToCity(1);
				
				ResultMessage result = bl.inputDistanceInfo(new DistanceVO(a, b, distance));
				if(result.getKey().equals("success")){
					this.input[0].setText("success");
					ui.validate();
					ui.repaint();
				}
			}catch(Exception ex){
				this.input[0].setText("杈撳叆鏈夎锛岃閲嶆柊杈撳叆");
				ui.validate();
				ui.repaint();
			}
			
		}
		if(e.getSource() == setprice){
			try{
				double price = Double.parseDouble(input[1].getText());
				ResultMessage result = bl.inputPriceInfo(price);
				
				if(result.getKey().equals("success")){
					this.input[1].setText("success");
					ui.validate();
					ui.repaint();
				}
				else{
					this.input[1].setText(result.getKey());
					ui.validate();
					ui.repaint();
				}
			}catch(Exception ex){
				this.input[1].setText("杈撳叆鏈夎锛岃閲嶆柊杈撳叆");
				ui.validate();
				ui.repaint();
			}
		}
	}
	
	private City boxToCity(int i){
		int num = this.cities[i].getSelectedIndex();
		
		if(num == 0)
			return City.NANJING;
		else if(num == 1)
			return City.SHANGHAI;
		else if(num == 2)
			return City.GUANGZHOU;
		else
			return City.BEIJING;
	}
}

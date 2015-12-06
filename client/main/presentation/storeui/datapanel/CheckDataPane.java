package main.presentation.storeui.datapanel;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.vo.storevo.CheckVO;

public class CheckDataPane extends JPanel {
	
	public CheckDataPane(CheckVO vo){
		this.setLayout(null);
		ArrayList<Calendar> timeOfIn = vo.getTimeOfIn();
		ArrayList<String> IDOfIn = vo.getIDOfIn();
		ArrayList<int[]> placeOfIn = vo.getPlaceOfIn();
		ArrayList<Calendar> timeOfOut = vo.getTimeOfOut();
		ArrayList<String> IDOfOut = vo.getIDOfOut();
		ArrayList<int[]> placeOfOut = vo.getPlaceOfOut();
		
		//合计部分的图块
		JPanel total = new JPanel();
		total.setBounds(0, 0, 810, 80);
		total.setLayout(null);
		total.setBackground(Color.GREEN);
		
		JLabel numOfIn = new JLabel("入库数量："+IDOfIn.size());
		numOfIn.setBounds(10, 0, 200, 40);
		total.add(numOfIn);
		JLabel numOfOut = new JLabel("出库数量："+IDOfOut.size());
		numOfOut.setBounds(10, 40, 200, 40);
		total.add(numOfOut);
		JLabel valueOfIn = new JLabel("入库总金额："+vo.getValueOfIn());
		valueOfIn.setBounds(250, 0, 300, 40);
		total.add(valueOfIn);
		JLabel valueOfOut = new JLabel("出库总金额："+vo.getValueOfOut());
		valueOfOut.setBounds(250, 40, 300, 40);
		total.add(valueOfOut);
		JLabel numOfUsed = new JLabel("已用库存："+vo.getNumOfUsed());
		numOfUsed.setBounds(600, 0, 200, 40);
		total.add(numOfUsed);
		JLabel numOfEmpty = new JLabel("空闲库存："+vo.getNumOfEmpty());
		numOfEmpty.setBounds(600, 40, 200, 40);
		total.add(numOfEmpty);
		
		JPanel inrecord = inrecord(timeOfIn, placeOfIn, IDOfIn);
		JPanel outrecord = outrecord(timeOfOut, placeOfOut, IDOfOut);
		
		this.setSize(810, 80+inrecord.getHeight()+outrecord.getHeight());
		
		this.add(total);
		
		inrecord.setLocation(0, 80);
		this.add(inrecord);
		
		outrecord.setLocation(0, 80+inrecord.getHeight());
		this.add(outrecord);
	}
	
	private JPanel inrecord(ArrayList<Calendar> timeOfIn, ArrayList<int[]> placeOfIn, ArrayList<String> IDOfIn){
		JPanel inrecord = new JPanel();
		inrecord.setLayout(null);
		inrecord.setSize(810, 60*IDOfIn.size()+60);
		
		JPanel type = new JPanel();
		type.setSize(810, 60);
		type.setLocation(10, 0);
		type.setLayout(null);
		type.setBackground(Color.ORANGE);

		//加入id
		JLabel number = new JLabel("货物编号");
		number.setSize(150, 57);
		number.setLocation(10, 0);
		type.add(number);
		
		//加入存储位置
		JLabel[] places = new JLabel[4];
		for(int i=0;i<4;i++){
			places[i] = new JLabel(this.places[i]);
			places[i].setSize(50, 57);
			places[i].setBackground(Color.PINK);
			places[i].setLocation(230 + 50*i, 0);
			type.add(places[i]);
		}

		//加入时间
		JLabel intime = new JLabel("入库时间");
		intime.setSize(200, 57);
		intime.setLocation(530, 0);
		type.add(intime);
		
		inrecord.add(type);
		
		for(int i=0;i<IDOfIn.size();i++){
			JPanel item = makeItem(timeOfIn.get(i), placeOfIn.get(i), IDOfIn.get(i));
			item.setLocation(10, 60*i+60);
			if(i%2==0){
				item.setBackground(Color.CYAN);
			}
			else{
				item.setBackground(Color.PINK);
			}
			inrecord.add(item);
		}
		
		return inrecord;
	}
	private JPanel makeItem(Calendar time, int[] place, String id){
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

		//加入时间
		JLabel intime = new JLabel(df.format(time.getTime()));
		intime.setSize(200, 57);
		intime.setLocation(530, 0);
		item.add(intime);
		
		return item;
	}
	
	private JPanel outrecord(ArrayList<Calendar> timeOfOut, ArrayList<int[]> placeOfOut, ArrayList<String> IDOfOut){
		JPanel outrecord = new JPanel();
		outrecord.setLayout(null);
		outrecord.setSize(810, 60*IDOfOut.size()+60);
		
		JPanel type = new JPanel();
		type.setSize(810, 60);
		type.setLocation(10, 0);
		type.setLayout(null);
		type.setBackground(Color.ORANGE);

		//加入id
		JLabel number = new JLabel("货物编号");
		number.setSize(150, 57);
		number.setLocation(10, 0);
		type.add(number);
		
		//加入存储位置
		JLabel[] places = new JLabel[4];
		for(int i=0;i<4;i++){
			places[i] = new JLabel(this.places[i]);
			places[i].setSize(50, 57);
			places[i].setBackground(Color.PINK);
			places[i].setLocation(230 + 50*i, 0);
			type.add(places[i]);
		}

		//加入时间
		JLabel intime = new JLabel("出库时间");
		intime.setSize(200, 57);
		intime.setLocation(530, 0);
		type.add(intime);
		
		outrecord.add(type);
		
		for(int i=0;i<IDOfOut.size();i++){
			JPanel item = makeItem(timeOfOut.get(i), placeOfOut.get(i), IDOfOut.get(i));
			item.setLocation(10, 60*i+60);
			if(i%2==0){
				item.setBackground(Color.CYAN);
			}
			else{
				item.setBackground(Color.PINK);
			}
			outrecord.add(item);
		}
		
		return outrecord;
	}

	private final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private final String[] places = {"区", "排", "架", "位"};
}

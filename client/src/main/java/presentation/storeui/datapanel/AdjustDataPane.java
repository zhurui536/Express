package presentation.storeui.datapanel;

import presentation.storeui.listener.toollistener.AdjustToolListener;
import vo.storevo.AdjustVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class AdjustDataPane extends JPanel implements ActionListener{
	private ArrayList<JButton> deletes;
	private AdjustToolListener listener;
	
	public AdjustDataPane(AdjustVO vo, AdjustToolListener listener){
		this.listener = listener;
		deletes = new ArrayList<JButton>();
		ArrayList<int[]> start = vo.getStarts();
		ArrayList<int[]> end = vo.getEnds();
		
		//将容器的大小设计为数量加1对应的大小
		this.setSize(810, start.size()*60 + 60);
		this.setLayout(null);
		
		//第一行放置对应的目录
		JPanel type = new JPanel();
		type.setSize(810, 60);
		type.setLocation(0, 0);
		type.setLayout(null);
		
		JLabel startplace = new JLabel("起始位置：");
		startplace.setBounds(10, 0, 100, 60);
		type.add(startplace);
		
		JLabel endplace = new JLabel("目标位置：");
		endplace.setBounds(340, 0, 100, 60);
		type.add(endplace);
		
		JLabel[] list1 = new JLabel[4];
		JLabel[] list2 = new JLabel[4];
		for(int i=0;i<4;i++){
			list1[i] = new JLabel(list[i]);
			list1[i].setBounds(160+50*i, 0, 50, 60);
			list2[i] = new JLabel(list[i]);
			list2[i].setBounds(440+50*i, 0, 50, 60);
			type.add(list1[i]);
			type.add(list2[i]);
		}
		
		type.setBackground(Color.PINK);
		this.add(type);
		
		for(int i=0;i<start.size();i++){
			JPanel item = makeItem(start.get(i), end.get(i));
			item.setLocation(0, 60*i+60);
			if(i%2==0){
				item.setBackground(Color.CYAN);
			}
			else{
				item.setBackground(Color.ORANGE);
			}
			this.add(item);
		}
	}
	
	private JPanel makeItem(int[] start, int[] end){
		JPanel item = new JPanel();
		item.setSize(810, 57);
		item.setLayout(null);
		
		JLabel[] list1 = new JLabel[4];
		JLabel[] list2 = new JLabel[4];
		for(int i=0;i<4;i++){
			list1[i] = new JLabel(start[i]+"");
			list1[i].setBounds(160+50*i, 0, 50, 57);
			list2[i] = new JLabel(end[i]+"");
			list2[i].setBounds(440+50*i, 0, 50, 57);
			item.add(list1[i]);
			item.add(list2[i]);
		}
		
		JButton delete = new JButton("删除");
		delete.setBounds(710, 15, 75, 30);
		delete.addActionListener(this);
		delete.setBackground(Color.red);
		deletes.add(delete);
		item.add(delete);
		
		
		return item;
	}
	
	private final String[] list = {"区", "排", "架", "位"};

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int i;
		for(i=0;i<deletes.size();i++){
			if(arg0.getSource() == deletes.get(i)){
				break;
			}
		}
		
		listener.delete(i);
		
	}
}

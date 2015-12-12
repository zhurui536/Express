package presentation.strategyui.inputframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import presentation.strategyui.listener.StrategyToolListener;
import util.City;

public class DistanceInputFrame extends JFrame implements ActionListener{
	private JButton confirm;
	private JButton cancle;
	
	private JTextArea input;
	
	private JComboBox<String>[] cities;
	
	private StrategyToolListener tl;
	
	public static void main(String[] args){
		DistanceInputFrame test = new DistanceInputFrame(null);
		test.setVisible(true);
	}
	
	public DistanceInputFrame(StrategyToolListener tl){
		this.setBounds(400, 250, 350, 290);
		this.setLayout(null);
		this.tl = tl;
		
		this.initialize();
	}
	
	private void initialize(){
		//窗口的标题
		JLabel title = new JLabel("城市距离输入");
		title.setBounds(130, 10, 90, 30);
		this.getContentPane().add(title);
		
		//窗口左边的列表
		JLabel[] list = new JLabel[3];
		for(int i=0;i<3;i++){
			list[i] = new JLabel(listname[i]);
			list[i].setBounds(15, 40+40*i, 70, 30);
			this.getContentPane().add(list[i]);
		}
		
		cities = new JComboBox[2];
		
		for(int i=0;i<2;i++){
			cities[i] = new JComboBox<String>();
			
			for(int j=0;j<city.length;j++){
				cities[i].addItem(City.cityToString(city[j]));
			}
			
			cities[i].setBounds(95, 40+40*i, 70, 30);
			this.getContentPane().add(cities[i]);
		}
		
		input = new JTextArea();
		input.setBounds(95, 120, 170, 30);
		this.getContentPane().add(input);
		
		confirm = new JButton("确定");
		confirm.setBounds(100, 170, 60, 30);
		confirm.addActionListener(this);
		this.getContentPane().add(confirm);
		
		cancle = new JButton("取消");
		cancle.setBounds(180, 170, 60, 30);
		cancle.addActionListener(this);
		this.getContentPane().add(cancle);
	}
	
	private final String[] listname = {"城市A：", "城市B：", "距离："};
	private final City[] city = {City.NANJING, City.SHANGHAI, City.GUANGZHOU, City.BEIJING};

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancle){
			this.dispose();
		}
		if(e.getSource() == confirm){
			
		}
	}
}

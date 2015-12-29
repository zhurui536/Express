package presentation.storeui.inputframe;

import presentation.WarningDialog;
import presentation.storeui.listener.toollistener.CheckToolListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

@SuppressWarnings("serial")
public class CheckInputFrame extends JFrame implements ActionListener {
	//确定、取消按钮
	private JButton confirm, cancle;
	//起始位置的输入框
	private JTextArea[] starttime;
	//终止位置的输入框
	private JTextArea[] endtime;
	//输入的提示目录
	private JLabel[] type;
	//输入的提示框
	private JLabel[] list;
	//输入窗口的标题
	private JLabel title;
	//上一级的监听者，处理输入
	private CheckToolListener listener;
	
	public CheckInputFrame(CheckToolListener listener){
		this.listener = listener;
		this.setName("库存查看输入");
		this.setLayout(null);
		this.setSize(430, 275);
		this.setLocation(400, 250);
		
		initialize();
	}
	
	private void initialize(){
		title = new JLabel("库存查看输入");
		title.setSize(90, 30);
		title.setLocation(170, 10);
		this.getContentPane().add(title);
		
		confirm = new JButton("确定");
		cancle = new JButton("取消");
		confirm.setSize(60, 25);
		cancle.setSize(60, 25);
		confirm.setLocation(250, 190);
		cancle.setLocation(330, 190);
		confirm.addActionListener(this);
		cancle.addActionListener(this);
		this.getContentPane().add(confirm);
		this.getContentPane().add(cancle);
		
		type = new JLabel[4];
		for(int i=0;i<4;i++){
			type[i] = new JLabel(typename[i]);
			type[i].setSize(45, 30);
			type[i].setLocation(120+55*i, 50);
			this.getContentPane().add(type[i]);
		}
		
		list = new JLabel[2];
		for(int i=0;i<2;i++){
			list[i] = new JLabel(listname[i]);
			list[i].setSize(70, 30);
			list[i].setLocation(15, 90+40*i);
			this.getContentPane().add(list[i]);
		}
		
		starttime = new JTextArea[4];
		for(int i=0;i<4;i++){
			starttime[i] = new JTextArea();
			starttime[i].setSize(45, 30);
			starttime[i].setLocation(110+55*i, 90);
			this.getContentPane().add(starttime[i]);
		}
		
		endtime = new JTextArea[4];
		for(int i=0;i<4;i++){
			endtime[i] = new JTextArea();
			endtime[i].setSize(45, 30);
			endtime[i].setLocation(110+55*i, 130);
			this.getContentPane().add(endtime[i]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancle){
			this.setVisible(false);
		}
		if(e.getSource() == confirm){
			Calendar start = Calendar.getInstance();
			Calendar end = Calendar.getInstance();
			
			try{
				int[] starttime = new int[4];
				int[] endtime = new int[4];
				
				for(int i=0;i<4;i++){
					starttime[i] = Integer.parseInt(this.starttime[i].getText());
					endtime[i] = Integer.parseInt(this.endtime[i].getText());
				}
				
				//由于月份是从0开始的，所以月份必须减1
				starttime[1]--;
				endtime[1]--;
				
				start.set(starttime[0], starttime[1], starttime[2], starttime[3], 0, 0);
				end.set(endtime[0], endtime[1], endtime[2], endtime[3], 0, 0);
				
				boolean result = listener.getInput(start, end);
				if(result){
					this.dispose();
				}
				else{
					for(int i=0;i<4;i++){
						this.starttime[i].setText("");
						this.endtime[i].setText("");
					}
					
					this.validate();
					this.repaint();
				}
			}catch(Exception ex){
				ex.printStackTrace();
				for(int i=0;i<4;i++){
					this.starttime[i].setText("");
					this.endtime[i].setText("");
				}
				new WarningDialog(this, "输入有误，请重新输入");
				this.validate();
				this.repaint();
			}
		}
	}
	
	private final String[] listname = {"起始时间：", "终止时间："}; 
	private final String[] typename = {"年", "月", "日", "时"};
}

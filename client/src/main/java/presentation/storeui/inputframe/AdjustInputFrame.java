package presentation.storeui.inputframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import presentation.WarningDialog;
import presentation.mainui.InputFrame;
import presentation.mainui.component.ToolButton;
import presentation.storeui.listener.toollistener.AdjustToolListener;

@SuppressWarnings("serial")
public class AdjustInputFrame extends InputFrame implements ActionListener {
	//确定、取消按钮
	private JButton confirm, cancle;
	//起始位置的输入框
	private JTextArea[] startplace;
	//终止位置的输入框
	private JTextArea[] endplace;
	//输入的提示框
	private JLabel[] list;
	//输入窗口的标题
	private JLabel title;
	//上一级的监听者，处理输入
	AdjustToolListener listener;
	
	public AdjustInputFrame(AdjustToolListener listener){
		this.listener = listener;
		this.setName("货物调整输入");
		this.setLayout(null);
		this.setSize(430, 275);
		this.setLocation(400, 250);
		
		initialize();
	}
	
	public void initialize(){
		title = new JLabel("货物调整输入");
		title.setSize(90, 30);
		title.setLocation(170, 10);
		this.getContentPane().add(title, 0);
		
		confirm = new ToolButton(250, 190,"确定");
		cancle = new ToolButton(330, 190,"取消");
		confirm.setSize(60, 25);
		cancle.setSize(60, 25);
		confirm.addActionListener(this);
		cancle.addActionListener(this);
		this.getContentPane().add(confirm, 0);
		this.getContentPane().add(cancle, 0);
		
		list = new JLabel[2];
		for(int i=0;i<2;i++){
			list[i] = new JLabel(listname[i]);
			list[i].setSize(70, 30);
			list[i].setLocation(15, 50+40*i);
			this.getContentPane().add(list[i], 0);
		}
		
		startplace = new JTextArea[4];
		for(int i=0;i<4;i++){
			startplace[i] = new JTextArea();
			startplace[i].setSize(45, 30);
			startplace[i].setLocation(110+55*i, 50);
			this.getContentPane().add(startplace[i], 0);
		}
		
		endplace = new JTextArea[4];
		for(int i=0;i<4;i++){
			endplace[i] = new JTextArea();
			endplace[i].setSize(45, 30);
			endplace[i].setLocation(110+55*i, 90);
			this.getContentPane().add(endplace[i], 0);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancle){
			this.setVisible(false);
		}
		if(e.getSource() == confirm){
			try{
				int[] startplace = new int[4];
				int[] endplace = new int[4];
				
				for(int i=0;i<4;i++){
					startplace[i] = Integer.parseInt(this.startplace[i].getText()) - 1;
					endplace[i] = Integer.parseInt(this.endplace[i].getText()) - 1;
				}
				
				boolean result = listener.getInput(startplace, endplace);
				if(result){
					this.dispose();
				}
			}catch(Exception ex){
				new WarningDialog(null, "输入有误，请重新输入");
			}
			//如果输入无法进行转换，那么将输入框重置
			for(int i=0;i<4;i++){
				this.startplace[i].setText("");
				this.endplace[i].setText("");
			}
			this.validate();
			this.repaint();
		}
	}
	
	private final String[] listname = {"起始位置：", "目标位置："};
}

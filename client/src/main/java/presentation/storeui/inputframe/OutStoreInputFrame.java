package presentation.storeui.inputframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import presentation.mainui.InputFrame;
import presentation.mainui.component.ToolButton;
import presentation.storeui.listener.toollistener.OutStoreToolListener;
import util.Trans;

@SuppressWarnings("serial")
public class OutStoreInputFrame extends InputFrame implements ActionListener{
	
	private JButton confirm, cancle;
	private JTextArea number, destination, billid;
	private JComboBox<String> trans;
	
	private JLabel[] list;
	private JLabel title;
	
	
	private OutStoreToolListener listener;
	
	public OutStoreInputFrame(OutStoreToolListener listener, String billid){
		this.setName("出库货物输入");
		this.setLayout(null);
		this.setSize(430, 275);
		this.setLocation(400, 250);
		
		this.listener = listener;
		initialize(billid);
	}
	
	private void initialize(String id){
		title = new JLabel("出库货物输入");
		title.setSize(90, 30);
		title.setLocation(170, 10);
		this.getContentPane().add(title, 0);
		
		confirm = new ToolButton(250, 210,"确定");
		cancle = new ToolButton(330, 210,"取消");
		confirm.setSize(60, 25);
		cancle.setSize(60, 25);
		confirm.addActionListener(this);
		cancle.addActionListener(this);
		this.getContentPane().add(confirm, 0);
		this.getContentPane().add(cancle, 0);
		
		list = new JLabel[4];
		for(int i=0;i<4;i++){
			list[i] = new JLabel(listname[i]);
			list[i].setSize(90, 30);
			list[i].setLocation(15, 50+40*i);
			this.getContentPane().add(list[i], 0);
		}
		
		number = new JTextArea();
		number.setSize(260, 30);
		number.setLocation(110, 50);
		this.getContentPane().add(number, 0);
		
		destination = new JTextArea();
		destination.setSize(260, 30);
		destination.setLocation(110, 130);
		this.getContentPane().add(destination, 0);
		
		billid = new JTextArea(id);
		billid.setSize(260, 30);
		billid.setLocation(110, 170);
		this.getContentPane().add(billid, 0);
		
		trans = new JComboBox<String>();
		for(int i=0;i<transport.length;i++){
			trans.addItem(transport[i]);
		}
		trans.setSize(70, 30);
		trans.setLocation(110, 90);
		this.getContentPane().add(trans, 0);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == confirm){
			Trans trans;
			trans = tran[this.trans.getSelectedIndex()];
			
			boolean result = listener.getInput(number.getText(), destination.getText(), trans, billid.getText());
			
			if(result == true){
				this.dispose();
			}
		}
		if(e.getSource() == cancle){
			this.dispose();
		}
		
	}
	
	private final String[] listname = {"货物编号：", "装运方式", "目的地：", "中转单编号："};
	private final String[] transport = {"飞机", "火车", "货车"};
	private final Trans[] tran = {Trans.PLANE, Trans.TRAIN, Trans.TRUCK};
}

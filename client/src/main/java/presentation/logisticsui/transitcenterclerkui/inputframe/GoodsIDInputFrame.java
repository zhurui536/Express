package presentation.logisticsui.transitcenterclerkui.inputframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import presentation.logisticsui.transitcenterclerkui.listener.toollistener.GoodsLoadToolListener;
import presentation.logisticsui.transitcenterclerkui.listener.toollistener.GoodsTranToolListener;
import presentation.mainui.InputFrame;
import presentation.mainui.component.ToolButton;

@SuppressWarnings("serial")
public class GoodsIDInputFrame extends InputFrame implements ActionListener{
	//确定、取消按钮
	private JButton confirm, cancle;
	//ID的输入框
	private JTextArea id;
	
	private GoodsLoadToolListener tl;
	private GoodsTranToolListener tl2;
	
	public GoodsIDInputFrame(GoodsLoadToolListener tl){
		this.tl = tl;
		this.setLayout(null);
		this.setSize(250, 200);
		this.setLocation(400, 250);
		
		this.initialize();
	}
	
	public GoodsIDInputFrame(GoodsTranToolListener tl){
		this.tl2 = tl;
		this.setLayout(null);
		this.setSize(250, 200);
		this.setLocation(400, 250);
		
		this.initialize();
	}

	private void initialize() {
		JLabel title = new JLabel("订单id输入");
		title.setSize(90, 30);
		title.setLocation(70, 10);
		this.getContentPane().add(title, 0);
		
		id = new JTextArea();
		id.setBounds(20, 50, 200, 30);
		this.getContentPane().add(id, 0);
		
		confirm = new ToolButton(30, 90,"确定");
		cancle = new ToolButton(110, 90,"取消");
		confirm.setSize(60, 25);
		cancle.setSize(60, 25);
		confirm.addActionListener(this);
		cancle.addActionListener(this);
		this.getContentPane().add(confirm, 0);
		this.getContentPane().add(cancle, 0);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == cancle){
			this.dispose();
		}
		if(arg0.getSource() == confirm){
			boolean result;
			String id = this.id.getText();
			if(tl!=null){
				result = tl.getID(id);
			}
			else{
				result = tl2.getID(id);
			}
			
			if(result){
				this.dispose();
			}
		}
	}
}

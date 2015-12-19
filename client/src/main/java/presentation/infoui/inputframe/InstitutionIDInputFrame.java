package presentation.infoui.inputframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import presentation.infoui.listener.InstitutionInfoToolListener;

public class InstitutionIDInputFrame extends JFrame implements ActionListener {
	//确定、取消按钮
	private JButton confirm, cancle;
	//ID的输入框
	private JTextArea id;
	//
	private InstitutionInfoToolListener tl;
	//表示此窗口的用途，0代表删除，1代表修改
	private int condition;
	
	public InstitutionIDInputFrame(InstitutionInfoToolListener tl, int i){
		this.tl = tl;
		this.condition = i;
		this.setLayout(null);
		this.setSize(250, 200);
		this.setLocation(400, 250);
		
		this.initialize();
	}
	
	private void initialize(){
		JLabel title = new JLabel("机构id输入");
		title.setSize(90, 30);
		title.setLocation(70, 10);
		this.getContentPane().add(title);
		
		id = new JTextArea();
		id.setBounds(20, 50, 200, 30);
		this.getContentPane().add(id);
		
		confirm = new JButton("确定");
		cancle = new JButton("取消");
		confirm.setSize(60, 25);
		cancle.setSize(60, 25);
		confirm.setLocation(30, 90);
		cancle.setLocation(110, 90);
		confirm.addActionListener(this);
		cancle.addActionListener(this);
		this.getContentPane().add(confirm);
		this.getContentPane().add(cancle);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == cancle){
			this.dispose();
		}
		if(arg0.getSource() == confirm){
			String id = this.id.getText();
			boolean result = tl.getID(id, condition);
			
			if(result){
				this.dispose();
			}
		}
	}
}

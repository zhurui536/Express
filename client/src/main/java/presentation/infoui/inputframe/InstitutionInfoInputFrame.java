package presentation.infoui.inputframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import presentation.infoui.listener.InstitutionInfoToolListener;
import util.InstitutionType;
import vo.InstitutionMessageVO;

public class InstitutionInfoInputFrame extends JFrame implements ActionListener {
	private InstitutionInfoToolListener tl;
	
	private JButton confirm;
	private JButton cancle;
	private JTextArea[] input;
	private JComboBox<String> type;
	
	//表示窗口的用途，0代表增加，1代表修改
	private int condition;
	
//	public static void main(String[] args){
//		InstitutionInfoInputFrame test = new InstitutionInfoInputFrame(null);
//		test.setVisible(true);
//	}
	
	public InstitutionInfoInputFrame(InstitutionInfoToolListener tl){
		this.condition = 0;
		this.tl = tl;
		
		this.setLayout(null);
		this.setSize(430, 205);
		this.setLocation(400, 250);
		this.initialize();
	}
	
	public InstitutionInfoInputFrame(InstitutionMessageVO vo, InstitutionInfoToolListener tl){
		this.condition = 1;
		this.tl = tl;
		
		this.setLayout(null);
		this.setSize(430, 205);
		this.setLocation(400, 250);
		this.initialize(vo);
	}
	
	private void initialize(){
		JLabel title = new JLabel("机构信息输入");
		title.setBounds(150, 10, 130, 30);
		this.getContentPane().add(title);
		
		this.input = new JTextArea[2];
		
		
		JLabel id = new JLabel("机构id：");
		id.setBounds(20, 50, 70, 30);
		this.getContentPane().add(id);
		input[0] = new JTextArea();
		input[0].setBounds(85, 50, 100, 30);
		this.getContentPane().add(input[0]);
		
		JLabel institution = new JLabel("机构名称：");
		institution.setBounds(200, 50, 70, 30);
		this.getContentPane().add(institution);
		input[1] = new JTextArea();
		input[1].setBounds(275, 50, 100, 30);
		this.getContentPane().add(input[1]);
		
		
		JLabel institutiontype = new JLabel("机构类型：");
		institutiontype.setBounds(110, 90, 70, 30);
		this.getContentPane().add(institutiontype);
		this.type = new JComboBox<String>(this.institutiontype);
		this.type.setBounds(185, 90, 120, 30);
		this.getContentPane().add(this.type);
		
		confirm = new JButton("确定");
		cancle = new JButton("取消");
		confirm.setSize(60, 25);
		cancle.setSize(60, 25);
		confirm.setLocation(120, 130);
		cancle.setLocation(200, 130);
		confirm.addActionListener(this);
		cancle.addActionListener(this);
		this.getContentPane().add(confirm);
		this.getContentPane().add(cancle);
	}
	
	private void initialize(InstitutionMessageVO vo){
		this.initialize();
		
		input[0].setText(vo.id);
		input[0].setEditable(false);
		input[1].setText(vo.name);
		
		if(vo.institutionType == this.institutionType[0]){
			type.setSelectedIndex(0);
		}
		else{
			type.setSelectedIndex(1);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == cancle){
			this.dispose();
		}
		if(arg0.getSource() == confirm){
			InstitutionMessageVO vo = new InstitutionMessageVO();
			vo.id = input[0].getText();
			vo.name = input[1].getText();
			vo.institutionType = this.institutionType[type.getSelectedIndex()];
			
			boolean result = tl.getInput(vo, condition);
			if(result){
				this.dispose();
			}
		}
	}
	
	private final String[] institutiontype = {"营业厅", "中转中心"};
	private final InstitutionType[] institutionType = {InstitutionType.BUSINESS_HALL, InstitutionType.TRANSIT_CENTER};
}

package presentation.infoui.inputframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import presentation.infoui.listener.InstitutionInfoToolListener;
import presentation.mainui.InputFrame;
import presentation.mainui.component.ToolButton;
import util.City;
import util.InstitutionType;
import vo.InstitutionMessageVO;

@SuppressWarnings("serial")
public class InstitutionInfoInputFrame extends InputFrame implements ActionListener {
	private InstitutionInfoToolListener tl;
	
	private JButton confirm;
	private JButton cancle;
	private JTextArea[] input;
	private JComboBox<String> type;
	private JComboBox<String> city;
	
	//表示窗口的用途，0代表增加，1代表修改
	private int condition;
	
	public static void main(String[] args){
		InstitutionInfoInputFrame test = new InstitutionInfoInputFrame(null);
		test.setVisible(true);
	}
	
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
		this.getContentPane().add(title, 0);
		
		this.input = new JTextArea[2];
		
		
		JLabel id = new JLabel("机构id：");
		id.setBounds(20, 50, 70, 30);
		this.getContentPane().add(id, 0);
		input[0] = new JTextArea("自动生成");
		input[0].setBounds(95, 50, 100, 30);
		input[0].setEditable(false);
		this.getContentPane().add(input[0], 0);
		
		JLabel institution = new JLabel("机构名称：");
		institution.setBounds(200, 50, 70, 30);
		this.getContentPane().add(institution, 0);
		input[1] = new JTextArea();
		input[1].setBounds(275, 50, 100, 30);
		this.getContentPane().add(input[1], 0);
		
		
		JLabel institutiontype = new JLabel("机构类型：");
		institutiontype.setBounds(20, 90, 70, 30);
		this.getContentPane().add(institutiontype, 0);
		this.type = new JComboBox<String>(this.institutiontype);
		this.type.setBounds(95, 90, 100, 30);
		this.getContentPane().add(this.type, 0);
		
		JLabel cityname = new JLabel("城市：");
		cityname.setBounds(200, 90, 70, 30);
		this.getContentPane().add(cityname, 0);
		city = new JComboBox<String>();
		for(int j=0;j<Cities.length;j++){
			city.addItem(City.cityToString(Cities[j]));
		}
		city.setBounds(275, 90, 70, 30);
		this.getContentPane().add(city, 0);
		
		confirm = new ToolButton(120, 130,"确定");
		cancle = new ToolButton(200, 130,"取消");
		confirm.setSize(60, 25);
		cancle.setSize(60, 25);
		confirm.addActionListener(this);
		cancle.addActionListener(this);
		this.getContentPane().add(confirm, 0);
		this.getContentPane().add(cancle, 0);
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
			vo.city = Cities[this.city.getSelectedIndex()];
			
			boolean result = tl.getInput(vo, condition);
			if(result){
				this.dispose();
			}
		}
	}
	
	private final String[] institutiontype = {"营业厅", "中转中心"};
	private final InstitutionType[] institutionType = {InstitutionType.BUSINESS_HALL, InstitutionType.TRANSIT_CENTER};
	private final City[] Cities = {City.NANJING, City.SHANGHAI, City.GUANGZHOU, City.BEIJING};
}

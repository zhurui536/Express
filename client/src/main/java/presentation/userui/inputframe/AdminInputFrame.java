package presentation.userui.inputframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import presentation.userui.listener.AdminToolListener;
import util.AuthorityLevel;
import vo.UserVO;

@SuppressWarnings("serial")
public class AdminInputFrame extends JFrame implements ActionListener{
	private AdminToolListener listener;
	private JTextArea[] texts;
	private JComboBox<String> level;
	private JButton confirm, cancle;
	
	//由于此窗口可以用来新增用户和修改用户信息的输入，所以需要标志，0代表新增，1代表修改
	private int condition;

	public AdminInputFrame(AdminToolListener tl){
		this.listener = tl;
		
		this.setLayout(null);
		this.setSize(430, 320);
		this.setLocation(400, 250);
		condition = 0;
		
		this.initialize();
		this.setVisible(true);
	}
	
	public AdminInputFrame(AdminToolListener tl, UserVO vo){
		this.listener = tl;
		
		this.setLayout(null);
		this.setSize(430, 320);
		this.setLocation(400, 250);
		condition = 1;
		
		this.initialize();
		this.initialize(vo);
		this.setVisible(true);
	}
	
	//输入框的构建
	private void initialize(){
		//窗口的标题
		JLabel title = new JLabel("用户信息输入");
		title.setBounds(170, 10, 90, 30);
		this.getContentPane().add(title);
		
		//窗口左边的列表
		JLabel[] list = new JLabel[4];
		for(int i=0;i<4;i++){
			list[i] = new JLabel(listname[i]);
			list[i].setBounds(15, 40+40*i, 70, 30);
			this.getContentPane().add(list[i]);
		}
		
		texts = new JTextArea[3];
		for(int i=0;i<3;i++){
			texts[i] = new JTextArea();
			texts[i].setBounds(95, 40+40*i, 250, 30);
			this.getContentPane().add(texts[i]);
		}
		
		level = new JComboBox<String>();
		level.setBounds(95, 160, 40, 30);
		for(int i=0;i<levels.length;i++){
			level.addItem(AuthorityLevel.authorityToString(levels[i]));
		}
		this.getContentPane().add(level);
		
		confirm = new JButton("确定");
		confirm.setBounds(200, 220, 60, 25);
		confirm.addActionListener(this);
		this.getContentPane().add(confirm);
		
		cancle = new JButton("取消");
		cancle.setBounds(265, 220, 60, 25);
		cancle.addActionListener(this);
		this.getContentPane().add(cancle);
	}
	
	//对输入框的初始化
	private void initialize(UserVO user){
		String[] texts = new String[3];
		texts[0] = user.getUserid();
		texts[1] = user.getStaffid();
		texts[2] = user.getPassword();
		
		for(int i=0;i<3;i++){
			this.texts[i].setText(texts[i]);
		}
		
		int i=0;
		for(;i<levels.length;i++){
			if(levels[i] == user.getLevel()){
				break;
			}
		}
		
		level.setSelectedIndex(i);
	}
	
	private final String[] listname = {"用户id", "员工id", "密码", "权限"};
	private final AuthorityLevel[] levels = {AuthorityLevel.LOW, AuthorityLevel.MEDIUM, AuthorityLevel.HIGH};

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancle){
			this.dispose();
		}
		else if(e.getSource() == confirm){
			boolean result = true;
			if(condition == 0){
				result = listener.addInput(texts[0].getText(), texts[1].getText(), texts[2].getText(), levels[level.getSelectedIndex()]);
			}
			
			if(condition == 1){
				result = listener.modifyInput(texts[0].getText(), texts[1].getText(), texts[2].getText(), levels[level.getSelectedIndex()]);
			}
			if(result){
				this.dispose();
			}
		}
	}
}

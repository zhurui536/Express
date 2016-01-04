package presentation.adminui.data;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.adminui.listener.AdminToolListener;
import presentation.mainui.component.ToolButton;
import util.AuthorityLevel;
import vo.UserVO;

@SuppressWarnings("serial")
public class AdminDataPane extends JPanel implements ActionListener {
	private ArrayList<UserVO> users;
	private ArrayList<ToolButton> deletes;
	private ArrayList<ToolButton> modifys;
	private AdminToolListener listener;
	
	public AdminDataPane(ArrayList<UserVO> vos, AdminToolListener tl){
		this.users = vos;
		this.deletes = new ArrayList<ToolButton>();
		this.modifys = new ArrayList<ToolButton>();
		this.listener = tl;
		
		this.setBounds(140, 100, 810, vos.size()*40+40);
		this.setLayout(null);
		
		this.initialize();
	}
	
	private void initialize(){
		JPanel header = new JPanel();
		header.setBounds(10, 0, 810, 40);
		header.setLayout(null);
		
		JLabel userid = new JLabel("用户id");
		userid.setBounds(0, 0, 150, 40);
		header.add(userid);
		
		JLabel staffid = new JLabel("员工id");
		staffid.setBounds(180, 0, 150, 40);
		header.add(staffid);
		
		JLabel authority = new JLabel("权限");
		authority.setBounds(360, 0, 40, 40);
		header.add(authority);
		
		JLabel password = new JLabel("密码");
		password.setBounds(430, 0, 150, 40);
		header.add(password);
		
		this.add(header);
		
		if(users != null){
			for(int i=0;i<users.size();i++){
				UserVO temp = users.get(i);
				
				JPanel item = this.makeItem(temp);
				item.setLocation(10, 40*i+40);
				
				if(i%2==1){
					item.setBackground(Color.CYAN);
				}
				else{
					item.setBackground(Color.GRAY);
				}
				this.add(item);
			}
		}
		
	}
	
	private JPanel makeItem(UserVO vo){
		JPanel item = new JPanel();
		item.setSize(810, 40);
		item.setLayout(null);
		item.setBorder(BorderFactory.createLoweredBevelBorder());
		
		JLabel userid = new JLabel(vo.getUserid());
		userid.setBounds(0, 0, 150, 40);
		item.add(userid);
		
		JLabel staffid = new JLabel(vo.getStaffid());
		staffid.setBounds(180, 0, 150, 40);
		item.add(staffid);
		
		JLabel authority = new JLabel(AuthorityLevel.authorityToString(vo.getLevel()));
		authority.setBounds(360, 0, 40, 40);
		item.add(authority);
		
		JLabel password = new JLabel(vo.getPassword());
		password.setBounds(430, 0, 150, 40);
		item.add(password);
		
		ToolButton modify = new ToolButton(600, 5, "修改");
		modify.setSize(60, 30);
		modify.addActionListener(this);
		item.add(modify);
		this.modifys.add(modify);
		
		ToolButton delete = new ToolButton(670, 5, "删除");
		delete.setSize(60, 30);
		delete.addActionListener(this);
		item.add(delete);
		this.deletes.add(delete);
		
		return item;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<deletes.size();i++){
			if(e.getSource().equals(deletes.get(i))){
				listener.delete(users.get(i));
				break;
			}
			
			if(e.getSource().equals(modifys.get(i))){
				listener.startmidify(users.get(i));
				break;
			}
		}
	}
}

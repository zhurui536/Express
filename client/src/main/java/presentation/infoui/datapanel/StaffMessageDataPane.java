package presentation.infoui.datapanel;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import util.Job;
import util.SalaryType;
import vo.StaffMessageVO;

public class StaffMessageDataPane extends JPanel {
	
	public StaffMessageDataPane(ArrayList<StaffMessageVO> vos){
		this.setBounds(140, 100, 810, 500);
		this.setLayout(null);
		
		this.initialize(vos);
	}

	private void initialize(ArrayList<StaffMessageVO> vos) {
		Object[][] rowdata = new Object[vos.size()][6];
		
		for(int i=0;i<vos.size();i++){
			StaffMessageVO vo = vos.get(i);
			rowdata[i][0] = vo.name;
			rowdata[i][1] = vo.id;
			rowdata[i][2] = vo.institutionid;
			rowdata[i][3] = Job.jobToString(vo.job);
			rowdata[i][4] = SalaryType.salaryToString(vo.salary.getType());
			rowdata[i][5] = vo.salary.getSalary()+"";
		}
		
		JTable table = new JTable(rowdata, header){
			public boolean isCellEditable(int row, int column) {
				 return false;
				 }
		};
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setRowHeight(30);
		table.setPreferredScrollableViewportSize(new Dimension(810, 30));
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(160);
		table.getColumnModel().getColumn(2).setPreferredWidth(160);
		table.getColumnModel().getColumn(3).setPreferredWidth(120);
		table.getColumnModel().getColumn(4).setPreferredWidth(60);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.setShowGrid(true);
		table.setLocation(0, 0);
		
		JScrollPane scroller = new JScrollPane(table);
		scroller.setBounds(0, 0, 810, 500);
		
		this.add(scroller);
	}
	
	private final String[] header = {"姓名", "员工编号", "机构编号", "职业", "薪水类型", "薪水"};
}

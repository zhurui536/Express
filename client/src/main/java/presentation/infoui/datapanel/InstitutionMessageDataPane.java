package presentation.infoui.datapanel;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import vo.InstitutionMessageVO;

public class InstitutionMessageDataPane extends JPanel {
	public InstitutionMessageDataPane(ArrayList<InstitutionMessageVO> vos){
		this.setBounds(140, 100, 810, 500);
		this.setLayout(null);
		
		this.initialize(vos);
	}

	private void initialize(ArrayList<InstitutionMessageVO> vos) {
		Object[][] rowdata = new Object[vos.size()][3];
		
		for(int i=0;i<vos.size();i++){
			rowdata[i][0] = vos.get(i).name;
			rowdata[i][1] = vos.get(i).id;
			rowdata[i][2] = vos.get(i).institutionType;
		}
		
		JTable table = new JTable(rowdata, header){
			public boolean isCellEditable(int row, int column) {
				 return false;
				 }
		};
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setRowHeight(30);
		table.setPreferredScrollableViewportSize(new Dimension(810, 30));
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.setShowGrid(true);
		table.setLocation(0, 0);
		
		JScrollPane scroller = new JScrollPane(table);
		scroller.setBounds(0, 0, 810, 500);
		
		this.add(scroller);
	}
	
	private final String[] header = {"机构名称", "机构编号", "机构类型"};
}

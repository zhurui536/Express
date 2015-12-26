package presentation.infoui.datapanel;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import util.MyJTable;
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
		
		MyJTable table = new MyJTable(rowdata, header);
		table.setWidth(new int[]{200, 200, 200});
		
		JScrollPane scroller = new JScrollPane(table);
		scroller.setBounds(0, 0, 810, 500);
		
		this.add(scroller);
	}
	
	private final String[] header = {"机构名称", "机构编号", "机构类型"};
}

package presentation.adminui.data;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import util.MyJTable;
import vo.SystemlogVO;

public class LogDataPane extends JPanel{
        
        private static final long serialVersionUID = 714370582721723069L;
        private ArrayList<SystemlogVO> systemlogVOs;
        
        public LogDataPane(ArrayList<SystemlogVO> systemlogVOs) {
                this.systemlogVOs = systemlogVOs;
                this.setLayout(null);
                paintData();
        }
        
        private void paintData() {
                Object[] header = {"时间","来源","用户","事件"};
                Object[][] data = new Object[systemlogVOs.size()][4];
                for (int i = 0; i < systemlogVOs.size(); i++) {
                       data[i][0] = systemlogVOs.get(i).time.toString();
                       data[i][1] = systemlogVOs.get(i).origin;
                       data[i][2] = systemlogVOs.get(i).userID;
                       data[i][3] = systemlogVOs.get(i).event;
                }
                MyJTable table = new MyJTable(data, header){
                        private static final long serialVersionUID = 4793447602889900829L;
                };
                table.setWidth(new int[]{190, 200, 200, 200});
                
                JScrollPane scroller = new JScrollPane(table);
                scroller.setBounds(0, 0, 810, 500);
                
                this.add(scroller);
        }

}

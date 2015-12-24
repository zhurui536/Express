package presentation.userui.data;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import vo.SystemlogVO;

public class LogDataPane extends JPanel{
        
        private static final long serialVersionUID = 714370582721723069L;
        private ArrayList<SystemlogVO> systemlogVOs;
        
        public LogDataPane(ArrayList<SystemlogVO> systemlogVOs) {
                this.systemlogVOs = systemlogVOs;
                paintData();
        }
        
        private void paintData() {
                Object[] header = {"时间","来源","用户","时间"};
                Object[][] data = new Object[systemlogVOs.size()][4];
                for (int i = 0; i < systemlogVOs.size(); i++) {
                       data[i][0] = systemlogVOs.get(i).time.toString();
                       data[i][1] = systemlogVOs.get(i).origin;
                       data[i][2] = systemlogVOs.get(i).userID;
                       data[i][3] = systemlogVOs.get(i).event;
                }
                JTable table = new JTable(data, header){
                        private static final long serialVersionUID = 4793447602889900829L;

                        public boolean isCellEditable(int row, int column) {
                                 return false;
                                 }
                };
                table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                table.setRowHeight(30);
                table.setPreferredScrollableViewportSize(new Dimension(810, 30));
                table.getColumnModel().getColumn(0).setPreferredWidth(130);
                table.getColumnModel().getColumn(1).setPreferredWidth(200);
                table.getColumnModel().getColumn(2).setPreferredWidth(200);
                table.getColumnModel().getColumn(3).setPreferredWidth(200);
                table.setShowGrid(true);
                table.setLocation(0, 0);
                
                JScrollPane scroller = new JScrollPane(table);
                scroller.setBounds(0, 0, 810, 500);
                
                this.add(scroller);
        }

}

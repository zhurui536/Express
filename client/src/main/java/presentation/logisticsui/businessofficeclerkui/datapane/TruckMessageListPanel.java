package presentation.logisticsui.businessofficeclerkui.datapane;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import util.MyJTable;
import vo.TruckMessageVO;

@SuppressWarnings("serial")
public class TruckMessageListPanel extends JPanel{
        
        private final String[] nameStrings = { "车辆编号", "车牌号", "服役时间/年" };
        
        private final int numbers = nameStrings.length;
        
        private ArrayList<TruckMessageVO> truckMessageVOs;

        public TruckMessageListPanel(ArrayList<TruckMessageVO> truckMessageVOs) {
                super();
                this.truckMessageVOs= truckMessageVOs;
                this.setLayout(null);
                this.setSize(810,650);
                init();
        }
        private void init(){
                Object[][] data = new Object[truckMessageVOs.size()][numbers];
                for (int i = 0; i < data.length; i++) {
                        data[i][0] = truckMessageVOs.get(i).id;
                        data[i][1] = truckMessageVOs.get(i).plateNumber;
                        data[i][2] = truckMessageVOs.get(i).time;
                }
                MyJTable jTable = new MyJTable(data, nameStrings);
                jTable.setWidth(new int[]{270,270,270});
                JScrollPane scroller = new JScrollPane(jTable);
                scroller.setBounds(0, 0, 810,650);
                this.add(scroller);
        }
        
        
}

package presentation.logisticsui.businessofficeclerkui.datapane;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;

import util.MyJTable;
import util.Sex;
import vo.DriverMessageVO;

@SuppressWarnings("serial")
public class DriverMessageListPanel extends JPanel{
        private final String[] nameStrings = {"司机编号","姓名","身份证号","手机号码","性别","出生日期","驾照期限"};
        
        private final int numbers = nameStrings.length;
        
        private ArrayList<DriverMessageVO> driverMessageVOs;

        public DriverMessageListPanel(
                        ArrayList<DriverMessageVO> driverMessageVOs) {
                super();
                this.driverMessageVOs = driverMessageVOs;
                this.setLayout(null);
                this.setSize(810,650);
                init();
        }
        
        private void init(){
                Object[][] data = new Object[driverMessageVOs.size()][numbers];
                for (int i = 0; i < data.length; i++) {
                        //{"司机编号","姓名","身份证号","手机号码","性别","出生日期","驾照期限"};
                        data[i][0] = driverMessageVOs.get(i).driverId;
                        data[i][1] = driverMessageVOs.get(i).name;
                        data[i][2] = driverMessageVOs.get(i).ID;
                        data[i][3] = driverMessageVOs.get(i).phoneNum;
                        data[i][4] = Sex.sexToString(driverMessageVOs.get(i).sex);
                        data[i][5] = driverMessageVOs.get(i).birth.toDayString();
                        data[i][6] = driverMessageVOs.get(i).terminationTime.toDayString();
                }
                JTable jTable = new MyJTable(data, nameStrings);
                this.add(jTable);
        }
}

package presentation.logisticsui.businessofficeclerkui.datapane;

import javax.swing.JLabel;
import javax.swing.JPanel;

import util.Sex;
import vo.DriverMessageVO;

@SuppressWarnings("serial")
public class DriverMessageDataPanel extends JPanel{
        private final String[] nameStrings = {"司机编号:","姓名:","身份证号:","手机号码:","性别:","出生日期:","驾照期限:"};
        
        private final int numbers = nameStrings.length;
        
        private JLabel[] datas;
        
        private DriverMessageVO driverMessageVO;
        
        public DriverMessageDataPanel(DriverMessageVO driverMessageVO) {
               this.driverMessageVO = driverMessageVO;
               this.setLayout(null);
               this.setSize(810,650);
               init();
        }

        private void init() {
                datas = new JLabel[numbers];
                for (int i = 0; i < numbers; i++) {
                        datas[i] = new JLabel(nameStrings[i]);
                        datas[i].setSize(250,30);
                }
                datas[0].setText(datas[0].getText() + driverMessageVO.driverId);
                this.add(datas[0]);
                datas[1].setText(datas[1].getText() + driverMessageVO.name);
                datas[2].setText(datas[2].getText() + driverMessageVO.ID);
                datas[3].setText(datas[3].getText() + driverMessageVO.phoneNum);
                datas[4].setText(datas[4].getText() + Sex.sexToString(driverMessageVO.sex));
                datas[5].setText(datas[5].getText() + driverMessageVO.birth.toDayString());
                datas[6].setText(datas[6].getText() + driverMessageVO.terminationTime.toDayString());
                datas[0].setLocation(15, 15);
                for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 2; j++) {
                                datas[i * 2 + j + 1].setLocation(15 + j * 280,  60 + i * 45);
                                this.add(datas[i * 2 + j + 1]);
                        }
                }
        }
        
}

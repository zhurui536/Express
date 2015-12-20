package presentation.logisticsui.businessofficeclerkui.datapane;

import javax.swing.JLabel;
import javax.swing.JPanel;

import vo.TruckMessageVO;

@SuppressWarnings("serial")
public class TruckMessageDataPane extends JPanel{

        private final String[] nameStrings = { "车辆编号:", "车牌号:", "服役时间:", "年" };
        
        private JLabel[] datas;
        
        private TruckMessageVO truckMessageVO;
        
        public TruckMessageDataPane(TruckMessageVO truckMessageVO) {
                this.truckMessageVO = truckMessageVO;
                this.setLayout(null);
                this.setSize(810,650);
                init();
        }

        private void init() {
                datas = new JLabel[3];
                for (int i = 0; i < 3; i++) {
                        datas[i] = new JLabel(nameStrings[i]);
                }
                datas[0].setText(datas[0].getText() + truckMessageVO.id);
                datas[1].setText(datas[1].getText() + truckMessageVO.plateNumber);
                datas[2].setText(datas[2].getText() + truckMessageVO.time + nameStrings[3]);
                
                for (int i = 0; i < 3; i++) {
                        datas[i].setBounds(50, 25 + 50 * i , 300, 30);
                }
                
                for (JLabel jLabel : datas) {
                        this.add(jLabel);
                }
        }


}

package presentation.logisticsui.businessofficeclerkui.inputframe;

import bussinesslogicservice.infoblservice.InfoBLSerivce;
import presentation.WarningDialog;
import presentation.logisticsui.businessofficeclerkui.BusinessOfficeClerkFrame;
import presentation.logisticsui.businessofficeclerkui.listerner.toollistener.TruckMessageToolListener;
import util.ResultMessage;
import vo.TruckMessageVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class TruckMessageInputFrame extends JFrame implements ActionListener {

        private final String[] nameStrings = { "车辆编号", "车牌号", "服役时间", "年" };

        private enum frameState {
                ADD, MOD
        };

        private frameState state;

        private JLabel[] labels;

        private JTextArea[] jTextAreas;

        private JButton confirm, cancle;

        private BusinessOfficeClerkFrame ui;

        private TruckMessageVO truckMessageVO;

        public TruckMessageInputFrame(
                        TruckMessageToolListener truckMessageToolListener,
                        TruckMessageVO truckMessageVO) {
                this.state = frameState.MOD;
                this.truckMessageVO = truckMessageVO;
                this.ui = truckMessageToolListener.getUi();
                init();
        }

        private void init() {
                labels = new JLabel[4];
                for (int i = 0; i < 4; i++) {
                        labels[i] = new JLabel(nameStrings[i]);
                }
                jTextAreas = new JTextArea[3];
                for (int i = 0; i < 3; i++) {
                        jTextAreas[i] = new JTextArea();
                }
                this.setName("车辆信息维护");
                this.setLayout(null);
                this.setSize(330, 190);
                this.setLocation(400, 250);

                for (int i = 0; i < 3; i++) {
                        labels[i].setBounds(15, 15 + 45 * i, 100, 30);
                        this.getContentPane().add(labels[i]);
                }
                labels[3].setBounds(285, 105, 50, 30);
                this.getContentPane().add(labels[3]);

                if (state == frameState.MOD) {
                        jTextAreas[0].setText(truckMessageVO.id);
                        jTextAreas[0].setEditable(false);
                        jTextAreas[1].setText(truckMessageVO.plateNumber);
                        jTextAreas[2].setText(truckMessageVO.time + "");
                }
                for (int i = 0; i < 3; i++) {
                        jTextAreas[i].setBounds(115, 15 + 45 * i, i == 2 ? 150
                                        : 200, 30);
                        this.getContentPane().add(jTextAreas[i]);
                }

                confirm = new JButton("确定");
                confirm.setBounds(180, 150, 60, 25);
                confirm.addActionListener(this);
                this.getContentPane().add(confirm);
                cancle = new JButton("取消");
                cancle.setBounds(255, 150, 60, 25);
                cancle.addActionListener(this);
                this.getContentPane().add(cancle);
        }

        public TruckMessageInputFrame(
                        TruckMessageToolListener truckMessageToolListener) {
                this.state = frameState.ADD;
                this.ui = truckMessageToolListener.getUi();
                init();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                if (e.getSource() == confirm) {
                        TruckMessageVO truckMessageVO = new TruckMessageVO(
                                        jTextAreas[0].getText(),
                                        jTextAreas[1].getText(),
                                        Integer.parseInt(jTextAreas[2]
                                                        .getText()));
                        InfoBLSerivce infoBLSerivce = ui.getInfoBLSerivce();
                        if(state == frameState.ADD){
                                ResultMessage resultMessage = infoBLSerivce.addTruckMessage(truckMessageVO);
                                new WarningDialog(ui, resultMessage.getKey());
                        }else{
                                ResultMessage resultMessage = infoBLSerivce.modTruckMessage(truckMessageVO);
                                new WarningDialog(ui, resultMessage.getKey());
                        }
                        this.setVisible(false);
                } else if (e.getSource() == cancle) {
                        this.setVisible(false);
                }

        }

}

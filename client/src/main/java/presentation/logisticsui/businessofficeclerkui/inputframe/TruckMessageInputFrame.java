package presentation.logisticsui.businessofficeclerkui.inputframe;

import bussinesslogicservice.infoblservice.InfoBLSerivce;
import presentation.WarningDialog;
import presentation.logisticsui.InputChecker;
import presentation.logisticsui.businessofficeclerkui.BusinessOfficeClerkFrame;
import presentation.logisticsui.businessofficeclerkui.listerner.toollistener.TruckMessageToolListener;
import presentation.mainui.InputFrame;
import presentation.mainui.component.ToolButton;
import util.ResultMessage;
import vo.TruckMessageVO;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class TruckMessageInputFrame extends InputFrame implements ActionListener {

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
        
        private JLabel errOutputLabel;

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
                        this.getContentPane().add(labels[i], 0);
                }
                labels[3].setBounds(285, 105, 50, 30);
                this.getContentPane().add(labels[3], 0);

                if (state == frameState.MOD) {
                        jTextAreas[0].setText(truckMessageVO.id);
                        jTextAreas[0].setEditable(false);
                        jTextAreas[1].setText(truckMessageVO.plateNumber);
                        jTextAreas[2].setText(truckMessageVO.time + "");
                }
                for (int i = 0; i < 3; i++) {
                        jTextAreas[i].setBounds(115, 15 + 45 * i, i == 2 ? 150
                                        : 200, 30);
                        this.getContentPane().add(jTextAreas[i], 0);
                }

                confirm = new ToolButton(180, 150,"确定");
                confirm.setSize( 60, 25);
                confirm.addActionListener(this);
                this.getContentPane().add(confirm, 0);
                cancle = new ToolButton(255, 150,"取消");
                cancle.setSize( 60, 25);
                cancle.addActionListener(this);
                this.getContentPane().add(cancle, 0);
                
                errOutputLabel = new JLabel();
                errOutputLabel.setBounds(15, 150 , 230, 30);
                errOutputLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
                errOutputLabel.setForeground(Color.RED);
                this.getContentPane().add(errOutputLabel, 0);
        }

        public TruckMessageInputFrame(
                        TruckMessageToolListener truckMessageToolListener) {
                this.state = frameState.ADD;
                this.ui = truckMessageToolListener.getUi();
                init();
        }

//        public static void main(String[] args) {
//                TruckMessageInputFrame truckMessageInputFrame = new TruckMessageInputFrame(null);
//                truckMessageInputFrame.setVisible(true);
//        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
                if (e.getSource() == confirm) {
                        if(!InputChecker.isNum( jTextAreas[0].getText())){
                                errOutputLabel.setText("车辆编号必须为数字！");
                                return;
                        }
                        if(!InputChecker.isChineseChar(jTextAreas[1].getText())){
                                errOutputLabel.setText("车牌号非法！");
                                return;
                        }
                        if (!InputChecker.isNum(jTextAreas[2].getText())
                                        || InputChecker.isMinus(jTextAreas[2]
                                                        .getText())) {
                                errOutputLabel.setText("服役时间必须为正数！");
                                return;
                        }
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

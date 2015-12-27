package presentation.logisticsui.businessofficeclerkui.inputframe;

import bussinesslogicservice.infoblservice.InfoBLSerivce;
import presentation.WarningDialog;
import presentation.logisticsui.InputChecker;
import presentation.logisticsui.businessofficeclerkui.BusinessOfficeClerkFrame;
import presentation.logisticsui.businessofficeclerkui.datapane.DriverMessageDataPanel;
import presentation.logisticsui.businessofficeclerkui.listerner.toollistener.DriverMessageToolListener;
import util.ResultMessage;
import vo.DriverMessageVO;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class DriverIdInputFrame extends JFrame implements ActionListener{
        
        private DriverMessageToolListener listener;
        
        private JButton confirm, cancle;
        
        private JLabel label;
        
        private JTextArea textArea;
        
        private int kind;
        
        private BusinessOfficeClerkFrame ui;
        
        private JLabel errOutPutLabel;

        public DriverIdInputFrame(DriverMessageToolListener listener, int kind) {
                this.listener = listener;
                this.setName("司机ID输入");
                this.setLayout(null);
                this.setSize(460, 240);
                this.setLocation(350, 150);
                this.kind = kind;
                this.ui = listener.getUi();
                init();
        }
        
        private void init() {
                confirm = new JButton("确定");
                cancle = new JButton("取消");
                confirm.setSize(60, 25);
                cancle.setSize(60, 25);
                confirm.setLocation(250, 190);
                cancle.setLocation(330, 190);
                confirm.addActionListener(this);
                cancle.addActionListener(this);
                this.getContentPane().add(confirm);
                this.getContentPane().add(cancle);
                
                label = new JLabel("输入ID:");
                label.setSize(70, 30);
                label.setLocation(15, 90);
                this.getContentPane().add(label);
                
                textArea = new JTextArea();
                textArea.setSize(260,30);
                textArea.setLocation(110, 90);
                this.getContentPane().add(textArea);
                
                errOutPutLabel = new JLabel();
                errOutPutLabel.setBounds(30, 190, 190, 30);
                errOutPutLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
                errOutPutLabel.setForeground(Color.RED);
                this.getContentPane().add(errOutPutLabel);
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
                if(e.getSource() == confirm){
                        String ID = textArea.getText();
                        if(ID.equals("")){
                                errOutPutLabel.setText("请填入司机ID！");
                                return;
                        }
                        if(!InputChecker.isNum(ID)){
                                errOutPutLabel.setText("司机ID必须为纯数字！");
                                return;
                        }
                        InfoBLSerivce infoBLSerivce = ui.getInfoBLSerivce();
                        if(kind == 0){
                                ResultMessage resultMessage = infoBLSerivce.delDriverMessage(ID);
                                if(resultMessage.getKey().equals("SUCCESS")){
                                        new WarningDialog(ui, "成功删除");
                                }else if(resultMessage.getKey().equals("NO_EXIST")){
                                        new WarningDialog(ui, "不存在对应信息");
                                }else{
                                        new WarningDialog(ui, resultMessage);
                                }
                                
                        }else if(kind == 1){
                                ResultMessage resultMessage = infoBLSerivce.showDriverMessage(ID);
                                if(resultMessage.getKey().equals("SUCCESS")){
                                        DriverMessageDataPanel dataPanel = new DriverMessageDataPanel((DriverMessageVO)resultMessage.getValue());
                                        ui.paintdata(dataPanel);
                                }else if(resultMessage.getKey().equals("FAIL")){
                                        new WarningDialog(ui, "不存在对应信息");
                                }else{
                                        new WarningDialog(ui, resultMessage);
                                }
                        }else if(kind == -1){
                                ResultMessage resultMessage = infoBLSerivce.showDriverMessage(ID);
                                if(resultMessage.getKey().equals("SUCCESS")){
                                        DriverMessageVO driverMessageVO = (DriverMessageVO) resultMessage.getValue();
                                        DriverMessageInputFrame driverMessageInputFrame = new DriverMessageInputFrame(listener, driverMessageVO);
                                        driverMessageInputFrame.setVisible(true);
                                }else if(resultMessage.getKey().equals("FAIL")){
                                        new WarningDialog(ui, "不存在对应信息");
                                }else{
                                        new WarningDialog(ui, resultMessage);
                                }
                        }
                }
                this.setVisible(false);
        }

}

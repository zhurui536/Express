package presentation.logisticsui.businessofficeclerkui.inputframe;

import bussinesslogicservice.infoblservice.InfoBLSerivce;
import presentation.WarningDialog;
import presentation.logisticsui.InputChecker;
import presentation.logisticsui.businessofficeclerkui.BusinessOfficeClerkFrame;
import presentation.logisticsui.businessofficeclerkui.datapane.TruckMessageDataPane;
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
public class TruckIdInputFrame extends InputFrame implements ActionListener{

        private TruckMessageToolListener listener;
        
        private JButton confirm, cancle;
        
        private JLabel label;
        
        private JTextArea textArea;
        
        private int kind;
        
        private BusinessOfficeClerkFrame ui;
        
        private JLabel errOutPutLabel;
        
        public TruckIdInputFrame(
                        TruckMessageToolListener truckMessageToolListener, int kind) {
                this.listener = truckMessageToolListener;
                this.setName("车辆ID输入");
                this.setLayout(null);
                this.setSize(460, 240);
                this.setLocation(350, 150);
                this.kind = kind;
                this.ui = listener.getUi();
                init();
        }

        private void init() {
                confirm = new ToolButton(250, 190,"确定");
                cancle = new ToolButton(330, 190,"取消");
                confirm.setSize(60, 25);
                cancle.setSize(60, 25);
                confirm.addActionListener(this);
                cancle.addActionListener(this);
                this.getContentPane().add(confirm);
                this.getContentPane().add(cancle);
                
                label = new JLabel("输入ID:");
                label.setSize(70, 30);
                label.setFont(new Font("微软雅黑", Font.BOLD, 15));
                label.setLocation(15, 90);
                this.getContentPane().add(label);
                
                textArea = new JTextArea();
                textArea.setSize(260,30);
                textArea.setLocation(110, 90);
                this.getContentPane().add(textArea);
                
                errOutPutLabel = new JLabel();
                errOutPutLabel.setBounds(30, 180, 190, 30);
                errOutPutLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
                errOutPutLabel.setForeground(Color.RED);
                this.getContentPane().add(errOutPutLabel);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                if(e.getSource() == confirm){
                        String ID = textArea.getText();
                        if(ID.equals("")){
                                errOutPutLabel.setText("请填入车辆ID！");
                                return;
                        }
                        if(!InputChecker.isNum(ID)){
                                errOutPutLabel.setText("车辆ID必须为纯数字！");
                                return;
                        }
                        InfoBLSerivce infoBLSerivce = ui.getInfoBLSerivce();
                        if(kind == 0){
                                ResultMessage resultMessage = infoBLSerivce.delTruckMessage(ID);
                                if(resultMessage.getKey().equals("SUCCESS")){
                                        new WarningDialog(ui, "成功删除");
                                }else if(resultMessage.getKey().equals("NO_EXIST")){
                                        new WarningDialog(ui, "不存在对应信息");
                                }else{
                                        new WarningDialog(ui, resultMessage);
                                }
                        }else if(kind == 1){
                                ResultMessage resultMessage = infoBLSerivce.showTruckMessage(ID);
                                if(resultMessage.getKey().equals("SUCCESS")){
                                        TruckMessageDataPane dataPanel = new TruckMessageDataPane((TruckMessageVO)resultMessage.getValue());
                                        ui.paintdata(dataPanel);
                                }else if(resultMessage.getKey().equals("FAIL")){
                                        new WarningDialog(ui, "不存在对应信息");
                                }else{
                                        new WarningDialog(ui, resultMessage);
                                }
                        }else if(kind == -1){
                                ResultMessage resultMessage = infoBLSerivce.showTruckMessage(ID);
                                if(resultMessage.getKey().equals("SUCCESS")){
                                        TruckMessageVO truckMessageVO = (TruckMessageVO) resultMessage.getValue();
                                        TruckMessageInputFrame truckMessageInputFrame = new TruckMessageInputFrame(listener, truckMessageVO);
                                        truckMessageInputFrame.setVisible(true);
                                }
                                if(resultMessage.getKey().equals("FAIL")){
                                        new WarningDialog(ui, resultMessage.getKey());
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

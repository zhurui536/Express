package presentation.logisticsui.businessofficeclerkui.inputframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import bussinesslogicservice.infoblservice.InfoBLSerivce;

import presentation.logisticsui.businessofficeclerkui.BusinessOfficeClerkFrame;
import presentation.logisticsui.businessofficeclerkui.datapane.DriverMessageDataPanel;
import presentation.logisticsui.businessofficeclerkui.datapane.ResultDialog;
import presentation.logisticsui.businessofficeclerkui.listerner.toollistener.DriverMessageToolListener;
import util.ResultMessage;
import vo.DriverMessageVO;

@SuppressWarnings("serial")
public class DriverIdInputFrame extends JFrame implements ActionListener{
        
        private DriverMessageToolListener listener;
        
        private JButton confirm, cancle;
        
        private JLabel label;
        
        private JTextArea textArea;
        
        private int kind;
        
        private BusinessOfficeClerkFrame ui;

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
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                if(e.getSource() == confirm){
                        InfoBLSerivce infoBLSerivce = ui.getInfoBLSerivce();
                        if(kind == 0){
                                ResultMessage resultMessage = infoBLSerivce.delDriverMessage(textArea.getText());
                                ResultDialog resultDialog = new ResultDialog(resultMessage.getKey());
                                resultDialog.setVisible(true);
                        }else if(kind == 1){
                                ResultMessage resultMessage = infoBLSerivce.showDriverMessage(textArea.getText());
                                if(resultMessage.getKey().equals("SUCCESS")){
                                        DriverMessageDataPanel dataPanel = new DriverMessageDataPanel((DriverMessageVO)resultMessage.getValue());
                                        ui.paintdata(dataPanel);
                                }
                        }else if(kind == -1){
                                ResultMessage resultMessage = infoBLSerivce.showDriverMessage(textArea.getText());
                                if(resultMessage.getKey().equals("SUCCESS")){
                                        DriverMessageVO driverMessageVO = (DriverMessageVO) resultMessage.getValue();
                                        DriverMessageInputFrame driverMessageInputFrame = new DriverMessageInputFrame(listener, driverMessageVO);
                                        driverMessageInputFrame.setVisible(true);
                                }
                                if(resultMessage.getKey().equals("FAIL")){
                                        ResultDialog resultDialog = new ResultDialog(resultMessage.getKey());
                                        resultDialog.setVisible(true);
                                }
                        }
                }
                this.setVisible(false);
        }

}
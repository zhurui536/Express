package presentation.logisticsui.businessofficeclerkui.inputframe;

import bussinesslogicservice.infoblservice.InfoBLSerivce;
import presentation.WarningDialog;
import presentation.logisticsui.InputChecker;
import presentation.logisticsui.businessofficeclerkui.BusinessOfficeClerkFrame;
import presentation.logisticsui.businessofficeclerkui.listerner.toollistener.DriverMessageToolListener;
import presentation.mainui.InputFrame;
import presentation.mainui.component.ToolButton;
import util.ResultMessage;
import util.Sex;
import util.Time;
import vo.DriverMessageVO;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class DriverMessageInputFrame extends InputFrame implements ActionListener{

        private final String[] nameStrings = {"司机编号","姓名","身份证号","手机号码","性别","出生日期","驾照起始","有效时间"};
        
        private enum frameState{ADD,MOD};
        
        private frameState state; 
        
        private JLabel[] labels;
        
        private JTextArea[] jTextAreas;
        
        private JComboBox<String> yearBirth, monthBirth, dayBirth;
        
        private JComboBox<String> yearStart, monthStart, dayStart;
        
        private JComboBox<String> sex;
        
        private DriverMessageVO driverMessageVO;
        
        private JButton confirm, cancle;
        
        private BusinessOfficeClerkFrame ui;
        
        private JLabel errOutputLabel;
        
        public DriverMessageInputFrame(DriverMessageToolListener listener) {
                this.state = frameState.ADD;
                this.ui = listener.getUi();
                init();
        }
        
        public DriverMessageInputFrame(DriverMessageToolListener listener, DriverMessageVO driverMessageVO) {
               this.state = frameState.MOD;
               this.driverMessageVO = driverMessageVO;
               this.ui = listener.getUi();
               init();
        }
        
        private void init() {
                labels = new JLabel[8];
                for (int i = 0; i < 8; i++) {
                        labels[i] = new JLabel(nameStrings[i]);
                }
                jTextAreas = new JTextArea[5];
                for (int i = 0; i < 5; i++) {
                        jTextAreas[i] = new JTextArea();
                }
                this.setName("司机信息维护");
                this.setLayout(null);
                this.setSize(560, 325);
                this.setLocation(400, 250);
                
                labels[0].setBounds(15, 15, 100, 30);
                this.getContentPane().add(labels[0], 0);
                for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < 2; j++) {
                                labels[i * 2 + j + 1].setBounds(15 + i * 280, 60 + j * 45, 100, 30);
                                this.getContentPane().add(labels[i * 2 + j + 1]);
                        }
                }
                
                for (int i = 0; i < 3; i++) {
                        labels[i + 5].setBounds(15, 150 + i * 45, 100, 30);
                        this.getContentPane().add(labels[i + 5], 0);
                }
                
                jTextAreas[0].setBounds(115, 15, 150, 30);
                if(state == frameState.MOD){
                        jTextAreas[0].setText(driverMessageVO.driverId);
                        jTextAreas[0].setEditable(false);
                }
                this.getContentPane().add(jTextAreas[0], 0);
                
                JLabel year = new JLabel("年");
                year.setBounds(270, 240, 40, 30);
                this.getContentPane().add(year, 0);
                
                jTextAreas[1].setBounds(115, 60, 150 , 30);
                jTextAreas[2].setBounds(395, 60, 150 , 30);
                jTextAreas[3].setBounds(115, 105, 150 , 30);
                jTextAreas[4].setBounds(115,240,150,30);
                if(state == frameState.MOD){
                        jTextAreas[1].setText(driverMessageVO.name);
                        jTextAreas[2].setText(driverMessageVO.ID);
                        jTextAreas[3].setText(driverMessageVO.phoneNum);
                        jTextAreas[4].setText(driverMessageVO.yearsOfLicense+"");
                }
                for (int i = 1; i < 5; i++) {
                        this.getContentPane().add(jTextAreas[i], 0);
                }
                
                sex = new JComboBox<String>();
                sex.addItem("男");
                sex.addItem("女");
                sex.setBounds(395, 105, 60, 30);
                
                this.getContentPane().add(sex, 0);
                
                yearBirth = new JComboBox<>();
               for (int i = 1960; i <= 1999; i++) {
                       yearBirth.addItem(i + "年");
               }
                yearBirth.setBounds(115 , 150, 120 , 30);
                this.getContentPane().add(yearBirth, 0);
                
                yearStart = new JComboBox<>();
                for (int i = 2000; i <= 2020; i++) {
                        yearStart.addItem(i + "年");
                }
                yearStart.setBounds(115 , 195, 120 , 30);
                 this.getContentPane().add(yearStart, 0);
                 
                 monthBirth = new JComboBox<>();
                 monthStart = new JComboBox<String>();
                 for (int i = 1; i <= 12; i++) {
                         String s = i  < 10 ? "0" : "";
                         monthBirth.addItem(s + i + "月");
                         monthStart.addItem(s + i + "月");
                }
                 monthBirth.setBounds(250, 150, 60, 30);
                 monthStart.setBounds(250, 195, 60, 30);
                 this.getContentPane().add(monthBirth, 0);
                 this.getContentPane().add(monthStart, 0);
                 
                 dayBirth = new JComboBox<>();
                 dayStart = new JComboBox<String>();
                 for (int i = 1; i <= 31; i++) {
                         String s = i  < 10 ? "0" : "";
                         dayBirth.addItem(s + i + "日");
                         dayStart.addItem(s + i + "日");
                }
                 dayBirth.setBounds(325, 150, 60, 30);
                 dayStart.setBounds(325, 195, 60, 30);
                 this.getContentPane().add(dayBirth, 0);
                 this.getContentPane().add(dayStart, 0);
                 
                 confirm = new ToolButton(410, 285, "确定");
                 confirm.setSize(60, 25);
                 confirm.addActionListener(this);
                 this.getContentPane().add(confirm, 0);
                 cancle = new ToolButton(485, 285,"取消");
                 cancle.setSize(60 ,25);
                 cancle.addActionListener(this);
                 this.getContentPane().add(cancle, 0);
                 
                 errOutputLabel = new JLabel();
                 errOutputLabel.setBounds(295, 15 , 230, 30);
                 errOutputLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
                 errOutputLabel.setForeground(Color.RED);
                 this.getContentPane().add(errOutputLabel, 0);
        }
        
//        public static void main(String[] args) {
//                DriverMessageInputFrame driverMessageInputFrame = new DriverMessageInputFrame(null);
//                driverMessageInputFrame.setVisible(true);
//        }

        @Override
        public void actionPerformed(ActionEvent e) {
                if(e.getSource() == confirm){
                        driverMessageVO = new DriverMessageVO();
                        driverMessageVO.birth = new Time(((String)yearBirth.getSelectedItem()).substring(0,4) + "-" 
                        + ((String)monthBirth.getSelectedItem()).substring(0,2) + "-" 
                                        + ((String)dayBirth.getSelectedItem()).substring(0, 2));
                        if(!InputChecker.isNum(jTextAreas[0].getText())){
                                errOutputLabel.setText("司机ID必须是数字！");
                                return;
                        }
                        driverMessageVO.driverId = jTextAreas[0].getText();
                        if(!InputChecker.isIdNum(jTextAreas[3].getText())){
                                errOutputLabel.setText("不合法的身份证号！");
                                return;
                        }
                        driverMessageVO.ID = jTextAreas[3].getText();
                        if(jTextAreas[1].getText().equals("")){
                                errOutputLabel.setText("请输入姓名！");
                                return;
                        }
                        driverMessageVO.name = jTextAreas[1].getText();
                        if(!InputChecker.isNum(jTextAreas[2].getText())){
                                errOutputLabel.setText("手机号必须是数字！");
                                return;
                        }
                        driverMessageVO.phoneNum = jTextAreas[2].getText();
                        driverMessageVO.sex = Sex.stringToSex((String)sex.getSelectedItem());
                        driverMessageVO.registrationTime = new Time(((String)yearStart.getSelectedItem()).substring(0,4) + "-" 
                        + ((String)monthStart.getSelectedItem()).substring(0,2) + "-" 
                                        + ((String)dayStart.getSelectedItem()).substring(0, 2));
                        if (!InputChecker.isNum(jTextAreas[4].getText()) ||InputChecker.isMinus(jTextAreas[4].getText())) {
                                errOutputLabel.setText("驾照有效时间必须是正数！");
                                return;
                        }
                        driverMessageVO.yearsOfLicense = Integer.parseInt(jTextAreas[4].getText());
                        driverMessageVO.terminationTime = driverMessageVO.registrationTime.add(driverMessageVO.yearsOfLicense);
                        InfoBLSerivce infoBLSerivce = ui.getInfoBLSerivce();
                        
                        if(state == frameState.ADD){
                                ResultMessage resultMessage = infoBLSerivce.addDriverMessage(driverMessageVO);
                                if(resultMessage.getKey().equals("SUCCESS"))
                                        new WarningDialog(ui, "成功添加司机信息");
                                else if(resultMessage.getKey().equals("EXIST"))
                                        new WarningDialog(ui, "司机信息已存在");
                                else
                                        new WarningDialog(ui, resultMessage);
                        }
                        else {
                                ResultMessage resultMessage = infoBLSerivce.modDriverMessage(driverMessageVO);
                                if(resultMessage.getKey().equals("SUCCESS"))
                                        new WarningDialog(ui, "成功修改司机信息");
                                else if(resultMessage.getKey().equals("NO_EXIST"))
                                        new WarningDialog(ui, "司机信息不存在");
                                else
                                        new WarningDialog(ui, resultMessage.getKey());
                        }
                       
                        this.setVisible(false);
                        
                
                }else if(e.getSource() == cancle){
                        this.setVisible(false);
                }
        }

}

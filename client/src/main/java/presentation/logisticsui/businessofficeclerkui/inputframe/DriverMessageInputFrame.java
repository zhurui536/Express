package presentation.logisticsui.businessofficeclerkui.inputframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import bussinesslogicservice.infoblservice.InfoBLSerivce;

import presentation.logisticsui.businessofficeclerkui.BusinessOfficeClerkFrame;
import presentation.logisticsui.businessofficeclerkui.datapane.ResultDialog;
import presentation.logisticsui.businessofficeclerkui.listerner.toollistener.DriverMessageToolListener;
import util.ResultMessage;
import util.Sex;
import util.Time;
import vo.DriverMessageVO;

@SuppressWarnings("serial")
public class DriverMessageInputFrame extends JFrame implements ActionListener{

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
                this.getContentPane().add(labels[0]);
                for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < 2; j++) {
                                labels[i * 2 + j + 1].setBounds(15 + i * 280, 60 + j * 45, 100, 30);
                                this.getContentPane().add(labels[i * 2 + j + 1]);
                        }
                }
                
                for (int i = 0; i < 3; i++) {
                        labels[i + 5].setBounds(15, 150 + i * 45, 100, 30);
                        this.getContentPane().add(labels[i + 5]);
                }
                
                jTextAreas[0].setBounds(115, 15, 150, 30);
                if(state == frameState.MOD){
                        jTextAreas[0].setText(driverMessageVO.driverId);
                        jTextAreas[0].setEditable(false);
                }
                this.getContentPane().add(jTextAreas[0]);
                
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
                        this.getContentPane().add(jTextAreas[i]);
                }
                
                sex = new JComboBox<String>();
                sex.addItem("男");
                sex.addItem("女");
                sex.setBounds(395, 105, 60, 30);
                
                this.getContentPane().add(sex);
                
                yearBirth = new JComboBox<>();
               for (int i = 1960; i <= 1999; i++) {
                       yearBirth.addItem(i + "年");
               }
                yearBirth.setBounds(115 , 150, 120 , 30);
                this.getContentPane().add(yearBirth);
                
                yearStart = new JComboBox<>();
                for (int i = 2000; i <= 2020; i++) {
                        yearStart.addItem(i + "年");
                }
                yearStart.setBounds(115 , 195, 120 , 30);
                 this.getContentPane().add(yearStart);
                 
                 monthBirth = new JComboBox<>();
                 monthStart = new JComboBox<String>();
                 for (int i = 1; i <= 12; i++) {
                         String s = i  < 10 ? "0" : "";
                         monthBirth.addItem(s + i + "月");
                         monthStart.addItem(s + i + "月");
                }
                 monthBirth.setBounds(250, 150, 60, 30);
                 monthStart.setBounds(250, 195, 60, 30);
                 this.getContentPane().add(monthBirth);
                 this.getContentPane().add(monthStart);
                 
                 dayBirth = new JComboBox<>();
                 dayStart = new JComboBox<String>();
                 for (int i = 1; i <= 31; i++) {
                         String s = i  < 10 ? "0" : "";
                         dayBirth.addItem(s + i + "日");
                         dayStart.addItem(s + i + "日");
                }
                 dayBirth.setBounds(325, 150, 60, 30);
                 dayStart.setBounds(325, 195, 60, 30);
                 this.getContentPane().add(dayBirth);
                 this.getContentPane().add(dayStart);
                 
                 confirm = new JButton("确定");
                 confirm.setBounds(410, 285, 60, 25);
                 confirm.addActionListener(this);
                 this.getContentPane().add(confirm);
                 cancle = new JButton("取消");
                 cancle.setBounds(485, 285, 60 ,25);
                 cancle.addActionListener(this);
                 this.getContentPane().add(cancle);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                if(e.getSource() == confirm){
                        driverMessageVO = new DriverMessageVO();
                        driverMessageVO.birth = new Time(((String)yearBirth.getSelectedItem()).substring(0,4) + "-" 
                        + ((String)monthBirth.getSelectedItem()).substring(0,2) + "-" 
                                        + ((String)dayBirth.getSelectedItem()).substring(0, 2));
                        driverMessageVO.driverId = jTextAreas[0].getText();
                        driverMessageVO.ID = jTextAreas[2].getText();
                        driverMessageVO.name = jTextAreas[1].getText();
                        driverMessageVO.phoneNum = jTextAreas[3].getText();
                        driverMessageVO.sex = Sex.stringToSex((String)sex.getSelectedItem());
                        driverMessageVO.registrationTime = new Time(((String)yearStart.getSelectedItem()).substring(0,4) + "-" 
                        + ((String)monthStart.getSelectedItem()).substring(0,2) + "-" 
                                        + ((String)dayStart.getSelectedItem()).substring(0, 2));
                        driverMessageVO.yearsOfLicense = Integer.parseInt(jTextAreas[4].getText());
                        driverMessageVO.terminationTime = driverMessageVO.registrationTime.add(driverMessageVO.yearsOfLicense);
                        InfoBLSerivce infoBLSerivce = ui.getInfoBLSerivce();
                        
                        if(state == frameState.ADD){
                                ResultMessage resultMessage = infoBLSerivce.addDriverMessage(driverMessageVO);
                                ResultDialog resultDialog = new ResultDialog(resultMessage.getKey());
                                resultDialog.setVisible(true);
                        }
                        else {
                                ResultMessage resultMessage = infoBLSerivce.modDriverMessage(driverMessageVO);
                                ResultDialog resultDialog = new ResultDialog(resultMessage.getKey());
                                resultDialog.setVisible(true);
                        }
                       
                        this.setVisible(false);
                        
                
                }else if(e.getSource() == cancle){
                        this.setVisible(false);
                }
        }

}

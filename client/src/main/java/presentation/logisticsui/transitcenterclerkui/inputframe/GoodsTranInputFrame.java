package presentation.logisticsui.transitcenterclerkui.inputframe;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import presentation.logisticsui.InputChecker;
import presentation.logisticsui.transitcenterclerkui.listener.toollistener.GoodsTranToolListener;
import presentation.mainui.InputFrame;
import presentation.mainui.component.ToolButton;
import util.Time;
import util.Trans;
import vo.logisticvo.TransferBillVO;


@SuppressWarnings("serial")
public class GoodsTranInputFrame extends InputFrame implements ActionListener{

        private GoodsTranToolListener listener;
        
        private JButton confirm, cancle;
        
        private JLabel[][] jLabels;
        
        private JTextArea[][] jTextAreas;
        
        private static final String[][] nameStrings1 = {{"中转单编号","车次号","车厢号"},
                        {"出发地","到达地","监装员"},{"托运单号",null,null}};
        
        private static final String[][] nameStrings2 = {{"中转单编号","车次号","押运员"},
                        {"出发地","到达地","监装员"},{"托运单号",null,null}};
        
        private static final String[][] nameStrings3  = {{"中转单编号","航班号","货柜号"},
                        {"出发地","到达地","监装员"},{"托运单号",null,null}};
        
        private static  HashMap<Integer, String[][]> typeToStrings;
        
        static{
                typeToStrings = new HashMap<>();
                typeToStrings.put(0, nameStrings1);
                typeToStrings.put(1, nameStrings2);
                typeToStrings.put(2, nameStrings3);
        } 
        
        private int type;
        
        private JLabel errOutputLabel;
        
        public GoodsTranInputFrame(GoodsTranToolListener goodsTranToolListener,int type) {
                this.listener = goodsTranToolListener;
                this.type = type;
                this.setName("中转信息输入");
                this.setLayout(null);
                this.setSize(600, 280);
                this.setLocation(350, 150);
                init(typeToStrings.get(type));
        }
        
        public static void main(String[] args) {
                GoodsTranInputFrame goodsTranInputFrame = new GoodsTranInputFrame(null, 0);
                goodsTranInputFrame.setVisible(true);
        }

        private void init(String[][] nameStrings) {
                jLabels = new JLabel[3][3];
                jTextAreas = new JTextArea[3][3];
                for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                                if (nameStrings[i][j] == null)
                                        continue;
                                jLabels[i][j] = new JLabel(nameStrings[i][j]);
                                jLabels[i][j].setLocation(15 + j * 200,
                                                15 + i * 50);
                                jLabels[i][j].setSize(75, 35);
                                this.getContentPane().add(jLabels[i][j]);
                                jTextAreas[i][j] = new JTextArea();
                                jTextAreas[i][j].setLocation(90 + j * 190,
                                                15 + i * 50);
                                jTextAreas[i][j].setSize(100, 35);
                                this.getContentPane().add(jTextAreas[i][j]);
                        }
                }
                
//                year = new JComboBox<>();
//                for (int i = 2000; i <= 2020; i++) {
//                    year.addItem(i + "年");
//                }
//                year.setBounds(15, 170, 120, 30);
//                this.getContentPane().add(year);
//                
//                month = new JComboBox<>();
//                for (int i = 1; i <= 12; i++) {
//                        String s = i  < 10 ? "0" : "";
//                        month.addItem(s + i + "月");
//                }
//                month.setBounds(185, 170, 60, 30);
//                this.getContentPane().add(month);
//                
//                day = new JComboBox<>();
//                for (int i = 1; i <= 31; i++) {
//                        String s = i  < 10 ? "0" : "";
//                        day.addItem(s + i + "日");
//                }
//                day.setBounds(295, 170, 60, 30);
//                this.getContentPane().add(day);
                
                confirm = new ToolButton(250, 220,"确定");
                cancle = new ToolButton(330, 220,"取消");
                confirm.setSize(60, 25);
                cancle.setSize(60, 25);
                confirm.addActionListener(this);
                cancle.addActionListener(this);
                this.getContentPane().add(confirm);
                this.getContentPane().add(cancle);
                
                
                errOutputLabel = new JLabel();
                errOutputLabel.setBounds(30, 190, 190, 30);
                errOutputLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
                errOutputLabel.setForeground(Color.RED);
                this.getContentPane().add(errOutputLabel);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                if(e.getSource() == confirm){
                        TransferBillVO transferBillVO = new TransferBillVO();
//                        transferBillVO.time = new Time(((String)year.getSelectedItem()).substring(0,4) + "-"
//                                        + ((String)month.getSelectedItem()).substring(0,2) + "-" 
//                                                        + ((String)day.getSelectedItem()).substring(0, 2));
                        transferBillVO.time = new Time();
                        
                        if(!InputChecker.isNum(jTextAreas[0][0].getText())){
                                errOutputLabel.setText(jLabels[0][0].getText() +"必须是数字！");
                                return;
                        }
                        transferBillVO.transferBillNum = jTextAreas[0][0].getText();
                        if(!InputChecker.isNum(jTextAreas[0][1].getText())){
                                errOutputLabel.setText(jLabels[0][1].getText() +"必须是数字！");
                                return;
                        }
                        transferBillVO.number = jTextAreas[0][1].getText();
                        if(type != 1){
                                if(!InputChecker.isNum(jTextAreas[0][2].getText())){
                                        errOutputLabel.setText(jLabels[0][2].getText() +"必须是数字！");
                                        return;
                                }
                                transferBillVO.numOfLoc = jTextAreas[0][2].getText();
                        }else {
                                transferBillVO.supercargo = jTextAreas[0][2].getText();
                        }
                        if(jTextAreas[1][0].getText().equals("")){
                                errOutputLabel.setText("请输入" + jLabels[1][0].getText());
                                return;
                        }
                        transferBillVO.depaturePlace = jTextAreas[1][0].getText();
                        if(jTextAreas[1][1].getText().equals("")){
                                errOutputLabel.setText("请输入" + jLabels[1][1].getText());
                                return;
                        }
                        transferBillVO.arrivalPlace = jTextAreas[1][1].getText();
                        transferBillVO.supervisor = jTextAreas[1][2].getText();
                        if(jTextAreas[2][0].getText().equals("")){
                                errOutputLabel.setText("请输入" + jLabels[2][0].getText());
                                return;
                        }
                        transferBillVO.ids = new ArrayList<>();
                        for (String id : jTextAreas[2][0].getText().split(",")) {
                                transferBillVO.ids.add(id);
                        }
                        if(type == 0)
                                transferBillVO.trans = Trans.TRAIN;
                        else if(type == 1)
                                transferBillVO.trans = Trans.TRUCK;
                        else if(type == 2)
                                transferBillVO.trans = Trans.PLANE;
                        boolean result = listener.getInput(transferBillVO);
                        if(result){
                                this.setVisible(false);
                        }
                }else if(e.getSource() == cancle){
                        this.setVisible(false);
                }
        }
        
        

}

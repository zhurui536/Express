package presentation.logisticsui.businessofficeclerkui.inputframe;

import presentation.logisticsui.businessofficeclerkui.listerner.toollistener.GoodsRecToolListener;
import util.GoodsState;
import util.PublicMessage;
import vo.logisticvo.ArrivalBillVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class GoodsRecInputFrame extends JFrame implements ActionListener{

        private GoodsRecToolListener listener;
        
        private JButton confirm, cancle;
        
        private JLabel[] jLabels;
        
        private JTextArea[] jTextAreas;
        
        private JComboBox<String> year, month,day;
        
        private final String[] namesString = {"单据编号","出发地","货物状态"};
        
        public GoodsRecInputFrame(GoodsRecToolListener listener) {
                this.listener = listener;
                this.setName("接受货物信息输入");
                this.setLayout(null);
                this.setSize(430, 275);
                this.setLocation(400, 250);
                init();
        }

        private void init() {
                confirm = new JButton("确定");
                cancle = new JButton("取消");
                confirm.setSize(60, 25);
                cancle.setSize(60, 25);
                confirm.setLocation(250, 220);
                cancle.setLocation(330, 220);
                confirm.addActionListener(this);
                cancle.addActionListener(this);
                this.getContentPane().add(confirm);
                this.getContentPane().add(cancle);
                
                jLabels = new JLabel[3];
                jTextAreas = new JTextArea[3];
                for(int i=0;i<3;i++){
                        jLabels[i] = new JLabel(namesString[i]);
                        jLabels[i].setSize(75, 30);
                        jLabels[i].setLocation(15, 50+40*i);
                        this.getContentPane().add(jLabels[i]);
                        
                        jTextAreas[i] = new JTextArea();
                        jTextAreas[i].setSize(255,30);
                        jTextAreas[i].setLocation(115, 50 + 40 * i);
                        this.getContentPane().add(jTextAreas[i]);
                }
                
                year = new JComboBox<>();
                for (int i = 2000; i <= 2020; i++) {
                    year.addItem(i + "年");
                }
                year.setBounds(15, 170, 120, 30);
                this.getContentPane().add(year);
                
                month = new JComboBox<>();
                for (int i = 1; i <= 12; i++) {
                        String s = i  < 10 ? "0" : "";
                        month.addItem(s + i + "月");
                }
                month.setBounds(185, 170, 60, 30);
                this.getContentPane().add(month);
                
                day = new JComboBox<>();
                for (int i = 1; i <= 31; i++) {
                        String s = i  < 10 ? "0" : "";
                        day.addItem(s + i + "日");
                }
                day.setBounds(295, 170, 60, 30);
                this.getContentPane().add(day);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                if(e.getSource() == confirm){
                        ArrivalBillVO arrivalBillVO = new ArrivalBillVO();
                        arrivalBillVO.date = ((String)year.getSelectedItem()).substring(0,4) + "-" 
                        + ((String)month.getSelectedItem()).substring(0,2) + "-" 
                                        + ((String)day.getSelectedItem()).substring(0, 2);
                        arrivalBillVO.transferBillNum = jTextAreas[0].getText();
                        arrivalBillVO.departurePlace = jTextAreas[1].getText();
                        arrivalBillVO.goodsState = GoodsState.stringToGoodsState(jTextAreas[2].getText());
                        arrivalBillVO.institution =  PublicMessage.institutionID;
                        boolean result = listener.getInput(arrivalBillVO);
                        if(result){
                                this.setVisible(false);
                        }
                }else if(e.getSource() == cancle){
                        this.setVisible(false);
                }
        }
}

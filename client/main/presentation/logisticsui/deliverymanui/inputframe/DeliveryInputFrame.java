package main.presentation.logisticsui.deliverymanui.inputframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import main.bussinesslogic.util.Time;
import main.presentation.logisticsui.deliverymanui.listener.toollistener.DeliveryToolListener;

@SuppressWarnings("serial")
public class DeliveryInputFrame extends JFrame implements ActionListener{

        private DeliveryToolListener listener;
        
        private JButton confirm, cancle;
        
        private JTextArea number,rec;
        
        private JLabel numberLabel,recLabel;
        
        private JComboBox<String> year, month, day;
        
        public DeliveryInputFrame(DeliveryToolListener listener) {
                this.listener = listener;
                this.setName("收件信息输入");
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
                confirm.setLocation(250, 190);
                cancle.setLocation(330, 190);
                confirm.addActionListener(this);
                cancle.addActionListener(this);
                this.getContentPane().add(confirm);
                this.getContentPane().add(cancle);
                
                numberLabel = new JLabel("订单号");
                numberLabel.setSize(70,30);
                numberLabel.setLocation(15, 50);
                this.getContentPane().add(numberLabel);
                number = new JTextArea();
                number.setSize(260, 30);
                number.setLocation(110,50);
                this.getContentPane().add(number);
                
                recLabel = new JLabel("收件人");
                recLabel.setSize(70,30);
                recLabel.setLocation(15,90);
                this.getContentPane().add(recLabel);
                rec = new JTextArea();
                rec.setSize(260,30);
                rec.setLocation(110, 90);
                this.getContentPane().add(rec);
                
                year = new JComboBox<>();
                for (int i = 2000; i <= 2020; i++) {
                    year.addItem(i + "年");
                }
                year.setBounds(15, 130, 120, 30);
                this.getContentPane().add(year);
                
                month = new JComboBox<>();
                for (int i = 1; i <= 12; i++) {
                        String s = i  < 10 ? "0" : "";
                        month.addItem( s + i + "月");
                }
                month.setBounds(185, 130, 60, 30);
                this.getContentPane().add(month);
                
                day = new JComboBox<>();
                for (int i = 1; i <= 31; i++) {
                        String s = i  < 10 ? "0" : "";
                        day.addItem(s + i + "日");
                }
                day.setBounds(295, 130, 60, 30);
                this.getContentPane().add(day);
                
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
                if(e.getSource() == confirm){
                        String recp = rec.getText();
                        String id = number.getText();
                        Time time = new Time(((String)year.getSelectedItem()).substring(0,4) + "-" 
                        + ((String)month.getSelectedItem()).substring(0,2) + "-" 
                                        + ((String)day.getSelectedItem()).substring(0, 2));
                        boolean result = listener.getInput(recp, id, time);
                        if(result)
                                this.setVisible(false);
                        else {
                                
                        }
                }else if(e.getSource() == cancle){
                        this.setVisible(false);
                }
        }

}

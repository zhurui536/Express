package presentation.logisticsui.deliverymanui.inputframe;

import presentation.WarningDialog;
import presentation.logisticsui.InputChecker;
import presentation.logisticsui.deliverymanui.listener.toollistener.DeliveryToolListener;
import util.Time;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class DeliveryInputFrame extends JFrame implements ActionListener{

        private DeliveryToolListener listener;
        
        private JButton confirm, cancle;
        
        private JTextArea number,rec;
        
        private JLabel numberLabel,recLabel;
        
        private JLabel errOutPutLabel;
        
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
                
                errOutPutLabel = new JLabel();
                errOutPutLabel.setBounds(30, 190, 150, 30);
                errOutPutLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
                errOutPutLabel.setForeground(Color.RED);
                this.add(errOutPutLabel);
                
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
                if(e.getSource() == confirm){
                        String recp = rec.getText();
                        String id = number.getText();
                        if(!InputChecker.isNum(id)){
                                errOutPutLabel.setText("订单号必须是数字！");
                                return;
                        }
                        Time time = new Time();
                        boolean result = listener.getInput(recp, id, time);
                        if(result){
                                new WarningDialog(this, "收件信息已记录");
                                this.setVisible(false);
                        }
                        else {
                                new WarningDialog(this, "订单号不存在");
                        }
                }else if(e.getSource() == cancle){
                        this.setVisible(false);
                }
        }

}

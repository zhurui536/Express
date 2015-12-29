package presentation.logisticsui.deliverymanui.inputframe;

import presentation.WarningDialog;
import presentation.logisticsui.InputChecker;
import presentation.logisticsui.deliverymanui.listener.toollistener.BillQueryToolListener;
import presentation.mainui.InputFrame;
import presentation.mainui.component.ToolButton;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class BillQueryInputFrame extends InputFrame implements ActionListener{
        
        private JButton confirm, cancle;
        
        private JTextArea number;
        
        private JLabel title;
        
        private BillQueryToolListener listener;
        
        private JLabel errOutPutLabel;
        
        public BillQueryInputFrame(BillQueryToolListener listener) {
                this.listener = listener;
                this.setName("快递单号输入");
                this.setLayout(null);
                this.setSize(430, 275);
                this.setLocation(400, 250);
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
                
                title = new JLabel("输入单号:");
                title.setSize(70,30);
                title.setLocation(15,90);
                this.getContentPane().add(title);
                
                number = new JTextArea();
                number.setSize(260,30);
                number.setLocation(110,90);
                this.getContentPane().add(number);
                
                errOutPutLabel = new JLabel();
                errOutPutLabel.setBounds(30, 190, 150, 30);
                errOutPutLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
                errOutPutLabel.setForeground(Color.RED);
                this.add(errOutPutLabel);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                if(e.getSource() == confirm){
                        String ID = this.number.getText();
                        if(ID == null)
                                return;
                        if( !InputChecker.isNum(ID)){
                                errOutPutLabel.setText("订单号必须是数字！");
                                return;
                        }
                        boolean result = listener.getInput(ID);
                        if(result){
                                this.setVisible(false);
                        }
                        else{
                                this.setVisible(false);
                                new WarningDialog(null, "无该订单");
                        }
                }else if(e.getSource() == cancle){
                        this.setVisible(false);
                }
                
        }

}

package presentation.logisticsui.deliverymanui.inputframe;

import presentation.logisticsui.deliverymanui.listener.toollistener.BillQueryToolListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class BillQueryInputFrame extends JFrame implements ActionListener{
        
        private JButton confirm, cancle;
        
        private JTextArea number;
        
        private JLabel title;
        
        private BillQueryToolListener listener;
        
        public BillQueryInputFrame(BillQueryToolListener listener) {
                this.listener = listener;
                this.setName("快递单号输入");
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
                
                title = new JLabel("输入单号:");
                title.setSize(70,30);
                title.setLocation(15,90);
                this.getContentPane().add(title);
                
                number = new JTextArea();
                number.setSize(260,30);
                number.setLocation(110,90);
                this.getContentPane().add(number);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                if(e.getSource() == confirm){
                        String ID = this.number.getText();
                        if(ID == null)
                                return;
                        boolean result = listener.getInput(ID);
                        if(result){
                                this.setVisible(false);
                        }
                        else{
                                //TODO
                        }
                }else if(e.getSource() == cancle){
                        this.setVisible(false);
                }
                
        }

}

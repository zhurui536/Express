package main.presentation.logisticsui.deliverymanui.inputframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.sun.org.apache.xml.internal.security.Init;

import main.presentation.logisticsui.deliverymanui.listener.toollistener.BillQueryToolListener;
import main.presentation.logisticsui.deliverymanui.listener.toollistener.ReceivingToolListener;

@SuppressWarnings("serial")
public class ReceivingInputFrame extends JFrame implements ActionListener{
        
        private ReceivingToolListener listener;
        
        private JButton confirm, cancle;
        
        private JTextArea number;
        
        private JLabel numberLabel;
        
        private JPanel panelForGoods;
        
        private JPanel panelForSender;
        
        private JPanel panelForRec;
        
        public ReceivingInputFrame(ReceivingToolListener listener) {
                this.listener = listener;
                this.setName("快递单号输入");
                this.setLayout(null);
                this.setSize(580, 550);
                this.setLocation(350, 200);
                init();
        }
        
        private void init() {
                numberLabel = new JLabel("订单号：");
                numberLabel.setSize(50,35);
                numberLabel.setLocation(15,15);
                this.add(numberLabel);
                
                number = new JTextArea();
                number.setLocation(65,15);
                number.setSize(100,15);
                this.add(number);
        }
        
        @Override
        public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                
        }

}

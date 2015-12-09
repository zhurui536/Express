package main.presentation.logisticsui.deliverymanui.inputframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import main.presentation.logisticsui.deliverymanui.listener.toollistener.DeliveryToolListener;

@SuppressWarnings("serial")
public class DeliveryInputFrame extends JFrame implements ActionListener{

        private DeliveryToolListener listener;
        
        private JButton confirm, cancle;
        
        private JTextArea number,id;
        
        private JLabel numberLabel,idLabel;
        
        private JComboBox<Integer> year, month, day;
        
        public DeliveryInputFrame(DeliveryToolListener listener) {
                this.listener = listener;
                this.setName("收件信息输入");
                this.setLayout(null);
                this.setSize(430, 275);
                this.setLocation(400, 250);
                init();
        }
        
        private void init() {}
        
        @Override
        public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                
        }

}

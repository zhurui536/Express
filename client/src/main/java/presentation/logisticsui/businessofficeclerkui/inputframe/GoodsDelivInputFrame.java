package presentation.logisticsui.businessofficeclerkui.inputframe;

import presentation.logisticsui.InputChecker;
import presentation.logisticsui.businessofficeclerkui.listerner.toollistener.GoodsDelivToolListener;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class GoodsDelivInputFrame extends JFrame implements ActionListener{

        private GoodsDelivToolListener listener;

        private JButton confirm, cancle;
        
        private JLabel label;
        
        private JTextArea textArea;
        
        private JLabel errOutPutLabel;
        
        public GoodsDelivInputFrame(
                        GoodsDelivToolListener goodsDelivToolListener) {
                this.listener = goodsDelivToolListener;
                this.setName("快递员ID输入");
                this.setLayout(null);
                this.setSize(460, 240);
                this.setLocation(350, 150);
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
                
                label = new JLabel("输入ID:");
                label.setSize(70, 30);
                label.setLocation(15, 90);
                this.getContentPane().add(label);
                
                textArea = new JTextArea();
                textArea.setSize(260,30);
                textArea.setLocation(110, 90);
                this.getContentPane().add(textArea);
                
                errOutPutLabel = new JLabel();
                errOutPutLabel.setBounds(30, 190, 190, 30);
                errOutPutLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
                errOutPutLabel.setForeground(Color.RED);
                this.add(errOutPutLabel);
                
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                if(e.getSource() == confirm){
                        String ID = textArea.getText();
                        if(!InputChecker.isNum(ID)){
                                errOutPutLabel.setText("快递员ID必须是数字！");
                                return;
                        }
                        boolean result = listener.getInput(ID);
                        if(result){
                                this.setVisible(false);
                        }
                }else if(e.getSource() == cancle){
                        this.setVisible(false);
                }
        }

}

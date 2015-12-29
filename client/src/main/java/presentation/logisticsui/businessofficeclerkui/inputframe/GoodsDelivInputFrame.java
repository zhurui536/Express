package presentation.logisticsui.businessofficeclerkui.inputframe;

import presentation.logisticsui.InputChecker;
import presentation.logisticsui.businessofficeclerkui.listerner.toollistener.GoodsDelivToolListener;
import presentation.mainui.InputFrame;
import presentation.mainui.component.ToolButton;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class GoodsDelivInputFrame extends InputFrame implements ActionListener{

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
                confirm = new ToolButton(250, 190,"确定");
                cancle = new ToolButton(330, 190,"取消");
                confirm.setSize(60, 25);
                cancle.setSize(60, 25);
                confirm.addActionListener(this);
                cancle.addActionListener(this);
                this.getContentPane().add(confirm, 0);
                this.getContentPane().add(cancle, 0);
                
                label = new JLabel("输入ID:");
                label.setSize(70, 30);
                label.setLocation(15, 90);
                this.getContentPane().add(label, 0);
                
                textArea = new JTextArea();
                textArea.setSize(260,30);
                textArea.setLocation(110, 90);
                this.getContentPane().add(textArea, 0);
                
                errOutPutLabel = new JLabel();
                errOutPutLabel.setBounds(30, 190, 190, 30);
                errOutPutLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
                errOutPutLabel.setForeground(Color.RED);
                this.add(errOutPutLabel, 0);
                
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

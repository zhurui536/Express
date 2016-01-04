package presentation.logisticsui.businessofficeclerkui.inputframe;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import presentation.logisticsui.businessofficeclerkui.listerner.toollistener.GoodsRecToolListener;
import presentation.mainui.InputFrame;
import presentation.mainui.component.ToolButton;
import util.GoodsState;
import util.PublicMessage;
import util.Time;
import vo.logisticvo.ArrivalBillVO;


@SuppressWarnings("serial")
public class GoodsRecInputFrame extends InputFrame implements ActionListener{

        private GoodsRecToolListener listener;
        
        private final String[] namesString = {"单据编号","出发地","货物状态"};
        
        private final String[] citys = {"南京","北京","上海","广州"};
        
        private final String[] institutions = {"营业厅","中转中心"};
        
        private final String[] goodsStates = {"损坏","完整","丢失"};
        
        private JButton confirm, cancle;
        
        private JLabel[] jLabels;
        
        private JTextArea jTextAreas;
        
        private JComboBox<String> city, institution, goodsState;
        
        private JLabel errOutputLabel;
        
        public GoodsRecInputFrame(GoodsRecToolListener listener) {
                this.listener = listener;
                this.setName("接受货物信息输入");
                this.setLayout(null);
                this.setSize(430, 275);
                this.setLocation(400, 250);
                init();
        }

        private void init() {
                confirm = new ToolButton(250, 220,"确定");
                cancle = new ToolButton(330, 220,"取消");
                confirm.setSize(60, 25);
                cancle.setSize(60, 25);
                confirm.addActionListener(this);
                cancle.addActionListener(this);
                this.getContentPane().add(confirm, 0);
                this.getContentPane().add(cancle, 0);
                
                
                jTextAreas = new JTextArea();
                jTextAreas.setSize(255,30);
                jTextAreas.setLocation(115, 50);
                this.getContentPane().add(jTextAreas, 0);
                
                jLabels = new JLabel[3];
                for(int i=0;i<3;i++){
                        jLabels[i] = new JLabel(namesString[i]);
                        jLabels[i].setSize(75, 30);
                        jLabels[i].setLocation(15, 50+40*i);
                        this.getContentPane().add(jLabels[i], 0);
                }
                
                city = new JComboBox<String>(citys);
                city.setBounds(115, 90, 100, 30);
                this.getContentPane().add(city, 0);
                
                institution = new JComboBox<String>(institutions);
                institution.setBounds(250, 90, 100, 30);
                this.getContentPane().add(institution, 0);
                
                goodsState = new JComboBox<String>(goodsStates);
                goodsState.setBounds(115, 130, 100, 30);
                this.getContentPane().add(goodsState, 0);
                
                errOutputLabel = new JLabel();
                errOutputLabel.setBounds(30, 190, 190, 30);
                errOutputLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
                errOutputLabel.setForeground(Color.RED);
                this.getContentPane().add(errOutputLabel, 0);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                if(e.getSource() == confirm){
                        ArrivalBillVO arrivalBillVO = new ArrivalBillVO();
                        arrivalBillVO.date = new Time();
//                        if(!InputChecker.isIdNum(jTextAreas.getText())){
//                                errOutputLabel.setText("中转单编号必须是数字！");
//                                return;
//                        }
                        arrivalBillVO.transferBillNum = jTextAreas.getText();
                        arrivalBillVO.departurePlace = (String)city.getSelectedItem() + (String)institution.getSelectedItem();
                        arrivalBillVO.goodsState = GoodsState.stringToGoodsState((String)goodsState.getSelectedItem());
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

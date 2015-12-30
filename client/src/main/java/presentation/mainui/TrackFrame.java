package presentation.mainui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import util.FrameUtil;
import util.MyJTable;
import util.Time;
import vo.GoodsVO;
import vo.logisticvo.SendBillVO;

@SuppressWarnings("serial")
public class TrackFrame extends JFrame {
        
        private SendBillVO sendBillVO;
        
        private MyJTable jTable;
        
        private JButton confirm;
        
        public static void main(String[] args) {
                ArrayList<String> track = new ArrayList<>();
                track.add(new Time().toString() + " 南京 中转中心 已接收" );
                track.add(new Time().toString() + " 北京 中转中心 已接收" );
                GoodsVO goodsVO = new GoodsVO();
                goodsVO.track = track;
                SendBillVO sendBillVO = new SendBillVO();
                sendBillVO.goodsVO = goodsVO;
                TrackFrame trackFrame = new TrackFrame(sendBillVO);
                trackFrame.setVisible(true);
        }
        
        public TrackFrame(SendBillVO sendBillVO) {
                this.sendBillVO = sendBillVO;
                this.setLayout(null);
                this.setSize(500,350);
                this.setUndecorated(true);
                init();
                FrameUtil.setFrameCenter(this);
        }

        private void init() {
                Object[][] object = new Object[sendBillVO.goodsVO.track.size()][1];
                String[] strings = {"货物轨迹"};
                for (int i = 0; i < object.length; i++) {
                        object[i][0] = sendBillVO.goodsVO.track.get(i);
                }
                jTable = new MyJTable(object, strings);
                Font font = new Font(Font.DIALOG, Font.BOLD, 20);
                jTable.setFont(font);
                jTable.setWidth(new int[]{500});
                
                JScrollPane scroller = new JScrollPane(jTable);
        		scroller.setBounds(0, 0, 500, 300);
        		
        		this.getContentPane().add(scroller);
                
                confirm = new JButton("我知道了");
                confirm.setBounds(360, 300, 120, 30);
                confirm.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                close();
                        }
                });
                this.getContentPane().add(confirm);
        }
        private void close() {
                this.setVisible(false);
        }

        
}

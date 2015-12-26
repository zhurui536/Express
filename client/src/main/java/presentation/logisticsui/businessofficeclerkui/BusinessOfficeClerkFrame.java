package presentation.logisticsui.businessofficeclerkui;

import bussinesslogic.infobl.InfoBLController;
import bussinesslogic.logisticsbl.LogisticsBLController;
import bussinesslogicservice.infoblservice.InfoBLSerivce;
import bussinesslogicservice.logisticsblservice.LogisticsBLService;
import connection.ClientInitException;
import connection.ClientRMIHelper;
import presentation.logisticsui.businessofficeclerkui.listerner.MenuListener;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class BusinessOfficeClerkFrame extends JFrame {

        private LogisticsBLService logisticsBLService;
        private InfoBLSerivce infoBLSerivce;

        // 窗口中的成员组件，窗口分为菜单、工具和数据三个部分
        private JPanel menu;
        private MenuListener menulistener;
        private JButton[] buttons;
        private JPanel tool;

        // 由于data区可能有很多记录，所以添加了滑轮。
        private JScrollPane scroll;
        private JPanel data;

        private static final String[] NAMES = { "货物装车", "货物接受","分派货物","收款", "司机信息维护" ,"车辆信息维护"};

        private static final int NUMBER_OF_BUTTONS = 6;

        public static void main(String[] args) throws ClientInitException {
//                ClientRMIHelper.init();
                ClientRMIHelper clientRMIHelper = new ClientRMIHelper();
                clientRMIHelper.init();
                BusinessOfficeClerkFrame frame = new BusinessOfficeClerkFrame();
                frame.setVisible(true);
        }

        public BusinessOfficeClerkFrame() {
            this.logisticsBLService = new LogisticsBLController();
            this.infoBLSerivce = new InfoBLController();
                this.setLayout(null);
                this.setSize(1000, 630);
                this.setDefaultCloseOperation(EXIT_ON_CLOSE);

                menulistener = new MenuListener(this);
                this.paintframe();
        }

        private void paintframe() {
                paintmenu();
                painttool();
        }

        private void painttool() {
                tool = new JPanel();
                tool.setLayout(null);
                tool.setSize(1000, 100);
                tool.setLocation(0, 0);
                tool.setBackground(Color.BLUE);

                this.getContentPane().add(tool);
        }

        private void paintmenu() {
                menu = new JPanel();
                menu.setBackground(Color.RED);
                menu.setLayout(null);
                menu.setSize(140, 500);
                menu.setLocation(0, 100);

                buttons = new JButton[NUMBER_OF_BUTTONS];
                for (int i = 0; i < NUMBER_OF_BUTTONS; i++) {
                        buttons[i] = createButton(i);
                        buttons[i].setLocation(10, 35 + 75 * i);
                        menu.add(buttons[i], 0);
                }

                this.getContentPane().add(menu);
        }

        private JButton createButton(int i) {
                JButton button = new JButton(NAMES[i]);
                button.setSize(120, 35);
                button.addActionListener(menulistener);
                return button;
        }

        public JButton getButton(int i) {
                return buttons[i];
        }

        public void paintdata(JPanel data) {
                if (scroll != null) {
                        this.remove(scroll);
                        scroll = null;
                }

                this.data = data;

                if (data != null) {
                        scroll = new JScrollPane(this.data);
                        scroll.setBounds(150, 100, 830, 500);
                        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                        data.setPreferredSize(new Dimension(data.getWidth(),
                                        data.getHeight()));
                        this.add(scroll);
                }

                this.validate();
                this.repaint();
        }

        public void replaceTool(JPanel newtool) {
                if (this.tool != null) {
                        this.remove(tool);
                }

                this.tool = newtool;

                if (newtool != null) {
                        tool.setBackground(Color.BLUE);
                        this.getContentPane().add(tool);
                }
                this.validate();
                this.repaint();
        }

        public void close() {
                if (tool == null) {
                        this.setVisible(false);
                }
        }

        public LogisticsBLService getLogisticsBLService() {
                return logisticsBLService;
        }

        public InfoBLSerivce getInfoBLSerivce() {
                return infoBLSerivce;
        }

}

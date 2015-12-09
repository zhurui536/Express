package main.presentation.logisticsui.businessofficeclerkui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import main.bussinesslogicservice.infoblservice.InfoBLSerivce;
import main.bussinesslogicservice.logisticsblservice.LogisticsBLService;
import main.presentation.logisticsui.businessofficeclerkui.listerner.MenuListener;

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

        private static final String[] NAMES = { "货物装车", "货物接受","分派货物","收款", "信息维护" };

        private static final int NUMBER_OF_BUTTONS = 5;

//        public static void main(String[] args) {
//                BusinessOfficeClerkFrame frame = new BusinessOfficeClerkFrame();
//                frame.setVisible(true);
//        }

        public BusinessOfficeClerkFrame(LogisticsBLService logisticsBLService) {
            this.logisticsBLService = logisticsBLService;
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
                        buttons[i].setLocation(15, 35 + 75 * i);
                        menu.add(buttons[i], 0);
                }

                this.getContentPane().add(menu);
        }

        private JButton createButton(int i) {
                JButton button = new JButton(NAMES[i]);
                button.setSize(100, 35);
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
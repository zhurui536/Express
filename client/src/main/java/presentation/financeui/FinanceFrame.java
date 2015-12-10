package presentation.financeui;

import bussinesslogic.financebl.FinanceController;
import bussinesslogicservice.financeblservice.FinanceBLService;
import presentation.financeui.listener.MenuListener;
import presentation.financeui.tool.ToolPanel;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Away
 * 2015/12/8
 */

@SuppressWarnings("serial")
public class FinanceFrame extends JFrame {

    private final String[] names = {"账户管理", "付款", "收款", "报表查看", "期初建账" };

    private JPanel menu;
    private MenuListener menuListener;
    private JButton[] buttons;
    private FinanceBLService financeController;
    private Map<String, JButton> buttonMap;
    private ToolPanel tool;
    private JScrollPane scroll;
    private JPanel data;

    public FinanceFrame() {
        this.financeController = new FinanceController();
        menuListener = new MenuListener(this);
        initComponents();
    }

//    public static void main(String[] args) {
//        try {
//            ClientRMIHelper.init();
//        } catch (ClientInitException e) {
//            e.printStackTrace();
//        }
//        FinanceFrame financeFrame = new FinanceFrame(new FinanceController());
//    }

    private void initComponents() {
        buttonMap = new HashMap<>();
        initFrame();
        initMenu();
        initTool();
    }

    private void initFrame() {
        this.setName("财务人员主界面");
        this.setLayout(null);
        this.setSize(1000, 630);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initMenu() {
        menu = new JPanel();
        menu.setBackground(Color.RED);
        menu.setLayout(null);
        menu.setSize(140, 500);
        menu.setLocation(0, 100);
        createButton();
        this.getContentPane().add(menu);
    }

    private void initTool() {
        tool = new ToolPanel();
        tool.setLayout(null);
        tool.setSize(1000, 100);
        tool.setLocation(0, 0);
        tool.setBackground(Color.BLUE);

        this.getContentPane().add(tool);
    }

    //由于data区可能会经常更换，所以设置了这个方法
    public void paintData(JPanel data) {
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
            data.setPreferredSize(new Dimension(data.getWidth(), data.getHeight()));
            this.add(scroll);
        }

        this.validate();
        this.repaint();
    }

    private void createButton() {
        buttons = new JButton[5];
        for (int i = 0; i < 5; i++) {
            buttons[i] = new JButton(names[i]);
            buttons[i].setBounds(15, 35 + 75 * i, 100, 35);
            buttons[i].addActionListener(menuListener);
            menu.add(buttons[i], 0);
            buttonMap.put(names[i], buttons[i]);
        }
    }

    //由于menu发生点击事件时需要更换Tool区，故设置了这个方法
    public void replaceTool(ToolPanel newTool) {
        if (this.tool != null) {
            this.remove(tool);
        }

        this.tool = newTool;

        if (newTool != null) {
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

    public JButton getButton(String name) {
        return buttonMap.get(name);
    }

    public FinanceBLService getFinanceController() {
        return this.financeController;
    }

    public ToolPanel getToolPanel() {
        return tool;
    }
}


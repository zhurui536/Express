package presentation.financeui.tool;

import presentation.financeui.FinanceFrame;
import presentation.financeui.listener.ToolListener;
import presentation.financeui.listener.toollistener.InitToolListener;

import javax.swing.*;

/**
 * Created by Away
 * 2015/12/9
 */

@SuppressWarnings("serial")
public class InitTool extends ToolPanel {

    private JButton create;
    private JButton inquire;
    private JButton back;

    public InitTool(FinanceFrame ui) {
        init();
        initComponents(ui);
    }

    private void init() {
        create = new JButton("新建账本");
        inquire = new JButton("查询");
        back = new JButton("返回");
    }

    private void initComponents(FinanceFrame ui) {
        this.setLayout(null);
        this.setSize(1000, 100);
        this.setLocation(0, 0);

        ToolListener toolListener = new InitToolListener(ui);

        create.setBounds(100, 25, 150, 50);
        create.addActionListener(toolListener);
        buttonMap.put("create", create);
        this.add(create);

        inquire.setBounds(400, 25, 150, 50);
        inquire.addActionListener(toolListener);
        buttonMap.put("inquire", inquire);
        this.add(inquire);

        back.setBounds(815, 25, 100, 50);
        back.addActionListener(toolListener);
        buttonMap.put("back", back);
        this.add(back);
    }
}

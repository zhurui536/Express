package presentation.financeui.tool;

import presentation.financeui.FinanceFrame;
import presentation.financeui.listener.ToolListener;
import presentation.financeui.listener.toollistener.BankAccountManagementToolListener;

import javax.swing.*;

/**
 * Created by Away
 * 2015/12/8
 */

@SuppressWarnings("serial")
public class BankAccountManagementTool extends ToolPanel {

    private JButton add;
    private JButton del;
    private JButton find;
    private JButton update;
    private JButton back;

    public BankAccountManagementTool(FinanceFrame ui) {
        super();
        init();
        initComponents(ui);
    }

    private void init() {
        add = new JButton("新增账户");
        del = new JButton("删除账户");
        find = new JButton("查询账户");
        update = new JButton("修改账户");
        back = new JButton("返回");
    }

    private void initComponents(FinanceFrame ui) {
        this.setLayout(null);
        this.setSize(1000, 100);
        this.setLocation(0, 0);

        ToolListener toolListener = new BankAccountManagementToolListener(ui);

        add.setBounds(83, 25, 100, 50);
        add.addActionListener(toolListener);
        buttonMap.put("add", add);
        this.add(add);

        del.setBounds(266, 25, 100, 50);
        del.addActionListener(toolListener);
        buttonMap.put("del", del);
        this.add(del);

        find.setBounds(449, 25, 100, 50);
        find.addActionListener(toolListener);
        buttonMap.put("find", find);
        this.add(find);

        update.setBounds(632, 25, 100, 50);
        update.addActionListener(toolListener);
        buttonMap.put("update", update);
        this.add(update);

        back.setBounds(815, 25, 100, 50);
        back.addActionListener(toolListener);
        buttonMap.put("back", back);
        this.add(back);
    }
}

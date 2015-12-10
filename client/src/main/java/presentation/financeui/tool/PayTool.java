package presentation.financeui.tool;

import presentation.financeui.FinanceFrame;
import presentation.financeui.listener.ToolListener;
import presentation.financeui.listener.toollistener.PayToolListener;

import javax.swing.*;

/**
 * Created by Away
 * 2015/12/9
 */

public class PayTool extends ToolPanel {

    private JButton create;
    private JButton back;

    public PayTool(FinanceFrame ui) {
        init();
        initComponents(ui);
    }

    private void init() {
        create = new JButton("生成付款单");
        back = new JButton("返回");
    }

    private void initComponents(FinanceFrame ui) {
        this.setLayout(null);
        this.setSize(1000, 100);
        this.setLocation(0, 0);

        ToolListener toolListener = new PayToolListener(ui);

        create.setBounds(100, 25, 100, 50);
        create.addActionListener(toolListener);
        buttonMap.put("create", create);
        this.add(create);

        back.setBounds(815, 25, 100, 50);
        back.addActionListener(toolListener);
        buttonMap.put("back", back);
        this.add(back);
    }
}

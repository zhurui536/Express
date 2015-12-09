package main.presentation.financeui.tool;

import main.presentation.financeui.FinanceFrame;
import main.presentation.financeui.listener.ToolListener;
import main.presentation.financeui.listener.toollistener.ReceiptToolListener;

import javax.swing.*;

/**
 * Created by Away
 * 2015/12/9
 */

public class ReceiptTool extends ToolPanel {

    private JButton show;
    private JButton back;

    public ReceiptTool(FinanceFrame ui) {
        init();
        initComponents(ui);
    }

    private void init() {
        show = new JButton("显示收款单");
        back = new JButton("返回");
    }

    private void initComponents(FinanceFrame ui) {
        this.setLayout(null);
        this.setSize(1000, 100);
        this.setLocation(0, 0);

        ToolListener toolListener = new ReceiptToolListener(ui);

        show.setBounds(100, 25, 100, 50);
        show.addActionListener(toolListener);
        buttonMap.put("show", show);
        this.add(show);

        back.setBounds(815, 25, 100, 50);
        back.addActionListener(toolListener);
        buttonMap.put("back", back);
        this.add(back);
    }
}

package main.presentation.financeui.tool;

import main.presentation.financeui.FinanceFrame;
import main.presentation.financeui.listener.ToolListener;
import main.presentation.financeui.listener.toollistener.ReportToolListener;

import javax.swing.*;

/**
 * Created by Away
 * 2015/12/9
 */

@SuppressWarnings("serial")
public class ReportTool extends ToolPanel {

    private JButton profit;
    private JButton statement;
    private JButton back;

    public ReportTool(FinanceFrame ui) {
        init();
        initComponents(ui);
    }

    private void init() {
        profit = new JButton("显示成本收益表");
        statement = new JButton("显示经营情况表");
        back = new JButton("返回");
    }

    private void initComponents(FinanceFrame ui) {
        this.setLayout(null);
        this.setSize(1000, 100);
        this.setLocation(0, 0);

        ToolListener toolListener = new ReportToolListener(ui);

        profit.setBounds(100, 25, 150, 50);
        profit.addActionListener(toolListener);
        buttonMap.put("profit", profit);
        this.add(profit);

        statement.setBounds(400, 25, 150, 50);
        statement.addActionListener(toolListener);
        buttonMap.put("statement", statement);
        this.add(statement);
        
        back.setBounds(815, 25, 100, 50);
        back.addActionListener(toolListener);
        buttonMap.put("back", back);
        this.add(back);
    }
    
}

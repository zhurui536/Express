package presentation.financeui.tool;

import presentation.financeui.FinanceFrame;
import presentation.financeui.listener.ToolListener;
import presentation.financeui.listener.toollistener.ReportToolListener;

import javax.swing.*;

/**
 * Created by Away
 * 2015/12/9
 */

@SuppressWarnings("serial")
public class ReportTool extends ToolPanel {

    private JButton profit;
    private JButton profitExport;
    private JButton statement;
    private JButton statementExport;
    private JButton back;

    public ReportTool(FinanceFrame ui) {
        init();
        initComponents(ui);
    }

    private void init() {
        profit = new JButton("显示成本收益表");
        profitExport = new JButton("导出成本收益表");
        statement = new JButton("显示经营情况表");
        statementExport = new JButton("导出经营情况表");
        back = new JButton("返回");
    }

    private void initComponents(FinanceFrame ui) {
        this.setLayout(null);
        this.setSize(1000, 100);
        this.setLocation(0, 0);

        ToolListener toolListener = new ReportToolListener(ui);

        profit.setBounds(50, 25, 150, 50);
        profit.addActionListener(toolListener);
        buttonMap.put("profit", profit);
        this.add(profit);
        
        profitExport.setBounds(250, 25, 150, 50);
        profitExport.addActionListener(toolListener);
        buttonMap.put("profitExport", profitExport);
        this.add(profitExport);
        
        statement.setBounds(450, 25, 150, 50);
        statement.addActionListener(toolListener);
        buttonMap.put("statement", statement);
        this.add(statement);
        
        statementExport.setBounds(650, 25, 150, 50);
        statementExport.addActionListener(toolListener);
        buttonMap.put("statementExport", statementExport);
        this.add(statementExport);
        
        back.setBounds(850, 25, 100, 50);
        back.addActionListener(toolListener);
        buttonMap.put("back", back);
        this.add(back);
    }
    
}

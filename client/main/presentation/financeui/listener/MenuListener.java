package main.presentation.financeui.listener;

import main.bussinesslogic.financebl.FinanceController;
import main.presentation.financeui.FinanceFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Away
 * 2015/12/8
 */

public class MenuListener implements ActionListener {

    private FinanceFrame financeFrame;

    private FinanceController financeController;

    public MenuListener(FinanceFrame financeFrame) {
        this.financeFrame = financeFrame;
        this.financeController = new FinanceController();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object button = e.getSource();

        if (button == financeFrame.getButton("账户管理")) {
            System.out.println("0");
        } else if (button == financeFrame.getButton("付款")) {
            System.out.println("1");
        } else if (button == financeFrame.getButton("收款")) {
            System.out.println("2");
        } else if (button == financeFrame.getButton("报表查看")) {
            System.out.println("3");
        } else if (button == financeFrame.getButton("期初建账")) {
            System.out.println("4");
        } else {
            System.out.println("0");
        }

    }


}

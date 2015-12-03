package test.uiTester;

import test.MyPanel;

import javax.swing.*;

/**
 * Created by Away
 * 2015/12/3
 */

public class UITester {

    private JFrame jFrame;

    private JPanel jPanel;

    private JTable jTable;

    private JButton jButton;

    public UITester() {
        init();
    }

    private void init() {
        jFrame = new JFrame("test");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setBounds(350, 150, 1200, 800);

        jPanel = new MyPanel();
        jPanel.setLayout(null);

        initJTable();

        jButton = new JButton("test");
        jButton.setBounds(500, 600, 100, 40);

        jPanel.add(jTable);
        jPanel.add(jButton);
        jFrame.setContentPane(jPanel);
    }

    private void initJTable() {
        jTable = new JTable();
        jTable.setBounds(100, 50, 1000, 500);
    }

    public void show() {
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        UITester uiTester = new UITester();
        uiTester.show();
    }
}





















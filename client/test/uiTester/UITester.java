package test.uiTester;

import test.MyPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(jTable.getValueAt(3, 4));
                Object value = jTable.getValueAt(3, 4);
                if (value instanceof String) {
                    jTable.setValueAt("", 3, 4);
                }
            }
        });

        jPanel.add(jTable);
        jPanel.add(jButton);
        jFrame.setContentPane(jPanel);
    }

    private void initJTable() {
        jTable = new JTable(5, 10);
        jTable.setRowHeight(100);
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





















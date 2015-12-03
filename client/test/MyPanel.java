package test;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Away
 * 2015/12/3
 */

@SuppressWarnings("ALL")
public class MyPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = new ImageIcon("C:/Users/jone/Pictures/壁纸/1.jpg").getImage();
        g.drawImage(image, 0, 0, null);
    }
}























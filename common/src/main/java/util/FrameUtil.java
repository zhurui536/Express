package util;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * 将窗体设为中间
 * Created by Away
 * 2015/12/24
 */

public class FrameUtil {

    public static void setFrameCenter(Container frame) {

//        FrameConfig frameConfig = GameConfig.getFrameConfig();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screen = toolkit.getScreenSize();
        int x = screen.width - frame.getWidth() >> 1;
//        int y = (screen.height - frame.getHeight() >> 1) - frameConfig.getWindowUp();
        int y = (screen.height - frame.getHeight() >> 1) - 32;
        frame.setLocation(x, y);
    }
}

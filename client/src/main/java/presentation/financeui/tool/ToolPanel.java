package presentation.financeui.tool;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Away
 * 2015/12/8
 */

@SuppressWarnings("serial")
public class ToolPanel extends JPanel {

    protected Map<String, JButton> buttonMap;

    public ToolPanel() {
        this.buttonMap = new HashMap<>();
    }

    public JButton getButton(String name) {
        return buttonMap.get(name);
    }
}

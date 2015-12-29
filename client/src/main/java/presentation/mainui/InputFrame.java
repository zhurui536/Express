package presentation.mainui;

import javax.swing.JDialog;
import javax.swing.JLabel;

import util.UIImage;

@SuppressWarnings("serial")
public class InputFrame extends JDialog{
        
        private JLabel bg;
        
        public InputFrame() {
                bg = new JLabel();
                bg.setIcon(UIImage.BACKGROUND_INPUTFRAME);
                this.getContentPane().add(bg,-1);
        }
        
        public InputFrame(ExpressFrame ui){
                this();
        }
        
        @Override
        public void setSize(int width, int height) {
                super.setSize(width, height);
               this.setBackgroundSize(width, height);
        }
        
        public void setBackgroundSize(int width, int height) {
                bg.setSize(width, height);
        }
        
}

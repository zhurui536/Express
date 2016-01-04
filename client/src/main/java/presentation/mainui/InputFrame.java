package presentation.mainui;

import java.awt.Image;

import javax.swing.ImageIcon;
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
        	ImageIcon icon = (ImageIcon) bg.getIcon();
        	icon.setImage(icon.getImage().getScaledInstance(width,height,Image.SCALE_DEFAULT));
        	bg.setIcon(icon);
            bg.setSize(width, height);
        }
        
}

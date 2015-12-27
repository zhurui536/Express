package util;

import java.awt.Image;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class UIImage {
	protected static ImageIcon createImageIcon(String path){
		ImageIcon icon= new ImageIcon(path);
		return icon;
	}
	
	protected static Image createImage(String path){
		try {
			Image img = ImageIO.read(new FileInputStream(path));
			return img;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static final ImageIcon BACKGROUND_FRAME = createImageIcon("graphic/FrameBackground.png");
	public static final ImageIcon BACKGROUND_MENU = createImageIcon("graphic/MenuBackground.png");
	public static final ImageIcon BACKGROUND_TOOL = createImageIcon("graphic/ToolBackground.png");
	public static final ImageIcon BUTTON_CLICKED = createImageIcon("graphic/ButtonClicked.png");
	public static final ImageIcon BUTTON_OVER = createImageIcon("graphic/ButtonOver.png");
	public static final ImageIcon TOOLBUTTON_OVER = createImageIcon("graphic/ToolButtonOver.png");
	public static final ImageIcon TOOLBUTTON = createImageIcon("graphic/ToolButtonBackground.png");
}

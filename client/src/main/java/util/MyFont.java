package util;

import java.awt.Font;

public class MyFont {
	
	private MyFont() {}
	
	private static Font FONT1 = new Font("微软雅黑", Font.PLAIN, 16);
	
	public static Font getFont1() {
		return FONT1;
	}
}

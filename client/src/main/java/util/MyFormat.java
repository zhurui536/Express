package util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MyFormat {
	
	private static DecimalFormat format1 = new DecimalFormat("#.00");
	
	public static String setFormat(BigDecimal num) {
		return format1.format(num.doubleValue());
	}
}

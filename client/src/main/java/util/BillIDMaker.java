package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BillIDMaker {
	
	public static String getID(BillType type) {
		return PublicMessage.institutionID + df.format(new Date()) + BillType.BillTypeToTypeNum(type) + df2.format(new Date());
	}
	
	/**
	 * 生成汽运编号
	 * @return
	 */
	public static String getTransferNum() {
		return PublicMessage.institutionID + df.format(new Date()) + BillType.BillTypeToTypeNum(BillType.LOADING) + df2.format(new Date()).substring(0, 4);
	}
	private static SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
	private static SimpleDateFormat df2 = new SimpleDateFormat("HHmmss");
}

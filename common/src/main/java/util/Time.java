package util;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Time implements Comparable<Time>, Serializable {

	private static final long serialVersionUID = 1L;

	private static final SimpleDateFormat dateFormaterForDisplay = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	private static final SimpleDateFormat dateFormaterForCompare = new SimpleDateFormat(
			"yyyy-MM-dd");

	private static final SimpleDateFormat dateFormaterForBillID = new SimpleDateFormat(
			"yyyyMMddHHmmss");

	private Date date;

	public Time() {
		date = new Date();
	}

	public Time(String time) {
		try {
			date = dateFormaterForCompare.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
			date = new Date();
		}
	}

	public long sub(Time time) {
		long diff = date.getTime() - time.date.getTime();
		return diff / (1000 * 60 * 60 * 24);
	}

	public Time add(int year) {
		Time time = new Time();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, year);
		time.date = calendar.getTime();
		return time;
	}

	public String toID() {
		return dateFormaterForBillID.format(date);
	}

	@Override
	public String toString() {
		return dateFormaterForDisplay.format(date);
	}

	public String toDayString() {
		return dateFormaterForCompare.format(date);
	}

	public boolean equalsWithDay(Time o) {
		return dateFormaterForCompare.format(o.date)
				.equals(dateFormaterForCompare.format(date));
	}

	public void addDay() {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 1);// 把日期往后增加一天.整数往后推,负数往前移动
		date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
	}

	@Override
	public int compareTo(Time o) {
		if (date.before(o.date)) {
			return -1;
		} else if (o.date.before(date)) {
			return 1;
		}
		return 0;
	}

	// public static void main(String[] args) {
	// Time time1 = new Time("2015-12-7");
	//// Time time2 = new Time();
	// System.out.println(time1);
	//// System.out.println(time2);
	//
	// System.out.println(time1.add(5));
	// System.out.println(time1.toID());
	// }

}

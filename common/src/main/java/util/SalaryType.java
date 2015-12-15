package util;

public enum SalaryType {
	MONTHLY, ONCE, DEDUCT;
	
	public static String salaryToString(SalaryType type){
		String result = null;
		
		switch(type){
		case MONTHLY: 
			result = "月薪";
			break;
		case ONCE:
			result = "按次计薪";
			break;
		case DEDUCT:
			result = "提成";
			break;
		}
		return result;
	}
}

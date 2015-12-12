package util;

//表示用户的权限，主要用于UserPO

public enum AuthorityLevel {
	HIGH, MEDIUM, LOW;
	
	public static String authorityToString(AuthorityLevel lv){
		String result = null;
		switch(lv){
		case HIGH: 
			result = "高";
		case MEDIUM:
			result = "中";
		case LOW:
			result = "低";
		}
		
		return result;
	}
}

package util;

import java.util.HashMap;

public enum Job {
	MANAGER, COURIER, SALESOFOFFICE, SALESOFCENTRE, DRIVER, STOCKMAN, FINANCEMAN, ADMIN;
	private static HashMap<String, Job> nameMap;
	
	static {
	        nameMap = new HashMap<>();
	        nameMap.put("经理", MANAGER);
	        nameMap.put("快递员", COURIER);
	        nameMap.put("营业厅业务员", SALESOFOFFICE);
	        nameMap.put("中转中心业务员", SALESOFCENTRE);
	        nameMap.put("司机", DRIVER);
	        nameMap.put("库存管理员", STOCKMAN);
	        nameMap.put("财务人员", FINANCEMAN);
	        nameMap.put("系统管理员", ADMIN);
	}
	
	public static String jobToString(Job job) {
                for (String key : nameMap.keySet()) {
                        if (nameMap.get(key) == job)
                                return key;
                }
                return null;
	}
};



package util;

public enum Job {
	MANAGER, COURIER, SALESOFOFFICE, SALESOFCENTRE, DRIVER, STOCKMAN, FINANCEMAN;
	
	public static String jobToString(Job job) {
	    String result = null;
	    switch (job) {
	            case MANAGER:
	                    result = "经理";
	                    break;
	            case COURIER:
	                    result = "快递员";
	                    break;
	            case SALESOFOFFICE:
	                    result = "营业厅业务员";
	            case SALESOFCENTRE:
	            		result = "中转中心业务员";
	            case DRIVER:
	            	result = "司机";
	            case STOCKMAN:
	            	result = "库存管理员";
	            case FINANCEMAN:
	            	result = "财务人员";
	    }
	    return result;
	}
};



package util;

public enum Job {
	MANAGER, COURIER, SALESOFOFFICE, SALESOFCENTRE, DRIVER, STOCKMAN, FINANCEMAN, ADMIN;
	
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
	                    break;
	            case SALESOFCENTRE:
	            		result = "中转中心业务员";
	            		break;
	            case DRIVER:
	            	result = "司机";
	            	break;
	            case STOCKMAN:
	            	result = "库存管理员";
	            	break;
	            case FINANCEMAN:
	            	result = "财务人员";
	            	break;
	            case ADMIN:
	            	result = "系统管理员";
	            	break;
	    }
	    return result;
	}
};



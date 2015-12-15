package util;

public enum Trans {
	//飞机、火车。货船
	PLANE, TRAIN, TRUCK;
	
	public static String transToString(Trans trans){
		String result = null;
		
		switch(trans){
		case PLANE: 
			result = "飞机";
			break;
		case TRAIN:
			result = "火车";
			break;
		case TRUCK:
			result = "货车";
			break;
		}
		return result;
	}
}
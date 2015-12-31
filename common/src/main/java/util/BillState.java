package util;

public enum BillState {
	DRAFT, SUBMTTED, APPROVED;
	
	public static String billStateToString(BillState state){
		if(state == DRAFT)
			return "草稿";
		if(state == SUBMTTED)
			return "已提交";
		if(state == APPROVED)
			return "审批通过";
		
		return null;
	}
}

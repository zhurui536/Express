package util;

public enum BillType {
        SEND,//寄件单
        LOADING,//装车单
        ARRIVAL,//到达单
        DELIVERY,//派件单
        INSTORE,//入库单
        TRANSIT,//中转单
        OUTSTORE,//出库单
        PAYMENT,//付款单
        RECEIPT;//收款单
        
        public static int BillTypeToTypeNum(BillType type){
        	if(type == SEND)
        		return 0;
        	if(type == LOADING)
        		return 1;
        	if(type == ARRIVAL)
        		return 2;
        	if(type == DELIVERY)
        		return 3;
        	if(type == INSTORE)
        		return 4;
        	if(type == TRANSIT)
        		return 5;
        	if(type == OUTSTORE)
        		return 6;
        	if(type == PAYMENT)
        		return 7;
        	if(type == RECEIPT)
        		return 8;
        	
        	return 9;
        }
}

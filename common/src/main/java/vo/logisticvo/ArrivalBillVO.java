package vo.logisticvo;


import po.logisticpo.ArrivalBillPO;
import util.GoodsState;

public class ArrivalBillVO {
        // 录入机构
        public String institution;
        // 到达日期
        public String date;
        // 中转单编号
        public String transferBillNum;
        // 出发地
        public String departurePlace;
        // 货物到达状态（损坏、完整、丢失）
        public GoodsState goodsState;
        
        public ArrivalBillVO(ArrivalBillPO po){
        	this.institution = po.getInstitution();
        	this.date = po.getDate();
        	this.transferBillNum = po.getTransferBillNum();
        	this.departurePlace = po.getDeparturePlace();
        	this.goodsState = po.getGoodsState();
        }

        public ArrivalBillVO(String institution, String date,
                        String transferBillNum, String departurePlace,
                        GoodsState goodsState) {
                super();
                this.institution = institution;
                this.date = date;
                this.transferBillNum = transferBillNum;
                this.departurePlace = departurePlace;
                this.goodsState = goodsState;
        }
        
        public ArrivalBillVO() {
                // TODO Auto-generated constructor stub
        }
        
}

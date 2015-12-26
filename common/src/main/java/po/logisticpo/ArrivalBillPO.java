package po.logisticpo;

import po.BillPO;
import util.BillType;
import util.GoodsState;
import vo.logisticvo.ArrivalBillVO;

/**
 * 到达单
 * 
 * @author zhuding
 */
public class ArrivalBillPO extends BillPO {

        private static final long serialVersionUID = -5607159218880704105L;

        // 录入机构
        private String institution;
        // 到达日期
        private String date;
        // 中转单编号
        private String transferBillNum;
        // 出发地
        private String departurePlace;
        // 货物到达状态（损坏、完整、丢失）
        private GoodsState goodsState;

        public ArrivalBillPO(String institution, String date,
                        String transferBillNum, String departurePlace,
                        GoodsState goodsState) {
                super(BillType.ARRIVAL, institution);
                this.institution = institution;
                this.date = date;
                this.transferBillNum = transferBillNum;
                this.departurePlace = departurePlace;
                this.goodsState = goodsState;
        }

        public ArrivalBillPO(ArrivalBillVO arrivalBillVO) {
                this(arrivalBillVO.institution, arrivalBillVO.date,
                                arrivalBillVO.transferBillNum,
                                arrivalBillVO.departurePlace,
                                arrivalBillVO.goodsState);
        }

        public String getInstitution() {
                return institution;
        }

        public void setInstitution(String institution) {
                this.institution = institution;
        }

        public String getDate() {
                return date;
        }

        public void setDate(String date) {
                this.date = date;
        }

        public String getTransferBillNum() {
                return transferBillNum;
        }

        public void setTransferBillNum(String transferBillNum) {
                this.transferBillNum = transferBillNum;
        }

        public String getDeparturePlace() {
                return departurePlace;
        }

        public void setDeparturePlace(String departurePlace) {
                this.departurePlace = departurePlace;
        }

        public GoodsState getGoodsState() {
                return goodsState;
        }

        public void setGoodsState(GoodsState goodsState) {
                this.goodsState = goodsState;
        }

}

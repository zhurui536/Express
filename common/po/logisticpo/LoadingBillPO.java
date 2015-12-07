package po.logisticpo;

import main.bussinesslogic.util.BillType;
import main.bussinesslogic.util.Time;
import main.vo.logisticvo.LoadingBillVO;
import po.BillPO;

import java.util.ArrayList;

/**
 * 装车单
 * 
 * @author zhuding
 */
public class LoadingBillPO extends BillPO {

        private static final long serialVersionUID = -5615496575819450063L;

        // 录入机构
        private String institution;
        // 装车日期
        private Time date;
        // 汽运编号（中转中心编号+日期+0000000七位数字 或 营业厅编号 + 日期 + 五位数字）
        private String transferNum;
        // 到达地
        private String arrivalPlace;
        // 车辆代号
        private String numOfTruck;
        // 监装员
        private String supervisor;
        // 押运员
        private String supercargo;
        // 本次装箱所有订单条形码号
        private ArrayList<String> ids;
        // 运费
        private double charge;

        public LoadingBillPO(String institution, Time date, String transferNum,
                        String arrivalPlace, String numOfTruck,
                        String supervisor, String supercargo,
                        ArrayList<String> ids) {
                super(institution, BillType.LOADING, supervisor);
                this.institution = institution;
                this.date = date;
                this.transferNum = transferNum;
                this.arrivalPlace = arrivalPlace;
                this.numOfTruck = numOfTruck;
                this.supervisor = supervisor;
                this.supercargo = supercargo;
                this.ids = ids;
        }

        public static LoadingBillPO voToPo(LoadingBillVO loadingBillVO) {
                LoadingBillPO loadingBillPO = new LoadingBillPO(
                                loadingBillVO.institution, loadingBillVO.date,
                                loadingBillVO.transferNum,
                                loadingBillVO.arrivalPlace,
                                loadingBillVO.numOfTruck,
                                loadingBillVO.supervisor,
                                loadingBillVO.supercargo, loadingBillVO.ids);
                loadingBillPO.setCharge(loadingBillVO.charge);
                return loadingBillPO;
        }

        public String getInstitution() {
                return institution;
        }

        public void setInstitution(String institution) {
                this.institution = institution;
        }

        public void setDate(Time date) {
                this.date = date;
        }

        public Time getDate() {
                return date;
        }

        public String getTransferNum() {
                return transferNum;
        }

        public void setTransferNum(String transferNum) {
                this.transferNum = transferNum;
        }

        public String getArrivalPlace() {
                return arrivalPlace;
        }

        public void setArrivalPlace(String arrivalPlace) {
                this.arrivalPlace = arrivalPlace;
        }

        public String getNumOfTruck() {
                return numOfTruck;
        }

        public void setNumOfTruck(String numOfTruck) {
                this.numOfTruck = numOfTruck;
        }

        public String getSupervisor() {
                return supervisor;
        }

        public void setSupervisor(String supervisor) {
                this.supervisor = supervisor;
        }

        public String getSupercargo() {
                return supercargo;
        }

        public void setSupercargo(String supercargo) {
                this.supercargo = supercargo;
        }

        public ArrayList<String> getIds() {
                return ids;
        }

        public void setIds(ArrayList<String> ids) {
                this.ids = ids;
        }

        public double getCharge() {
                return charge;
        }

        public void setCharge(double charge) {
                this.charge = charge;
        }

}

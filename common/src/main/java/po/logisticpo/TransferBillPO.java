package po.logisticpo;

import po.BillPO;
import util.BillType;
import util.Time;
import util.Trans;

import java.util.ArrayList;

public class TransferBillPO extends BillPO {

        private static final long serialVersionUID = -4178073770417521604L;

        // 装车日期
        private Time time;
        // 本中转中心中转单编号（中转中心编号+日期+0000000七位数字）
        private String transferBillNum;
        // 货运方式
        private Trans trans;
        // 航班号/车次号
        private String number;
        // 车厢号/货柜号
        private String numOfLoc;
        // 押运员
        private String supercargo;
        // 出发地
        private String depaturePlace;
        // 到达地
        private String arrivalPlace;
        // 监装员
        private String supervisor;
        // 本次装箱所有托运单号
        private ArrayList<String> ids;
        // 运费
        private double charge;

        public TransferBillPO(String transferBillNum, Trans trans,
                        String depaturePlace, String arrivalPlace,
                        ArrayList<String> ids) {
                super(BillType.TRANSIT, transferBillNum);
                this.time = new Time();
                this.transferBillNum = super.getBillID();
                this.trans = trans;
                this.depaturePlace = depaturePlace;
                this.arrivalPlace = arrivalPlace;
                this.ids = ids;
        }

        public Time getTime() {
                return time;
        }

        public void setTime(Time time) {
                this.time = time;
        }

        public String getTransferBillNum() {
                return transferBillNum;
        }

        public void setTransferBillNum(String transferBillNum) {
                this.transferBillNum = transferBillNum;
        }

        public Trans getTrans() {
                return trans;
        }

        public void setTrans(Trans trans) {
                this.trans = trans;
        }

        public String getNumber() {
                return number;
        }

        public void setNumber(String number) {
                this.number = number;
        }

        public String getNumOfLoc() {
                return numOfLoc;
        }

        public void setNumOfLoc(String numOfLoc) {
                this.numOfLoc = numOfLoc;
        }

        public String getSupercargo() {
                return supercargo;
        }

        public void setSupercargo(String supercargo) {
                this.supercargo = supercargo;
        }

        public String getDepaturePlace() {
                return depaturePlace;
        }

        public void setDepaturePlace(String depaturePlace) {
                this.depaturePlace = depaturePlace;
        }

        public String getArrivalPlace() {
                return arrivalPlace;
        }

        public void setArrivalPlace(String arrivalPlace) {
                this.arrivalPlace = arrivalPlace;
        }

        public String getSupervisor() {
                return supervisor;
        }

        public void setSupervisor(String supervisor) {
                this.supervisor = supervisor;
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

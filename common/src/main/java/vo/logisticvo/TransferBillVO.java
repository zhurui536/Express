package vo.logisticvo;

import java.util.ArrayList;

import util.Time;
import util.Trans;


public class TransferBillVO {
        // 装车日期
        public Time time;
        // 本中转中心中转单编号（中转中心编号+日期+0000000七位数字）
        public String transferBillNum;
        // 货运方式
        public Trans trans;
        // 航班号/车次号
        public String number;
        // 车厢号/货柜号
        public String numOfLoc;
        // 押运员
        public String supercargo;
        // 出发地
        public String depaturePlace;
        // 到达地
        public String arrivalPlace;
        // 监装员
        public String supervisor;
        // 本次装箱所有托运单号
        public ArrayList<String> ids;
        // 运费
        public double charge;
}

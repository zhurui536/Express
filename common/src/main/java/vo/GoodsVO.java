package vo;

import util.City;
import util.ExpressType;
import util.GoodsDeliveryState;
import util.PackageType;
import util.Time;

import java.util.ArrayList;

/**
 * Created by Away
 * 2015/10/26
 */

public class GoodsVO {
        //货物名称
        public String name;
        //货物出发地
        public City departurePlace;
        //货物目的地
        public City destination;
        //货物轨迹
        public ArrayList<City> track;
        //货物重量
        public double weight;
        //货物体积
        public double volume;
        //货物包装类型
        public PackageType packageType;
        //快递类型
        public ExpressType expressType;
        //货物运转状态
        public GoodsDeliveryState goodsDeliveryState;
        //货物实际收件人
        public String recipient;
        //货物的快递单号
        public String id;
        //货物的出发时间
        public Time startTime;
        // 货物的接受时间
        public Time receiveTime;
        //金额
        public double price;

}

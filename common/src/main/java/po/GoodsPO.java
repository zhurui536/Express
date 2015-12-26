package po;

import util.City;
import util.ExpressType;
import util.GoodsDeliveryState;
import util.PackageType;
import util.Time;
import vo.GoodsVO;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Away 2015/10/26
 */

public class GoodsPO implements Serializable {

	private static final long serialVersionUID = 6366213867793889079L;
	// 货物名称
        private String name;
        // 货物出发地
        private City departurePlace;
        // 货物目的地
        private City destination;
        // 货物轨迹
        private ArrayList<City> track;
        // 货物重量
        private double weight;
        // 货物体积
        private double volume;
        // 货物包装类型
        private PackageType packageType;
        // 快递类型
        private ExpressType expressType;
        // 货物运转状态
        private GoodsDeliveryState goodsDeliveryState;
        // 货物实际收件人
        private String recipient;
        // 货物的快递单号
        private String id;
        //货物的出发时间
        private Time startTime;
        // 货物的接受时间
        private Time receiveTime;
        // 金额
        private double price;

        public GoodsPO(String id, String name, City departurePlace,
                        City destination, double weight, double volume,
                        PackageType packageType, ExpressType expressType) {

                this.id = id;
                this.name = name;
                this.departurePlace = departurePlace;
                this.destination = destination;
                this.weight = weight;
                this.volume = volume;
                this.packageType = packageType;
                this.expressType = expressType;
                this.track = new ArrayList<>();
                this.track.add(departurePlace);
                this.startTime = new Time();
                this.goodsDeliveryState = GoodsDeliveryState.TRANSPORT;
        }

        public GoodsVO poToVo() {
                GoodsVO goodsVO = new GoodsVO();

                goodsVO.departurePlace = this.departurePlace;
                goodsVO.destination = this.destination;
                goodsVO.expressType = this.expressType;
                goodsVO.goodsDeliveryState = this.goodsDeliveryState;
                goodsVO.id = this.id;
                goodsVO.name = this.name;
                goodsVO.packageType = this.packageType;
                goodsVO.recipient = this.recipient;
                goodsVO.startTime = this.startTime;
                goodsVO.receiveTime = this.receiveTime;
                goodsVO.track = new ArrayList<>();
                track.addAll(this.track);
                goodsVO.volume = this.volume;
                goodsVO.weight = this.weight;
                goodsVO.price = this.price;
                return goodsVO;
        }
        
        public static GoodsPO voToPo(GoodsVO goodsVO) {
                GoodsPO goodsPO =  new GoodsPO(goodsVO.id, goodsVO.name,
                                goodsVO.departurePlace, goodsVO.destination,
                                goodsVO.weight, goodsVO.volume,
                                goodsVO.packageType, goodsVO.expressType);
                goodsPO.setStartTime(goodsVO.startTime);
                goodsPO.setPrice(goodsVO.price);
                return goodsPO;
        }

        public double getPrice() {
                return price;
        }

        public void setPrice(double price) {
                this.price = price;
        }

        public String getRecipient() {
                return recipient;
        }

        public Time getStartTime() {
                return startTime;
        }

        public void setStartTime(Time startTime) {
                this.startTime = startTime;
        }

        public Time getReceiveTime() {
                return receiveTime;
        }

        public void setReceiveTime(Time receiveTime) {
                this.receiveTime = receiveTime;
        }

        public static long getSerialversionuid() {
                return serialVersionUID;
        }

        public void setTrack(ArrayList<City> track) {
                this.track = track;
        }

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public void setRecipient(String recipient) {
                this.recipient = recipient;
        }

        public void addLocation(City location) {
                this.track.add(location);
        }

        public GoodsDeliveryState getGoodsDeliveryState() {
                return goodsDeliveryState;
        }

        public void setGoodsDeliveryState(GoodsDeliveryState goodsDeliveryState) {
                this.goodsDeliveryState = goodsDeliveryState;
        }

        public City getDestination() {
                return destination;
        }

        public void setDestination(City destination) {
                this.destination = destination;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }


        public double getWeight() {
                return weight;
        }

        public void setWeight(double weight) {
                this.weight = weight;
        }

        public double getVolume() {
                return volume;
        }

        public void setVolume(double volume) {
                this.volume = volume;
        }

        public PackageType getPackageType() {
                return packageType;
        }

        public void setPackageType(PackageType packageType) {
                this.packageType = packageType;
        }

        public ExpressType getExpressType() {
                return expressType;
        }

        public void setExpressType(ExpressType expressType) {
                this.expressType = expressType;
        }

        public City getDeparturePlace() {
                return departurePlace;
        }

        public void setDeparturePlace(City departurePlace) {
                this.departurePlace = departurePlace;
        }

        public ArrayList<City> getTrack() {
                return track;
        }

}

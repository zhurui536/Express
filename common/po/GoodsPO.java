package po;

import java.io.Serializable;
import java.util.ArrayList;

import main.bussinesslogic.util.ExpressType;
import main.bussinesslogic.util.GoodsDeliveryState;
import main.bussinesslogic.util.PackageType;
import main.vo.GoodsVO;

/**
 * Created by Away 2015/10/26
 */

@SuppressWarnings("serial")
public class GoodsPO implements Serializable {

        // 货物名称
        private String name;
        // 货物出发地
        private String departurePlace;
        // 货物目的地
        private String destination;
        // 货物轨迹
        private ArrayList<String> track;
        // 货物重量
        private int weight;
        // 货物体积
        private int volume;
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
        private long startTime;
        // 货物的接受时间
        private long receiveTime;
        // 金额
        private double price;

        public GoodsPO(String id, String name, String departurePlace,
                        String destination, int weight, int volume,
                        PackageType packageType, ExpressType expressType, long startTime) {

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
                this.startTime = startTime;
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
                return new GoodsPO(goodsVO.id, goodsVO.name,
                                goodsVO.departurePlace, goodsVO.destination,
                                goodsVO.weight, goodsVO.volume,
                                goodsVO.packageType, goodsVO.expressType,goodsVO.startTime);
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

        public long getStartTime() {
                return startTime;
        }

        public void setStartTime(long startTime) {
                this.startTime = startTime;
        }

        public long getReceiveTime() {
                return receiveTime;
        }

        public void setReceiveTime(long receiveTime) {
                this.receiveTime = receiveTime;
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

        public void addLocation(String location) {
                this.track.add(location);
        }

        public GoodsDeliveryState getGoodsDeliveryState() {
                return goodsDeliveryState;
        }

        public void setGoodsDeliveryState(GoodsDeliveryState goodsDeliveryState) {
                this.goodsDeliveryState = goodsDeliveryState;
        }

        public String getDestination() {
                return destination;
        }

        public void setDestination(String destination) {
                this.destination = destination;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public int getWeight() {
                return weight;
        }

        public void setWeight(int weight) {
                this.weight = weight;
        }

        public int getVolume() {
                return volume;
        }

        public void setVolume(int volume) {
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

        public String getDeparturePlace() {
                return departurePlace;
        }

        public void setDeparturePlace(String departurePlace) {
                this.departurePlace = departurePlace;
        }

        public ArrayList<String> getTrack() {
                return track;
        }

}

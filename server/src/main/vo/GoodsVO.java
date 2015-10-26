package main.vo;

import java.util.ArrayList;

import main.bussinesslogic.util.ExpressType;
import main.bussinesslogic.util.GoodsDeliveryState;
import main.bussinesslogic.util.PackageType;

/**
 * Created by Away
 * 2015/10/26
 */

public class GoodsVO {
        //货物名称
        private String name;
        //货物出发地
        private String departurePlace;
        //货物目的地
        private String destination;
        //货物轨迹
        private ArrayList<String> track;
        //货物重量
        private int weight;
        //货物体积
        private int volume;
        //货物包装类型
        private PackageType packageType;
        //快递类型
        private ExpressType expressType;
        //货物运转状态
        private GoodsDeliveryState goodsDeliveryState;
        //货物实际收件人
        private String recipient;
        //货物的快递单号
        private long id;
        
        public GoodsVO(long id, String name, String departurePlace,
                        String destination ,int weight,
                        int volume, PackageType packageType,
                        ExpressType expressType) {
                
                       this.id = id;
                       this.name = name;
                       this.departurePlace = departurePlace;
                       this.destination = destination;
                       this.weight = weight;
                       this.volume = volume;
                       this.packageType = packageType;
                       this.expressType = expressType;
                       this.track.add(departurePlace);
                       this.goodsDeliveryState = GoodsDeliveryState.TRANSPORT;
        }      
        
        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public void setRecipient(String recipient) {
                this.recipient = recipient;
        }

        public void addLocation(String location){
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
        
        
        
}

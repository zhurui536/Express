package main.bussinesslogic.util;

/**
 * @author zhuding
 *
 */
public enum GoodsDeliveryState {
        TRANSPORT,DELIVERY,DELIVERED;
        
        public static String typeToString(GoodsDeliveryState type) {
                String result = null;
                switch (type) {
                        case TRANSPORT:
                                result = "转运中";
                                break;
                        case DELIVERY:
                                result = "派件中";
                                break;
                        case DELIVERED:
                                result = "已送达";
                }
                return result;
        }
}

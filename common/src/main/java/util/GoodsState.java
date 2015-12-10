package util;

import java.util.HashMap;

/**
 * @author zhuding
 *
 */
public enum GoodsState {
        DAMAGED, COMPLETE, MISSING;

        private static HashMap<String, GoodsState> nameMap;
        static{
                nameMap = new HashMap<>();
                nameMap.put("损坏", DAMAGED);
                nameMap.put("完整", COMPLETE);
                nameMap.put("丢失", MISSING);
        }

        public static GoodsState stringToGoodsState(String string) {
                return nameMap.get(string);
        }
}
package util;

/**
 * 付款单付款条目
 * Created by Away
 * 2015/12/6
 */

public enum PayItem {
    RENT("租金"), FREIGHT("运费"), SALARY("工资"), REWARD("奖励");

    private String name;

    PayItem(String name) {
        this.name = name;
    }

    public static PayItem getItem(String name) {
        for (PayItem item : PayItem.values()) {
            if (item.name.equals(name)) {
                return item;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
}

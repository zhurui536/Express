package vo.storevo;

import java.util.List;

/**
 * Created by Away
 * 2015/12/8
 */

public class StoreVO {

    //将所有库存位置整合到一起成为一个仓库对象
    public List<StorePlaceVO> store;
    //区数
    public int areas;
    //排数
    public int rows;
    //架数
    public int shelfs;
    //位数
    public int places;

    public StoreVO(List<StorePlaceVO> store, int areas, int rows, int shelfs, int places) {
        this.store = store;
        this.areas = areas;
        this.rows = rows;
        this.shelfs = shelfs;
        this.places = places;
    }

    public StoreVO() {

    }
}

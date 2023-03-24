package space.pandaer.test;

import org.junit.jupiter.api.Test;
import space.pandaer.dao.HouseHoldDao;
import space.pandaer.dao.impl.HouseHoldDaoImpl;
import space.pandaer.entity.HouseHold;

import java.math.BigDecimal;
import java.util.List;

public class HouseHoldTest {
    private final HouseHoldDao houseHoldDao = new HouseHoldDaoImpl();

    @Test
    public void testAdd() {
        HouseHold houseHold = new HouseHold("中国简约家具", "中国", new BigDecimal("999.9"), 300, 20);
        boolean ans = houseHoldDao.addHouseHold(houseHold);
        System.out.println(ans);
    }

    @Test
    public void testUpdate() {
        HouseHold houseHold = new HouseHold(9, "俄罗斯简约家具", "中国", new BigDecimal("2300.9"), 300, 20);
        boolean ans = houseHoldDao.updateHouseHold(houseHold);
        System.out.println(ans);
    }

    @Test
    public void testQuery() {
        HouseHold houseHold = houseHoldDao.queryHouseHoldById(2);
        System.out.println(houseHold);
    }

    @Test
    public void testQueryAll() {
        List<HouseHold> houseHolds = houseHoldDao.queryHouseHolds();
        System.out.println(houseHolds);
    }

    @Test
    public void testDelete() {
        HouseHold houseHold = new HouseHold(2, "俄罗斯简约家具", "中国", new BigDecimal("2300.9"), 300, 20);
        boolean ans = houseHoldDao.deleteHouseHold(houseHold);
        System.out.println(ans);
    }

    @Test
    public void testQueryById() {
        HouseHold houseHold = houseHoldDao.queryHouseHoldById(9);
        System.out.println(houseHold);
    }

    @Test
    public void testQueryByPage() {
        List<HouseHold> houseHolds = houseHoldDao.queryByPage(5, 10);
        System.out.println(houseHolds.size());
        for (HouseHold houseHold : houseHolds) {
            System.out.println(houseHold);
        }
    }

    @Test
    public void testCount() {
        Long count = houseHoldDao.count();
        System.out.println(count);
    }

    @Test
    public void testCountByName() {
        Integer count = houseHoldDao.countByName("家");
        System.out.println(count);
    }

    @Test
    public void testPageWithName() {
        List<HouseHold> houseHolds = houseHoldDao.queryByPageWithName(1, 10, "北欧");
        System.out.println(houseHolds);
    }
}

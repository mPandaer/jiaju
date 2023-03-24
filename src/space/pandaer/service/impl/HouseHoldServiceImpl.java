package space.pandaer.service.impl;

import space.pandaer.dao.HouseHoldDao;
import space.pandaer.dao.impl.HouseHoldDaoImpl;
import space.pandaer.entity.HouseHold;
import space.pandaer.entity.Page;
import space.pandaer.service.HouseHoldService;

import java.util.List;

public class HouseHoldServiceImpl implements HouseHoldService {
    private final HouseHoldDao houseHoldDao = new HouseHoldDaoImpl();

    @Override
    public List<HouseHold> listHouseHold() {
        return houseHoldDao.queryHouseHolds();
    }

    @Override
    public boolean addHouseHold(HouseHold houseHold) {
        return houseHoldDao.addHouseHold(houseHold);
    }

    @Override
    public boolean updateHouseHold(HouseHold houseHold) {
        return houseHoldDao.updateHouseHold(houseHold);
    }

    @Override
    public boolean deleteHouseHold(HouseHold houseHold) {
        return houseHoldDao.deleteHouseHold(houseHold);
    }

    @Override
    public HouseHold getHouseHoldById(Integer id) {
        return houseHoldDao.queryHouseHoldById(id);
    }

    //产生分页数据
    @Override
    public Page<HouseHold> page(Integer pageNo, Integer pageSize) {
        List<HouseHold> houseHolds = houseHoldDao.queryByPage(pageNo, pageSize);
        Long sum = houseHoldDao.count();
        int pageCount = Math.toIntExact(sum / 10);
        pageCount = sum % 10 == 0  ? pageCount : pageCount + 1;
        Page<HouseHold> page = new Page<>(pageNo, pageSize, sum, pageCount, houseHolds);
        page.setUrl("customer?action=page");
        return page;
    }

    @Override
    public Page<HouseHold> pageWithName(String name, Integer pageNo, Integer pageSize) {
        List<HouseHold> houseHolds = houseHoldDao.queryByPageWithName(pageNo, pageSize, name);
        Integer sum = houseHoldDao.countByName(name);
        Integer total = sum % pageSize == 0 ? sum / pageSize : sum / pageSize + 1;
        Page<HouseHold> page = new Page<>(pageNo, pageSize, new Long(sum), total, houseHolds);
        page.setUrl("customer?action=pageWithName&name=" + name);
        return page;
    }
}

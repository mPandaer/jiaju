package space.pandaer.dao;


import space.pandaer.entity.HouseHold;
import space.pandaer.entity.Member;

import java.util.List;

public interface HouseHoldDao {

    HouseHold queryHouseHoldById(Integer id);

    boolean updateHouseHold(HouseHold houseHold);

    boolean deleteHouseHold(HouseHold houseHold);

    boolean addHouseHold(HouseHold houseHold);

    List<HouseHold> queryHouseHolds();

    List<HouseHold> queryByPage(Integer pageNo,Integer pageSize);

    Long count();

    //根据家具名记录个数
    Integer countByName(String name);

    //根据家具名分页
    List<HouseHold> queryByPageWithName(Integer pageNo,Integer pageSize,String name);
}

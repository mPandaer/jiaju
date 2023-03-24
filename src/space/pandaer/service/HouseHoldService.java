package space.pandaer.service;


import space.pandaer.entity.HouseHold;
import space.pandaer.entity.Page;

import java.util.List;

//家居信息的服务层
public interface HouseHoldService {

    //获取全部家居信息
    List<HouseHold> listHouseHold();

    //增加家具信息
    boolean addHouseHold(HouseHold houseHold);

    //修改家具信息
    boolean updateHouseHold(HouseHold houseHold);

    //删除家具信息
    boolean deleteHouseHold(HouseHold houseHold);

    //通过Id获取家具信息
    HouseHold getHouseHoldById(Integer id);

    //分页数据
    Page<HouseHold> page(Integer pageNo, Integer pageSize);

    //通过家具名分页
    Page<HouseHold> pageWithName(String name,Integer pageNo, Integer pageSize);

}

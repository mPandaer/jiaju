package space.pandaer.dao.impl;

import space.pandaer.dao.BasicDAO;
import space.pandaer.dao.HouseHoldDao;
import space.pandaer.entity.HouseHold;

import java.util.List;

public class HouseHoldDaoImpl extends BasicDAO<HouseHold> implements HouseHoldDao {
    //通过ID查询家居信息
    @Override
    public HouseHold queryHouseHoldById(Integer id) {
        String sql = "select `id`,`name`,`manu`,`price`,`sales`,`stock`,`img_path` imgPath \n" +
                "from household\n" +
                "where  `id` = ?";
        return querySingle(sql, HouseHold.class, id);
    }


    //修改家具信息
    @Override
    public boolean updateHouseHold(HouseHold houseHold) {
        String sql = "update household\n" +
                "    set `name` = ?,`manu`=?,`price`=?,`sales`=?,`stock`=?,`img_path` = ?\n" +
                "where `id` = ?";
        return update(sql, houseHold.getName(), houseHold.getManu(),
                houseHold.getPrice(), houseHold.getSales(), houseHold.getStock(),
                houseHold.getImgPath(), houseHold.getId()) != -1;
    }

    @Override
    public boolean deleteHouseHold(HouseHold houseHold) {
        String sql = "delete from household where id = ?";
        return update(sql, houseHold.getId()) != -1;
    }

    @Override
    public boolean addHouseHold(HouseHold houseHold) {
        String sql = "insert into household (`name`,`manu`,`price`,`sales`,`stock`,`img_path`)\n" +
                "values\n" +
                "    (?,?,?,?,?,?);";
        return update(sql, houseHold.getName(), houseHold.getManu(),
                houseHold.getPrice(), houseHold.getSales(), houseHold.getStock(), houseHold.getImgPath()) != -1;
    }

    @Override
    public List<HouseHold> queryHouseHolds() {
        String sql = "select `id`,`name`,`manu`,`price`,`sales`,`stock`,`img_path` imgPath\n" +
                "from household";
        return queryMulti(sql, HouseHold.class);
    }

    @Override
    public List<HouseHold> queryByPage(Integer pageNo, Integer pageSize) {
        String sql = "select `id`,`name`,`manu`,`price`,`sales`,`stock`,`img_path` imgPath\n" +
                "from household\n" +
                "limit ?,?";
        return queryMulti(sql,HouseHold.class,pageNo*pageSize,pageSize);
    }

    @Override
    public Long count() {
        String sql = "select count(`id`) from household";
        return (Long) queryScalar(sql);
    }

    @Override
    public Integer countByName(String name) {
        String sql = "select count(name) from household where name like ?";
        return ((Number)queryScalar(sql,"%"+name+"%")).intValue();
    }

    @Override
    public List<HouseHold> queryByPageWithName(Integer pageNo, Integer pageSize, String name) {
        String sql = "select `id`,`name`,`manu`,`price`,`sales`,`stock`,`img_path` imgPath\n" +
                "from household\n" +
                "where name like ?\n" +
                "limit ?,?";
        return queryMulti(sql,HouseHold.class,"%"+name+"%",pageNo*pageSize,pageSize);
    }
}

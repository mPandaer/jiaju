package space.pandaer.dao.impl;

import space.pandaer.dao.BasicDAO;
import space.pandaer.dao.OrderDao;
import space.pandaer.entity.Order;

import java.util.List;

public class OrderDaoImpl extends BasicDAO<Order> implements OrderDao {
    /**
     * 将订单简略信息保存到数据库
     * @param order
     */
    @Override
    public boolean save(Order order) {
        String sql = "insert into `order`\n" +
                "    (`id`,`order_num`,`date`,`price`,`state`,`user_id`)\n" +
                "values\n" +
                "    (?,?,?,?,?,?);";
        return update(sql,order.getId(),order.getOrderNum(),order.getDate(),order.getPrice(),order.getState(),order.getUserId()) > 0;
    }

    @Override
    public List<Order> showOrdersByUserId(Integer userId) {
        String sql = "select `id`,`order_num` orderNum,`date`,`price`,`state`, `user_id` userId\n" +
                "from `order`\n" +
                "where user_id = ?;";
        return queryMulti(sql, Order.class,userId);
    }
}

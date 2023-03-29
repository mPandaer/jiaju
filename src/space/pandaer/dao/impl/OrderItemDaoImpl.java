package space.pandaer.dao.impl;

import space.pandaer.dao.BasicDAO;
import space.pandaer.dao.OrderItemDao;
import space.pandaer.entity.OrderItem;

import java.util.List;

public class OrderItemDaoImpl extends BasicDAO<OrderItem> implements OrderItemDao {
    @Override
    public boolean save(OrderItem item) {
        String sql = "insert into `order_detail`\n" +
                "    (`name`,`price`,`count`,`total_price`,`order_id`,`household_id`)\n" +
                "values\n" +
                "    (?,?,?,?,?,?);";
        return update(sql,item.getName(),item.getPrice(),item.getCount(),item.getTotalPrice(),
                item.getOrderId(),item.getHouseholdId()) > 0;
    }

    @Override
    public List<OrderItem> getOrderItemByOrderId(Integer orderId) {
        String sql = "select `id`,name,price,count,total_price totalPrice,order_id orderId,household_id householdId\n" +
                "from order_detail\n" +
                "where order_id = ?";

        return queryMulti(sql, OrderItem.class,orderId);
    }
}

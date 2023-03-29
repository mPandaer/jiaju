package space.pandaer.dao;

import space.pandaer.entity.OrderItem;

import java.util.List;

public interface OrderItemDao {

    boolean save(OrderItem item);

    List<OrderItem> getOrderItemByOrderId(Integer orderId);
}

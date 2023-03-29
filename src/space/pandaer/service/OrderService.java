package space.pandaer.service;

import space.pandaer.entity.Cart;
import space.pandaer.entity.Order;
import space.pandaer.entity.OrderInfo;
import space.pandaer.entity.OrderItem;

import java.util.List;

/**
 * 生成订单，以及保存到数据库中
 */
public interface OrderService {
    OrderInfo saveOrder(Cart cart, Integer userId);

    List<Order> showOrdersByUserId(Integer userId);
    List<OrderItem> showOrderItemsByOrderId(Integer orderId);
}

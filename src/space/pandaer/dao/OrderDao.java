package space.pandaer.dao;

import space.pandaer.entity.Order;

import java.util.List;

public interface OrderDao {
    boolean save(Order order);

    List<Order> showOrdersByUserId(Integer userId);
}

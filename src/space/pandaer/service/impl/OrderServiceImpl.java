package space.pandaer.service.impl;

import space.pandaer.dao.HouseHoldDao;
import space.pandaer.dao.OrderDao;
import space.pandaer.dao.OrderItemDao;
import space.pandaer.dao.impl.HouseHoldDaoImpl;
import space.pandaer.dao.impl.OrderDaoImpl;
import space.pandaer.dao.impl.OrderItemDaoImpl;
import space.pandaer.entity.*;
import space.pandaer.service.OrderService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderServiceImpl implements OrderService {
    private final OrderDao orderDao = new OrderDaoImpl();
    private final OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private final HouseHoldDao houseHoldDao = new HouseHoldDaoImpl();

    //保存订单
    @Override
    public OrderInfo saveOrder(Cart cart, Integer userId) {
        //生成Order整体信息
        String orderNum = UUID.randomUUID().toString();
            Order order = new Order(UUID.randomUUID().hashCode(), orderNum, LocalDate.now().toString(),
                cart.getTotalPrice(),0,userId);
        orderDao.save(order);
        //生成Order_detail详细信息
        for (Cart.CartItem cartItem : cart.getItems()) {
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),
                    cartItem.getPrice(),cartItem.getCount(),order.getId(),cartItem.getId());
            orderItemDao.save(orderItem);
            HouseHold houseHold = houseHoldDao.queryHouseHoldById(cartItem.getId());
            if (houseHold.getStock() < cartItem.getCount()) {
                return null;
            }
            houseHold.setSales(houseHold.getSales() + cartItem.getCount());
            houseHold.setStock(houseHold.getStock() - cartItem.getCount());
//            Integer i = 1/0;//todo(故意的错误)
            houseHoldDao.updateHouseHold(houseHold);
        }
        //todo(事务控制)
        //todo(错误处理)
        return new OrderInfo(cart.getTotalCount(),cart.getTotalPrice(),orderNum);
    }

    @Override
    public List<Order> showOrdersByUserId(Integer userId) {
        return orderDao.showOrdersByUserId(userId);
    }

    @Override
    public List<OrderItem> showOrderItemsByOrderId(Integer orderId) {
        return orderItemDao.getOrderItemByOrderId(orderId);
    }


}

package space.pandaer.test;

import org.jcp.xml.dsig.internal.dom.DOMSubTreeData;
import org.junit.jupiter.api.Test;
import space.pandaer.dao.OrderItemDao;
import space.pandaer.dao.impl.OrderItemDaoImpl;
import space.pandaer.entity.OrderItem;

import java.math.BigDecimal;
import java.util.List;

public class OrderItemTest {
    private final OrderItemDao dao = new OrderItemDaoImpl();

    @Test
    public void testOrderItem() {
        OrderItem orderItem = new OrderItem(null,"好看的家居",new BigDecimal("22.22"),
                2,6,11);
        boolean save = dao.save(orderItem);
        System.out.println(save);
    }

    @Test
    public void testGetOrderItemById() {
        List<OrderItem> orderItemByOrderId = dao.getOrderItemByOrderId(442170003);
        System.out.println(orderItemByOrderId);
    }
}

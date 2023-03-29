package space.pandaer.test;

import org.jcp.xml.dsig.internal.dom.DOMSubTreeData;
import org.junit.jupiter.api.Test;
import space.pandaer.dao.OrderDao;
import space.pandaer.dao.impl.OrderDaoImpl;
import space.pandaer.entity.Order;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class OrderDaoTest {
    private final OrderDao dao = new OrderDaoImpl();

    //测试添加订单信息
    @Test
    public void testSave() {
        Order order = new Order(null, UUID.randomUUID().toString(),
                LocalDate.now().toString(),new BigDecimal("11.22"),0,10);
        boolean ans = dao.save(order);
        System.out.println(ans);
    }

    @Test
    public void testId() {
        long i = UUID.randomUUID().hashCode();
        System.out.println(i);
    }

    @Test
    public void testShowById() {
        List<Order> orders = dao.showOrdersByUserId(7);
        System.out.println(orders);
    }
}

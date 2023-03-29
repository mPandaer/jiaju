package space.pandaer.web.servlet;

import space.pandaer.entity.*;
import space.pandaer.service.OrderService;
import space.pandaer.service.impl.OrderServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class OrderServlet extends BaseServlet {
    private final OrderService orderService = new OrderServiceImpl();
    //生成订单
    private void genOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取到Cart对象
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        Member member = (Member)session.getAttribute("member");
        if (cart == null || cart.getItems().size() == 0) {
            response.sendRedirect(request.getContextPath());
            return;
        }
        OrderInfo orderInfo = orderService.saveOrder(cart, member.getId());
        if (orderInfo == null) {
            response.sendRedirect(request.getContextPath());
        }else {
            session.setAttribute("orderInfo",orderInfo);
            response.sendRedirect(request.getContextPath() + "/order/checkout.jsp");
        }

    }

    //显示整体家居信息
    private void showOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute("member");
        List<Order> orders = orderService.showOrdersByUserId(member.getId());
        session.setAttribute("orders",orders);
        request.getRequestDispatcher("/order/order.jsp").forward(request,response);
    }


    //显示详细的家居信息
    private void showOrderItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        List<OrderItem> orderItemList = orderService.showOrderItemsByOrderId(Integer.parseInt(orderId));
        request.setAttribute("orderItems",orderItemList);
        request.getRequestDispatcher("/order/order_detail.jsp").forward(request,response);
    }
}

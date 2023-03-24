package space.pandaer.web.servlet;

import space.pandaer.entity.Cart;
import space.pandaer.entity.HouseHold;
import space.pandaer.service.HouseHoldService;
import space.pandaer.service.impl.HouseHoldServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.math.BigDecimal;

public class CartServlet extends BaseServlet {

    private final HouseHoldService houseHoldService = new HouseHoldServiceImpl();

    private void addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id == null || id.equals("")) {
            response.sendRedirect(request.getContextPath());
            return;
        }
        //有id
        HouseHold houseHold = houseHoldService.getHouseHoldById(Integer.parseInt(id));
        Cart.CartItem cartItem = new Cart.CartItem(houseHold.getId(), houseHold.getName(),
                houseHold.getImgPath(), houseHold.getPrice(), 1);
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        response.sendRedirect(request.getContextPath());
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id == null || id.equals("")) {
            response.sendRedirect(request.getContextPath() + "/views/cart/cart.jsp");
            return;
        }
        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        if (cart == null) {
            response.sendRedirect(request.getContextPath()+ "/views/cart/cart.jsp");
            return;
        }

        cart.deleteById(Integer.parseInt(id));
        response.sendRedirect(request.getContextPath()+ "/views/cart/cart.jsp");

    }

    private void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        if (cart == null) {
            response.sendRedirect(request.getContextPath()+ "/views/cart/cart.jsp");
        }else {
            cart.clear();
            response.sendRedirect(request.getContextPath()+ "/views/cart/cart.jsp");
        }


    }


    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String count = request.getParameter("count");
        String id = request.getParameter("id");
        //todo 数据错误校验
        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        boolean ans = cart.update(Integer.parseInt(id),Integer.parseInt(count));
        response.sendRedirect(request.getContextPath()+ "/views/cart/cart.jsp");
    }



}

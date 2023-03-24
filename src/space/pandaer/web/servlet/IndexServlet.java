package space.pandaer.web.servlet;

import space.pandaer.entity.HouseHold;
import space.pandaer.entity.Page;
import space.pandaer.service.HouseHoldService;
import space.pandaer.service.impl.HouseHoldServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class IndexServlet extends HttpServlet {
    private final HouseHoldService houseHoldService = new HouseHoldServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Page<HouseHold> page = houseHoldService.page(0, 8);
        request.setAttribute("page",page);
        request.getRequestDispatcher("/views/customer/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

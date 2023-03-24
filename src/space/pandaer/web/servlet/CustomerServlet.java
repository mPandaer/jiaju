package space.pandaer.web.servlet;

import space.pandaer.entity.HouseHold;
import space.pandaer.entity.Page;
import space.pandaer.service.HouseHoldService;
import space.pandaer.service.impl.HouseHoldServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerServlet extends BaseServlet {
    private final HouseHoldService houseHoldService = new HouseHoldServiceImpl();
    //分页
    public void page(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pageNo = request.getParameter("pageNo");
        Integer pageSize = 8;
        Page<HouseHold> page = houseHoldService.page(Integer.parseInt(pageNo), pageSize);
        request.setAttribute("page",page);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/customer/index.jsp");
        requestDispatcher.forward(request,response);

    }

    public void pageWithName(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String pageNo = request.getParameter("pageNo");
        pageNo = pageNo == null ? "" : pageNo;
        String name = request.getParameter("name");
        name = name == null ? "" : name;
        Integer pageSize = 8;
        Page<HouseHold> page = houseHoldService.pageWithName(name,Integer.parseInt(pageNo), pageSize);
        request.setAttribute("page",page);
        request.setAttribute("name",name);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/customer/index.jsp");
        requestDispatcher.forward(request,response);

    }
}

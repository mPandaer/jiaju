package space.pandaer.web.servlet;

import space.pandaer.entity.HouseHold;
import space.pandaer.entity.Member;
import space.pandaer.entity.Page;
import space.pandaer.service.HouseHoldService;
import space.pandaer.service.impl.HouseHoldServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class HouseHoldServlet extends BaseServlet{
    private final HouseHoldService houseHoldService = new HouseHoldServiceImpl();
    //列出全部家居信息
    private void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        HttpSession session = request.getSession();
        Member admin = (Member) session.getAttribute("admin");
        if (admin == null || admin.getRole() != 1) {
            response.sendRedirect(request.getContextPath());
            return;
        }

        List<HouseHold> houseHolds = houseHoldService.listHouseHold();
        request.setAttribute("households",houseHolds);
        request.getRequestDispatcher("/manager/furn_manage.jsp").forward(request,response);
    }

    //添加家具信息
    private void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //后面用过滤器改造
        HttpSession session = request.getSession();
        Member admin = (Member) session.getAttribute("admin");
        if (admin == null || admin.getRole() != 1) {
            response.sendRedirect(request.getContextPath());
            return;
        }

        String name = request.getParameter("name");
        String maker = request.getParameter("maker");
        String price = request.getParameter("price");
        String sales = request.getParameter("sales");
        String stock = request.getParameter("stock");

        HouseHold houseHold = new HouseHold(name,maker,new BigDecimal(price),
                Integer.parseInt(sales),Integer.parseInt(stock));
        boolean ans = houseHoldService.addHouseHold(houseHold);
        String path = request.getContextPath() +
                "/manager/household?action=" + (ans ? "list" : "/manager/furn_add.html");
        response.sendRedirect(path);

    }


    //删除家具信息
    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        try{
            String id = request.getParameter("id");
            HouseHold houseHold = new HouseHold();
            houseHold.setId(Integer.parseInt(id));
            boolean ans = houseHoldService.deleteHouseHold(houseHold);

        }catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/manager/household?action=list");




    }

    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String maker = request.getParameter("maker");
        String price = request.getParameter("price");
        String sales = request.getParameter("sales");
        String stock = request.getParameter("stock");
        String pageNo = request.getParameter("pageNo");
        HouseHold houseHold = new HouseHold(Integer.parseInt(id),name,maker,
                new BigDecimal(price),Integer.parseInt(sales),Integer.parseInt(stock));
        boolean ans = houseHoldService.updateHouseHold(houseHold);
        if (ans) {
            response.sendRedirect(request.getContextPath() + "/manager/household?action=page&pageNo=" + pageNo);
        }else {
            //暂时这么处理
            response.sendRedirect(request.getContextPath() + "/manager/household?action=list");
        }
    }


    public void show(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String id = request.getParameter("id");
        String pageNo = request.getParameter("pageNo");

        //没有考虑数据不符合规范
        HouseHold houseHold = houseHoldService.getHouseHoldById(Integer.parseInt(id));
        request.setAttribute("item",houseHold);
        request.setAttribute("pageNo",Integer.parseInt(pageNo));
        request.getRequestDispatcher("/manager/furn_update.jsp").forward(request,response);

    }

    //分页
    public void page(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String pageNo = request.getParameter("pageNo");
        Integer pageSize = 8;
        Page<HouseHold> page = houseHoldService.page(Integer.parseInt(pageNo), pageSize);
        System.out.println(page);
        request.setAttribute("page",page);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/manager/furn_manage.jsp");
        requestDispatcher.forward(request,response);

    }


}

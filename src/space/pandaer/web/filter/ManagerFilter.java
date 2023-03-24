package space.pandaer.web.filter;

import space.pandaer.entity.Member;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ManagerFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = ((HttpServletRequest) request);
        HttpServletResponse rep =((HttpServletResponse)response);
        HttpSession session = req.getSession();
        Member admin = (Member) session.getAttribute("admin");
        if (admin == null || admin.getRole() != 1) {
            rep.sendRedirect(req.getContextPath() + "/views/member/login.jsp");
            return;
        }
        chain.doFilter(request, response);
    }
}

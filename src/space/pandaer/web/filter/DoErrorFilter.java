package space.pandaer.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DoErrorFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(request, response);
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        int status = resp.getStatus();
        System.out.println(status);
        if (status == 404){
            resp.sendRedirect(req.getContextPath() + "/404.html");
//            req.getRequestDispatcher("/404.html").forward(request,response);
            return;
        }else if (status >= 500) {
//            resp.sendRedirect(req.getContextPath() + "/500.html");
            req.getRequestDispatcher("/500.html").forward(request,response);
            return;

        }
    }
}

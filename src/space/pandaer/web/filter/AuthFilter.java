package space.pandaer.web.filter;

import space.pandaer.entity.Member;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AuthFilter implements Filter {

    enum Auth {
        Member,Manger,Nothing
    }

    //需要鉴权的清单
    private final List<String> authList = new ArrayList<>();

    public void init(FilterConfig config) throws ServletException {
        //添加需要鉴权的路径
        authList.add("/cart");
        authList.add("/order");
        authList.add("/manager");
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String path = req.getRequestURI(); //获取到请求路径
        System.out.println(path);
        HttpSession session = req.getSession();
            Auth auth = isAuth(path);
        //如果需要用户权限
        if (auth == Auth.Member) {
            Member member = (Member) session.getAttribute("member"); //获取用户权限
            //判断是否访问登录页面
            boolean login = path.contains("login.jsp");
            if (member == null && !login) {
                resp.sendRedirect(req.getContextPath() + "/views/member/login.jsp");
                return;
            }
        }

        //需要管理员权限
        if (auth == Auth.Manger) {
            Member member = (Member) session.getAttribute("admin"); //获取用户权限
            boolean login = path.contains("manager_login");
            if ((member == null && !login) || (member != null && member.getRole() != 1)) {
                resp.sendRedirect(req.getContextPath() + "/views/member/manage_login.html");
                return;
            }
        }
        //其他的就是任何权限都可以访问。
        chain.doFilter(request, response);


    }


    //判断路径是否需要鉴权
    private Auth isAuth(String url) {
        boolean isAuth = false;
        for (String s : authList) {
            if (url.contains(s)) {
                isAuth = true;
                break;
            }
        }
        if (!isAuth) return Auth.Nothing;
        if (url.contains("cart") || url.contains("order")) return Auth.Member;
        if (url.contains("manager")) return Auth.Manger;
        return Auth.Nothing;
    }



}

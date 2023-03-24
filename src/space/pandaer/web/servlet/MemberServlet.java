package space.pandaer.web.servlet;

import com.google.code.kaptcha.Constants;
import space.pandaer.entity.Member;
import space.pandaer.service.MemberService;
import space.pandaer.service.impl.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MemberServlet extends BaseServlet {
    protected final MemberService memberService = new MemberServiceImpl();

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user-name");
        String password = request.getParameter("user-password");
        Member member = new Member(null, username, password, null);
        Member user = memberService.login(member);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("member",user);
            request.getRequestDispatcher("/views/member/login_ok.jsp").forward(request, response);
        } else {
            request.setAttribute("username", username);
            request.setAttribute("msg", "用户名或密码不正确");
            request.getRequestDispatcher("/views/member/login.jsp").forward(request, response);
        }


    }


    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user-name");
        String password = request.getParameter("user-password");
        String email = request.getParameter("user-email");
        String code = request.getParameter("code");
        String rightCode = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);

        if (code == null || !code.equals(rightCode)){
            request.setAttribute("msg","验证码不正确");
            request.setAttribute("username",username);
            request.setAttribute("email",email);
            request.getRequestDispatcher("/views/member/login.jsp").forward(request,response);
            return;
        }


        Member member = new Member(username, password, email);
        boolean ans = memberService.registerMember(member);
        if (ans) {
            request.getRequestDispatcher("/views/member/register_ok.html").forward(request, response);
        } else {
            request.getRequestDispatcher("/views/member/register_fail.html").forward(request, response);
        }
    }

    private void adminLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String username = request.getParameter("user-name");
        String password = request.getParameter("user-password");
        Member admin = memberService.login(new Member(null, username, password, null));
        if (admin == null || admin.getRole() != 1) {
            response.sendRedirect("/jiaju/");
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("admin",admin);
            request.getRequestDispatcher("/manager/manage_menu.html").forward(request,response);
        }

    }

    private void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath());
    }
}

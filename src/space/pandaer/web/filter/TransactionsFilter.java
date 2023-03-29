package space.pandaer.web.filter;

import space.pandaer.utils.JDBCUtilsByDruid;

import javax.servlet.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class TransactionsFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            connection.setAutoCommit(false); //将自动提交设置为false
            chain.doFilter(request, response);
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }finally {
            JDBCUtilsByDruid.close(null,null,connection); //无论是否提交成功都要释放连接
        }

    }
}

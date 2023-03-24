package space.pandaer.web.listener;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GlobalWebListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("服务器停止");
        try {
            while (DriverManager.getDrivers().hasMoreElements()) {
                DriverManager.deregisterDriver(DriverManager.getDrivers().nextElement());
            }
            System.out.println("JDBC驱动关闭");
            AbandonedConnectionCleanupThread.checkedShutdown();
            System.out.println("清理进程");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

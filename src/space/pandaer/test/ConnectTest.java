package space.pandaer.test;

import org.junit.jupiter.api.Test;
import space.pandaer.utils.JDBCUtilsByDruid;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectTest {


    @Test
    public void testConnect() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        System.out.println(connection);
        JDBCUtilsByDruid.close(null,null,connection);
    }
}

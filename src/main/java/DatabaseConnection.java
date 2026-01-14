import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // 数据库连接配置（需替换为你的MySQL信息）
    private static final String URL = "jdbc:mysql://localhost:3306/student_management?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    // 获取数据库连接
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // 加载MySQL驱动（MySQL 8.0+可省略，但建议保留）
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 创建连接
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("MySQL驱动加载失败");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("数据库连接失败");
        }
        return connection;
    }

    // 关闭数据库连接
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
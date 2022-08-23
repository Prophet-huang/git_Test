package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 工具类
 * 用于完成连接数据库 school 的初始化连接
 */
public class JDBCUtils {

    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    // 初始化连接所需信息，导入配置文件。
    static {

        InputStream inputStream = ClassLoader.getSystemResourceAsStream("db.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 连接数据库
     *
     * @return 返回一个 Connection 类型的对象，用于调用者对数据库操作。
     * @throws ClassNotFoundException 无法找到驱动
     * @throws SQLException           数据库异常
     */
    public static Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 该方法重载 资源回收
     * @param resultSet 传入 ResultSet 类 用于关闭接口
     * @param statement 传入 PreparedStatement 类 用于关闭接口
     * @param connection 传入 Connection 类 用于关闭接口
     * @throws SQLException 数据库异常
     */
    public static void close(ResultSet resultSet, PreparedStatement statement, Connection connection) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }

        if (statement != null) {
            statement.close();
        }

        if (connection != null) {
            connection.close();
        }
    }
    public static void close(PreparedStatement statement, Connection connection) throws SQLException {
        if (statement != null) {
            statement.close();
        }

        if (connection != null) {
            connection.close();
        }
    }
}

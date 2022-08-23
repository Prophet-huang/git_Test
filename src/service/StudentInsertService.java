package service;

import util.JDBCUtils;

import java.sql.*;
import java.time.LocalDateTime;

/**
 *
 */
public class StudentInsertService {
    static Connection connection;
    static PreparedStatement preparedStatement;
    static Timestamp createTime;

    public static void insertInto(String name, byte age, byte gender) {
        try {
            connection = JDBCUtils.connect();

            String sql = "insert into jdbc_student select (ifnull(max(pk_id),0)+1) ,? ,? ,?,?,null from jdbc_student";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, name);
            preparedStatement.setByte(2, age);
            preparedStatement.setByte(3, gender);
            createTime = Timestamp.valueOf(LocalDateTime.now());
            preparedStatement.setTimestamp(4, createTime);


            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("Update success");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                JDBCUtils.close(preparedStatement, connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}

package service;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDeleteService {
    static Connection connection;
    static PreparedStatement preparedStatement;

    public static void deleteByPkId(long pkId) {
        try {
            connection = JDBCUtils.connect();

            String sql = "delete from jdbc_student where pk_id=? ";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, pkId);

            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("Delete success");
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

    public static void deleteAll() {
        try {
            connection = JDBCUtils.connect();

            String sql = "truncate table jdbc_student";
            preparedStatement = connection.prepareStatement(sql);

            int i = preparedStatement.executeUpdate();
            if (i <= 0) {
                System.out.println("DeleteAll success");
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

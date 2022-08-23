package service;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class StudentUpdateService {
    static Connection connection;
    static PreparedStatement preparedStatement;
    static Timestamp updateTime = Timestamp.valueOf(LocalDateTime.now());


    public static void updateByPkId(String name, byte age, byte gender, long pkId) {
        try {
            connection = JDBCUtils.connect();

            String sql = "update jdbc_student set name=? ,age=? ,gender=? ,update_time=? where pk_id=?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, name);
            preparedStatement.setByte(2, age);
            preparedStatement.setByte(3, gender);
            preparedStatement.setTimestamp(4, updateTime);
            preparedStatement.setLong(5, pkId);

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

    public static void updateByPkId(byte age, byte gender, long pkId) {
        try {
            connection = JDBCUtils.connect();

            String sql = "update jdbc_student set age=? ,gender=?,update_time=? where pk_id=?";
            preparedStatement = connection.prepareStatement(sql);


            preparedStatement.setByte(1, age);
            preparedStatement.setByte(2, gender);
            preparedStatement.setTimestamp(3, updateTime);
            preparedStatement.setLong(4, pkId);

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

    public static void updateByPkId(byte gender, long pkId) {
        try {
            connection = JDBCUtils.connect();

            String sql = "update jdbc_student set gender=?,update_time=? where pk_id=?";
            preparedStatement = connection.prepareStatement(sql);


            preparedStatement.setByte(1, gender);
            preparedStatement.setTimestamp(2,updateTime);
            preparedStatement.setLong(3, pkId);

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

    public static void updateByPkId(String name, long pkId) {
        try {
            connection = JDBCUtils.connect();

            String sql = "update jdbc_student set name=? ,update_time=? where pk_id=?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, name);
            preparedStatement.setTimestamp(2,updateTime);
            preparedStatement.setLong(3, pkId);

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

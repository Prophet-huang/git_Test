package service;

import model.StudentModel;
import util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 */
public class StudentSelectService {
    static Connection connection;
    static PreparedStatement preparedStatement;
    static ResultSet resultSet;


    public static void selectAllStudent() {
        ArrayList<StudentModel> studentList = new ArrayList<>();
        try {
            connection = JDBCUtils.connect();

            String sql = "select * from jdbc_student";
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long pkId = resultSet.getLong(1);
                String name = resultSet.getString(2);
                byte age = resultSet.getByte(3);
                byte gender = resultSet.getByte(4);
                Timestamp createTime = resultSet.getTimestamp(5);
                Timestamp updateTime = resultSet.getTimestamp(6);

                studentList.add(new StudentModel(pkId, name, age, gender,createTime,updateTime));
            }
            System.out.println(studentList);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                JDBCUtils.close(resultSet, preparedStatement, connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}

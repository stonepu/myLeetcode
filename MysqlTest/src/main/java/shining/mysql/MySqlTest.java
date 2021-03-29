package shining.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlTest {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "root", "1234");
            System.out.println("connect success");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            if(connection != null) {
                try {
                    connection.close();
                    System.out.println("close success");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}

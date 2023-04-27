package org.example;

import org.example.util.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AppTwo {
    public static void main(String[] args) {
        String sql = """
                SELECT * 
                FROM bikes
                WHERE model = 'Suzuki'
                """;

        try(Connection connection = ConnectionManager.open();
            Statement statement = connection.createStatement()) {
            System.out.println(connection.getTransactionIsolation());
            System.out.println(connection.getSchema());

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("model"));
                System.out.println(resultSet.getDouble("price"));
                System.out.println(resultSet.getInt("power"));
                System.out.println("----------------------------------------------------------------");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

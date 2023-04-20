package org.example.dao;

import org.example.util.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BikeDaoJdbcImpl {
    public void createTable() {
        try (Statement statement = Util.getConnection().createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS bikes (id BIGINT PRIMARY KEY AUTO_INCREMENT, " +
                    "model VARCHAR(45), price DOUBLE, power INT)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package org.example.util;

import org.testcontainers.containers.PostgreSQLContainer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerTest {
    private final static PostgreSQLContainer<?> postgreSQLContainer =
            new PostgreSQLContainer<>("postgres:15");
    private static final String DB_URL = postgreSQLContainer.getJdbcUrl();
    private static final String DB_USERNAME = postgreSQLContainer.getUsername();
    private static final String DB_PASSWORD = postgreSQLContainer.getPassword();

    static {
        postgreSQLContainer.start();
    }

    private ConnectionManagerTest() {
    }

    public static Connection open() {
        try {
            return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        }
    }


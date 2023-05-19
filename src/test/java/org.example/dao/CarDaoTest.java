package org.example.dao;

import org.example.util.ConnectionManagerTest;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CarDaoTest {
    private static final String CREATE_TABLE = """
            CREATE TABLE IF NOT EXISTS car (
            id SERIAL primary key,
            model varchar(30) not null,
            powerHorse INT not null,
            price DOUBLE PRECISION not null 
            )
            """;
    private static final String DELETE_TABLE = """
            DROP TABLE IF EXIST car;
            """;
    private static final String CLEAN_TABLE = """
            TRUNCATE TABLE car;
            """;
    private static final String DELETE_SQL = """
            DELETE FROM car
            WHERE id = ?
            """;
    private static final String FIND_ALL = """
            SELECT id,
                model,
                powerHorse,
                price
            FROM car
            """;
    private static final String FIND_BY_ID = FIND_ALL + """
            WHERE id = ?
            """;
    private static final String SAVE_SQL = """
            INSERT INTO car (model, powerHorse, price) 
            VALUES (?, ?, ?)
            """;
    private static final String UPDATE_SQL = """
            UPDATE car 
            SET model = ?,
                powerHorse = ?,
                price = ?
            WHERE id = ?
            """;
    @Test
    public void test() throws SQLException {
        Assertions.assertEquals(1, 1);
        Connection connection = ConnectionManagerTest.open();
        Statement statement = connection.createStatement();
        statement.execute(CREATE_TABLE);
        statement.execute(SAVE_SQL);
        statement.execute(FIND_BY_ID);

    }
}

package org.example.dao;

import org.example.util.ConnectionManagerTest;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BikeDaoTest {
    private static final String CREATE_TABLE = """
            CREATE TABLE IF NOT EXIST bike (
            id SERIAL primary key,
            model varchar(30) not null,
            power INT not null,
            price DOUBLE PRECISION not null 
            )
            """;
    private static final String DELETE_TABLE = """
            DROP TABLE IF EXIST bike;
            """;
    private static final String CLEAN_TABLE = """
            TRUNCATE TABLE bike;
            """;
    private static final String DELETE_SQL = """
            DELETE FROM bike
            WHERE id = ?
            """;
    private static final String FIND_ALL = """
            SELECT id,
                model,
                power,
                price
            FROM bike
            """;
    private static final String FIND_BY_ID = FIND_ALL + """
            WHERE id = ?
            """;
    private static final String SAVE_SQL = """
            INSERT INTO bike (model, power, price) 
            VALUES (?, ?, ?)
            """;

    private static final String UPDATE_SQL = """
            UPDATE bike 
            SET model = ?,
                power = ?,
                price = ?
            WHERE id = ?
            """;
    @Test
    public void test() throws SQLException {
        Assertions.assertEquals(1, 0);
        Connection connection = ConnectionManagerTest.open();
        Statement statement = connection.createStatement();
        statement.execute(CREATE_TABLE);
        statement.execute(SAVE_SQL);
        statement.execute(FIND_BY_ID);
    }
}

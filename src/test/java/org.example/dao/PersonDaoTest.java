package org.example.dao;

import org.example.util.ConnectionManagerTest;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonDaoTest {
    private static final String CREATE_TABLE = """
            CREATE TABLE IF NOT EXISTS person (
            id SERIAL primary key,
            firstName varchar(30) not null,
            lastName varchar(30) not null,
            email varchar(30) not null,
            number INT not null,
            money DOUBLE PRECISION not null 
            )
            """;
    private static final String DELETE_TABLE = """
            DROP TABLE IF EXIST person;
            """;
    private static final String CLEAN_TABLE = """
            TRUNCATE TABLE person;
            """;
    private static final String DELETE_SQL = """
            DELETE FROM person
            WHERE id = ?
            """;
    private static final String FIND_ALL = """
            SELECT id,
                firstName,
                lastName,
                email,
                number,
                money
            FROM person
            """;
    private static final String FIND_BY_ID = FIND_ALL + """
            WHERE id = ?
            """;
    private static final String SAVE_SQL = """
            INSERT INTO person (firstName, lastName, email, number, money) 
            VALUES (?, ?, ?, ?, ?)
            """;
    private static final String UPDATE_SQL = """
            UPDATE person 
            SET firstName = ?,
                lastName = ?,
                email = ?,
                number = ?,
                money = ?
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

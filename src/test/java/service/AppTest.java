package service;

import org.example.service.*;
import org.example.models.Car;
import org.example.models.Person;
import org.example.models.Bike;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;

import static java.lang.System.*;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    private final static PostgreSQLContainer<?> postgreSQLContainer =
            new PostgreSQLContainer<>("postgres:15");
    private final String DB_URL = postgreSQLContainer.getJdbcUrl();
    private final String DB_USERNAME = postgreSQLContainer.getUsername();
    private final String DB_PASSWORD = postgreSQLContainer.getPassword();

    static {
        postgreSQLContainer.start();
    }



}

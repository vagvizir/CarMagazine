package org.example;

import org.example.dao.BikeDaoImpl;
import org.example.dao.CarDaoJdbcImpl;
import org.example.dao.PersonDaoJdbcImpl;
import org.example.models.Bike;
import org.example.models.Person;

public class AppTwo {
    public static void main(String[] args) {
//        String sql = """
//                SELECT *
//                FROM bikes
//                WHERE model = 'Suzuki'
//                """;
//
//        try(Connection connection = ConnectionManager.open();
//            Statement statement = connection.createStatement()) {
//            System.out.println(connection.getTransactionIsolation());
//            System.out.println(connection.getSchema());
//
//            ResultSet resultSet = statement.executeQuery(sql);
//
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString("model"));
//                System.out.println(resultSet.getDouble("price"));
//                System.out.println(resultSet.getInt("power"));
//                System.out.println("----------------------------------------------------------------");
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        BikeDaoImpl bikeDaoJdbcImpl = new BikeDaoImpl();
        bikeDaoJdbcImpl.createTable();
        Bike bikeOne = new Bike("Suzuki", 100, 900_000);
//        bikeDaoJdbcImpl.deleteBike("Suzuki");

//        CarDaoJdbcImpl carDaoJdbcImpl = new CarDaoJdbcImpl();
//        carDaoJdbcImpl.dropTable();
//        carDaoJdbcImpl.createTable();
//        Car carOne = new Car("Omoda", 120, 2_200_000);
//        carDaoJdbcImpl.saveCar(carOne);
//        System.out.println(carDaoJdbcImpl.getCar(1));

        PersonDaoJdbcImpl personDaoJdbc = new PersonDaoJdbcImpl();
//        personDaoJdbc.dropTable();
        personDaoJdbc.createTable();
        Person personOne = new Person("Akakiy",
                "Ivanov",
                "akaakaSpv@mail.ru",
                33,
                5_600_000);
        personDaoJdbc.savePerson(personOne);
        System.out.println(personDaoJdbc.getPerson(1));

    }
}

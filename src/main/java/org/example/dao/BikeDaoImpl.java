package org.example.dao;

import org.example.models.Bike;
import org.example.models.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BikeDaoImpl implements BikeDao {
    List <Bike> bikes = new ArrayList<>();

    @Override
    public void saveBike(Bike... bikes) {
        this.bikes.addAll(Arrays.asList(bikes));
    }

    @Override
    public Bike getBike(int bikeId) {
        return bikes.get(bikeId);
    }

    @Override
    public void deleteBike(int bikeId) {
        bikes.remove(bikeId);
    }

   @Override
   public Bike getMaxBikePrice() {
        bikes.sort((b1, b2) -> Double.compare(b1.getPrice(), b2.getPrice()));
        // что с чем сравниваем? util/App/bikeOne bikeTwo?
        return bikes.get(bikes.size() - 1); // ?? что нужно плучить size??
    }
    @Override
    public Bike getMinBikePrice() {
        bikes.sort((b1, b2) -> Double.compare(b1.getPrice(), b2.getPrice()));
        return bikes.get(0);
    }
    @Override
    public Bike getMaxBikePower() {
        bikes.sort((b1, b2) -> Integer.compare(b1.getPower(), b2.getPower()));
        return bikes.get((bikes.size() - 1));
    }

    @Override
    public Bike getMinBikePower() {
        bikes.sort((b1, b2) -> Integer.compare(b1.getPower(), b2.getPower()));
        return bikes.get(0);
    }
    @Override
    public void buyBike(Person person, int id) {
        person.setMoney(person.getMoney() - bikes.get(id).getPrice());
        bikes.remove(id);
    }

    @Override
    public int sizeDb() {
        return bikes.size();
    }

    @Override
    public List<Bike> getAll() {
        return bikes;
    }
}

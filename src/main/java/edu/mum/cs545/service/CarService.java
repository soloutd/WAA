package edu.mum.cs545.service;


import edu.mum.cs545.model.Car;

import java.util.List;

public interface CarService {
    public Car save(Car car);
    public List<Car> findAll();
}

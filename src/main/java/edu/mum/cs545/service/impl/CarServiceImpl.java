package edu.mum.cs545.service.impl;

import edu.mum.cs545.model.Car;
import edu.mum.cs545.repository.CarRepository;
import edu.mum.cs545.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService{
    @Autowired
    private CarRepository carRepository;
    public Car save(Car car){
         return carRepository.save(car);
    }
    public List<Car> findAll(){
        return (List<Car>)carRepository.findAll();
    }
}

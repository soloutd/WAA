package edu.mum.cs545.repository;

import edu.mum.cs545.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car,Long>{

}

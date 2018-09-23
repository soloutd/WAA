package edu.mum.cs545.factory;

import edu.mum.cs545.model.Car;
import edu.mum.cs545.model.dto.CarDto;

public class CarFactory {
    private static CarFactory INSTANCE = null;

    public CarFactory() {

    }

    public static CarFactory getInstance()
    {
        if (INSTANCE == null)
            INSTANCE = new CarFactory();

        return INSTANCE;
    }

    public Car createUserFromDto(CarDto dto) {
        Car c = new Car();
        c.setName(dto.getName());
        c.setCarNumber(dto.getCarNumber());
        c.setUser(dto.getUser());
        c.setMainPicturePath(dto.getMainPicturePath());
        c.setExpireDate(dto.getExpireDate());
        c.setColor(dto.getColor());
        c.setEngine(dto.getEngine());
        c.setMileAge(dto.getMileAge());
        c.setTransmisson(dto.getTransmisson());
        c.setPrice(dto.getPrice());
        c.setDescription(dto.getDescription());
        return c;
    }
}

package com.haydikodlayalim.exchandling.service;

import com.haydikodlayalim.exchandling.dto.Car;
import com.haydikodlayalim.exchandling.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private static List<Car> carList = new ArrayList<>();

    @PostConstruct
    public void init() {
        carList.add(new Car("A","Brand 1"));
        carList.add(new Car("B","Brand 2"));
        carList.add(new Car("C","Brand 3"));
        carList.add(new Car("D","Brand 4"));
    }

    public Car getCar(String name) {
        if(name.startsWith("1")) {
            throw new IllegalArgumentException();
        }
        return carList.stream().filter(item ->item.getName().equals(name)).findFirst()
                .orElseThrow(() -> new EntityNotFoundException(name));
    }
}

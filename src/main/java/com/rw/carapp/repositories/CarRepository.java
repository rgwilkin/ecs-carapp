package com.rw.carapp.repositories;

import com.rw.carapp.models.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository
    extends CrudRepository<Car, Integer> {
}

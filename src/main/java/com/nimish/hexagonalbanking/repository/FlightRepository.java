package com.nimish.hexagonalbanking.repository;

import com.nimish.hexagonalbanking.entity.Flight;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlightRepository extends CrudRepository<Flight, Long>,CustomFlightRepository{

    List<Flight> findByOrigin(String origin);

    List<Flight> findByOriginInIgnoreCase(String... origin);

}

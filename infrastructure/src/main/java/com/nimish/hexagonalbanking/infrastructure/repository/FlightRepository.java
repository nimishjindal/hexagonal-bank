package com.nimish.hexagonalbanking.infrastructure.repository;

import com.nimish.hexagonalbanking.infrastructure.entity.Flight;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlightRepository extends CrudRepository<Flight, Long>,CustomFlightRepository{

    List<Flight> findByOrigin(String origin);

    List<Flight> findByOriginInIgnoreCase(String... origin);

}

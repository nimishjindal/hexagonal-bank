package com.nimish.hexagonalbanking;

import com.nimish.hexagonalbanking.entity.Flight;
import com.nimish.hexagonalbanking.repository.FlightRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
class CustomJpaImpTest {

    @Autowired
    private FlightRepository flightRepository;

    @Before
    public void setUp(){
        flightRepository.deleteAll();
    }

    @Test
    public void testFlightCustomDeleteDelhi() {
        final Flight flight1 = new Flight("Delhi");
        final Flight flight2 = new Flight("Delhi");
        final Flight flight3 = new Flight("Africa");

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);

        flightRepository.deleteByOrigin("Delhi");

        List<Flight> resultSetAfterDeletingDelhi = (List<Flight>) flightRepository.findAll();

        assertThat(resultSetAfterDeletingDelhi).hasSize(1);
        assertThat(resultSetAfterDeletingDelhi.get(0))
                .isEqualToComparingFieldByField(flight3)
                .isNotEqualTo(flight2);

    }

    @Test
    public void testFlightFromDelhiOrMumbai(){
        final Flight flight1 = new Flight("Delhi");
        final Flight flight2 = new Flight("Delhi");
        final Flight flight3 = new Flight("mumbai");
        final Flight flight4 = new Flight("dhaka");
        final Flight flight5 = new Flight("not Delhi");

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);
        flightRepository.save(flight4);
        flightRepository.save(flight5);

        List<Flight> mumbaiOrDelhiResultSet= flightRepository.findByOriginInIgnoreCase("Delhi","MumBai");

        assertThat(mumbaiOrDelhiResultSet)
                .hasSize(3)
                .contains(flight1,flight2,flight3)
                .doesNotContain(flight4, flight5);

    }

}

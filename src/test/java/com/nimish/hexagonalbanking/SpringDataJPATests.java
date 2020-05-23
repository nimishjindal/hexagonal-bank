package com.nimish.hexagonalbanking;

import com.nimish.hexagonalbanking.entity.Flight;
import com.nimish.hexagonalbanking.repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
class SpringDataJPATests {

	@Autowired
	private FlightRepository flightRepository;

	@Test
	public void testFlightCanBeSaved() {
		final Flight flight = new Flight();
		flight.setOrigin("Delhi");

		flightRepository.save(flight);

		assertThat(flightRepository.findAll())
				.hasSize(1)
				.first().
				isEqualToComparingFieldByField(flight);

		flightRepository.deleteById(flight.getId());

		assertThat(flightRepository.findAll())
				.hasSize(0);

	}
}

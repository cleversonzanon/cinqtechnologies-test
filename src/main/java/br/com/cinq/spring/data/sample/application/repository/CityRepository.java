package br.com.cinq.spring.data.sample.application.repository;

import br.com.cinq.spring.data.sample.application.entity.City;
import br.com.cinq.spring.data.sample.application.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer>{
    List<City> findByCountry(final Country country);
    List<City> findByCountryNameContaining(final String name);
}

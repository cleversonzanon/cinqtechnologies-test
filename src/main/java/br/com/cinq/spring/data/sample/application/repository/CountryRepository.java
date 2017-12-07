package br.com.cinq.spring.data.sample.application.repository;

import br.com.cinq.spring.data.sample.application.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>{
    List<Country> findByNameContaining(final String name);
}

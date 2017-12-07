package br.com.cinq.spring.data.service.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.cinq.spring.data.sample.application.Application;
import br.com.cinq.spring.data.sample.application.entity.City;
import br.com.cinq.spring.data.sample.application.entity.Country;
import br.com.cinq.spring.data.sample.application.repository.CityRepository;
import br.com.cinq.spring.data.sample.application.repository.CountryRepository;
import br.com.cinq.spring.data.sample.application.service.ServiceFacade;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ServiceFacadeIT {

    @Autowired
    private ServiceFacade serviceFacade;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Test
    public void loadDataTest(){
        this.serviceFacade.loadData();

        List<Country> countries = countryRepository.findAll();
        List<City> cities = cityRepository.findAll();

        Assert.assertEquals(4, countries.size());
        Assert.assertEquals(13, cities.size());
    }

}

package br.com.cinq.spring.data.repository.test;

import java.util.List;

import br.com.cinq.spring.data.sample.application.entity.City;
import br.com.cinq.spring.data.sample.application.entity.Country;
import br.com.cinq.spring.data.sample.application.repository.CityRepository;
import br.com.cinq.spring.data.sample.application.service.ServiceFacade;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.cinq.spring.data.sample.application.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ActiveProfiles("unit")
public class CityRepositoryTest {

    @Autowired
    private CityRepository dao;

    @Test
    public void testFindCityByCountry() {

        Assert.assertNotNull(dao);
        
        Assert.assertTrue(dao.count()>0);

        Country country = new Country();
        country.setCountryId(3); // Should be France

        List<City> list = dao.findByCountry(country);

        Assert.assertEquals(2, list.size());
    }

    @Test
    public void testFindCityByCountryName() {

        Assert.assertNotNull(dao);

        Assert.assertTrue(dao.count()>0);

        List<City> list = dao.findByCountryNameContaining("Bra");

        Assert.assertEquals(4, list.size());
    }
}

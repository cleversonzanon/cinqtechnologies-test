package br.com.cinq.spring.data.sample.application.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter

@Service
public class ServiceFacade {

    private final CityService cityService;
    private final CountryService countryService;

    @Autowired
    public ServiceFacade(CityService cityService, CountryService countryService) {
        this.cityService = cityService;
        this.countryService = countryService;
    }

    public void loadData(){
        this.countryService.loadCountries();
        this.cityService.loadCities();
    }
}

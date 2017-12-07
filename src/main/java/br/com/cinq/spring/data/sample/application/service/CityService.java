package br.com.cinq.spring.data.sample.application.service;

import br.com.cinq.spring.data.sample.application.entity.City;
import br.com.cinq.spring.data.sample.application.entity.Country;
import br.com.cinq.spring.data.sample.application.repository.CityRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

@Service
public class CityService {

    private final Logger logger = LoggerFactory.getLogger(CityService.class);

    private final CityRepository cityRepository;
    private final CountryService countryService;

    @Autowired
    public CityService(CityRepository cityRepository, CountryService countryService) {
        this.cityRepository = cityRepository;
        this.countryService = countryService;
    }

    @Transactional
    public void loadCities() {

        try{
            List<Country> countries = this.countryService.findAll();

            String path = new ClassPathResource("data/cities.csv").getURI().getPath();
            Reader in = new FileReader(path);
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);

            records.forEach(it ->{
                Integer countryId = Integer.valueOf(it.get(1));
                Country country = countries.stream().filter(c -> c.getCountryId().equals(countryId)).findFirst().get();

                City city = new City();
                city.setName(it.get(0));
                city.setCountry(country);

                this.cityRepository.save(city);
            });

        } catch (IOException e){
            logger.error("Cities file not found.");
        }
    }

    public List<City> getCitiesByCountry(final String countryName){
        return (!StringUtils.isEmpty(countryName)? cityRepository.findByCountryNameContaining(countryName) : cityRepository.findAll());
    }
}

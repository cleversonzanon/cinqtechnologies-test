package br.com.cinq.spring.data.sample.application.service;

import br.com.cinq.spring.data.sample.application.entity.Country;
import br.com.cinq.spring.data.sample.application.repository.CountryRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

@Service
public class CountryService {

    private final Logger logger = LoggerFactory.getLogger(CountryService.class);

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Transactional
    public void loadCountries() {

        try{
            String path = new ClassPathResource("data/countries.csv").getURI().getPath();
            Reader in = new FileReader(path);
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);

            records.forEach(it -> {
                Country country = new Country();
                country.setCountryId(Integer.valueOf(it.get(0)));
                country.setName(it.get(1));

                countryRepository.save(country);
            });

        }catch (IOException e){
            logger.error("Countries file not found.");
        }
    }

    public List<Country> findAll(){
        return this.countryRepository.findAll();
    }
}

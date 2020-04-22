package pl.moras.coronavirusdata.services;

import org.springframework.http.ResponseEntity;
import pl.moras.coronavirusdata.models.CountryCase;

import java.time.LocalDate;
import java.util.List;

public interface CountriesService {

    ResponseEntity<List<CountryCase>> findByDate(LocalDate localDate);

    ResponseEntity<List<CountryCase>> findByCountry(String country);
}

package pl.moras.coronavirusdata.services;

import org.springframework.http.ResponseEntity;
import pl.moras.coronavirusdata.models.CasesRecord;

import java.time.LocalDate;
import java.util.List;

public interface CountriesService {

    ResponseEntity<List<CasesRecord>> findByDate(LocalDate localDate);

    ResponseEntity<List<CasesRecord>> findByCountry(String country);
}

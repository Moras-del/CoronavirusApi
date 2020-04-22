package pl.moras.coronavirusdata.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.moras.coronavirusdata.models.CountryCase;
import pl.moras.coronavirusdata.repo.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountriesServiceImpl implements CountriesService {

    private Repository repository;

    public CountriesServiceImpl(Repository repository){
        this.repository = repository;
    }


    @Override
    public ResponseEntity<List<CountryCase>> findByDate(LocalDate localDate) {
        try {
            List<CountryCase> list = repository.getCasesPerCountry();
            return ResponseEntity.ok(
                        list.parallelStream()
                            .filter(countryCase -> countryCase.getRecordDate().isEqual(localDate))
                            .collect(Collectors.toList())
            );
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<List<CountryCase>> findByCountry(String country) {
        try {
            List<CountryCase> list = repository.getCasesPerCountry();
            return ResponseEntity.ok(
                        list.parallelStream()
                            .filter(countryCase -> countryCase.getCountryName().equalsIgnoreCase(country))
                            .collect(Collectors.toList())
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}

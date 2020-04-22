package pl.moras.coronavirusdata;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.moras.coronavirusdata.models.CountryCase;
import pl.moras.coronavirusdata.repo.Repository;
import pl.moras.coronavirusdata.services.CountriesService;
import pl.moras.coronavirusdata.services.CountriesServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class CountryServiceTests {


    @Mock
    private Repository repository;

    private CountriesService countriesService;

    @BeforeEach
    void setup() throws Exception {
        initMocks(this);
        when(repository.getCasesPerCountry()).thenReturn(getCountryCases());
        countriesService = new CountriesServiceImpl(repository);
    }

    @Test
    void should_get_case_by_country(){
        ResponseEntity<List<CountryCase>> result = countriesService.findByCountry("COUNTRYA");
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(1, result.getBody().size());
        assertEquals(LocalDate.now().minusDays(1), result.getBody().get(0).getRecordDate());
    }

    @Test
    void should_get_case_by_date(){
        ResponseEntity<List<CountryCase>> result = countriesService.findByDate(LocalDate.now());
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(1, result.getBody().size());
        assertEquals("countryB", result.getBody().get(0).getCountryName());
    }

    List<CountryCase> getCountryCases(){
        List<CountryCase> countryCases = new ArrayList<>();
        countryCases.add(new CountryCase("countryA", LocalDate.now().minusDays(1),"", 20, 30, "10", "20", "30"));
        countryCases.add(new CountryCase("countryB", LocalDate.now(), "", 20, 30, "10", "20", "30"));
        countryCases.add(new CountryCase("countryC", LocalDate.now().plusDays(1), "", 20, 30, "10", "20", "30"));
        countryCases.add(new CountryCase("countryD", LocalDate.now().plusDays(2), "", 20, 30, "10", "20", "30"));
        return countryCases;
    }

}

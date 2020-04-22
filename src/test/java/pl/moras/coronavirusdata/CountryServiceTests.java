package pl.moras.coronavirusdata;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import pl.moras.coronavirusdata.models.CountryCase;
import pl.moras.coronavirusdata.repo.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class CountryServiceTests {


    @Mock
    Repository repository;

    @BeforeEach
    void setup() throws Exception {
        initMocks(this);
        when(repository.getCasesPerCountry()).thenReturn(getCountryCases());
    }

    List<CountryCase> getCountryCases(){
        List<CountryCase> countryCases = new ArrayList<>();
        countryCases.add(new CountryCase("countryA", LocalDate.now().minusDays(1), "province", 20, 30, "10", "20", "30"));
        return countryCases;
    }

}

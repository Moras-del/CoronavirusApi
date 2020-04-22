package pl.moras.coronavirusdata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.moras.coronavirusdata.models.CountryCase;
import pl.moras.coronavirusdata.models.WorldwideCase;
import pl.moras.coronavirusdata.repo.Repository;
import pl.moras.coronavirusdata.services.CountriesService;
import pl.moras.coronavirusdata.services.CountriesServiceImpl;
import pl.moras.coronavirusdata.services.WorldwideService;
import pl.moras.coronavirusdata.services.WorldwideServiceImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class WorldwideServiceTests {
    @Mock
    private Repository repository;

    private WorldwideService worldwideService;

    @BeforeEach
    void setup() throws IOException {
        initMocks(this);
        worldwideService = new WorldwideServiceImpl(repository);
        when(repository.getWorldwideCases()).thenReturn(getWorldwideCases());
    }

    @Test
    void should_get_worldwide_cases() {

        ResponseEntity<List<WorldwideCase>> result = worldwideService.getAll();

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(getWorldwideCases().size(), result.getBody().size());
    }

    private List<WorldwideCase> getWorldwideCases() {
        List<WorldwideCase> list = new ArrayList<>();
        list.add(new WorldwideCase(LocalDate.now().minusDays(1), "10", "20", "30", "40"));
        list.add(new WorldwideCase(LocalDate.now(), "20", "20", "330", "40"));
        list.add(new WorldwideCase(LocalDate.now().plusDays(1), "30", "2330", "60", "40"));
        list.add(new WorldwideCase(LocalDate.now().plusDays(2), "4034", "24056", "380", "40"));
        return list;
    }
}

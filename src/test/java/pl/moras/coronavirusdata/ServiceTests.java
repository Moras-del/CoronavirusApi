package pl.moras.coronavirusdata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import pl.moras.coronavirusdata.model.Case;
import pl.moras.coronavirusdata.repo.Repository;
import pl.moras.coronavirusdata.services.CaseService;
import pl.moras.coronavirusdata.services.CaseServiceImpl;
import pl.moras.coronavirusdata.services.Sort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class ServiceTests {


    @Mock
    private Repository repository;

    private CaseService caseService;

    @BeforeEach
    void setup() throws Exception {
        initMocks(this);
        when(repository.getCases()).thenReturn(getCountryCases());
        caseService = new CaseServiceImpl(repository);
    }

    @Test
    void should_get_case_by_country(){
        List<Case> cases = caseService.findAll().get();
        cases = caseService.findByCountry(cases, "COUNTRYA");
        assertEquals(1, cases.size());
        assertEquals(LocalDate.now().minusDays(1), cases.get(0).getRecordDate());
    }

    @Test
    void should_get_case_by_date(){
        List<Case> cases = caseService.findAll().get();
        cases = caseService.findByDateFrom(cases, LocalDate.now());
        caseService.findByDateTo(cases, LocalDate.now());
        assertEquals(1, cases.size());
        assertEquals("countryA", cases.get(0).getCountryName());
    }

    @Test
    void should_sort_by_date(){
        List<Case> cases = caseService.findAll().get();
        cases = caseService.sortBy(cases, Sort.date);
        assertTrue(LocalDate.now().minusDays(3).isEqual(cases.get(0).getRecordDate()));
    }

    List<Case> getCountryCases(){
        List<Case> cases = new ArrayList<>();
        cases.add(buildCase("countryA", LocalDate.now()));
        cases.add(buildCase("countryB", LocalDate.now().minusDays(1)));
        cases.add(buildCase("countryC", LocalDate.now().minusDays(2)));
        cases.add(buildCase("countryD", LocalDate.now().minusDays(3)));
        return cases;
    }

    Case buildCase(String country, LocalDate date){
        return Case.builder()
                .countryName(country)
                .recordDate(date)
                .province("")
                .confirmedCases("100")
                .recoveredCases("30")
                .deaths("40")
                .build();
    }

}

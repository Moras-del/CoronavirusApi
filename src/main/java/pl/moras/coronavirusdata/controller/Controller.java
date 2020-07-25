package pl.moras.coronavirusdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.moras.coronavirusdata.gateways.WorldwideGateway;
import pl.moras.coronavirusdata.models.CountryCase;
import pl.moras.coronavirusdata.models.WorldwideCase;
import pl.moras.coronavirusdata.services.CountriesService;
import pl.moras.coronavirusdata.services.WorldwideService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/cases")
public class Controller {

    private CountriesService countryService;
    private WorldwideService worldwideService;

    public Controller(CountriesService countryService, WorldwideService worldwideService) {
        this.countryService = countryService;
        this.worldwideService = worldwideService;
    }

    @GetMapping(params = "date")
    public ResponseEntity<List<CountryCase>> findByDate(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date) {
        return countryService.findByDate(date);
    }

    @GetMapping(params = "country")
    public ResponseEntity<List<CountryCase>> findByCountry(@RequestParam String country){
        return countryService.findByCountry(country);
    }

    @GetMapping("/worldwide")
    public ResponseEntity<List<WorldwideCase>> getWorldWideCases(){
        return worldwideService.getAll();
    }
}

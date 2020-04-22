package pl.moras.coronavirusdata.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.moras.coronavirusdata.models.CountryCase;
import pl.moras.coronavirusdata.services.CountriesService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/cases")
public class Controller {

    private CountriesService service;

    public Controller(CountriesService service) {
        this.service = service;
    }


    @GetMapping(params = "date")
    public ResponseEntity<List<CountryCase>> findByDate(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date) {
        return service.findByDate(date);
    }

    @GetMapping(params = "country")
    public ResponseEntity<List<CountryCase>> findByCountry(@RequestParam String country){
        return service.findByCountry(country);
    }
}

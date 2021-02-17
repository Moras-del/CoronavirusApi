package pl.moras.coronavirusdata.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.moras.coronavirusdata.model.Case;
import pl.moras.coronavirusdata.services.CaseService;
import pl.moras.coronavirusdata.services.Sort;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cases")
public class Controller {

    private CaseService countryService;

    public Controller(CaseService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Case> getCases(@RequestParam Optional<String> country,
            @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Optional<LocalDate> from,
            @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Optional<LocalDate> to,
            @RequestParam("sortBy") Optional<Sort> sort){
        List<Case> cases = countryService.findAll().orElseThrow(()-> new RuntimeException("invalid fetch from third-party service"));
        if (country.isPresent())
            cases = countryService.findByCountry(cases, country.get());
        if (from.isPresent())
            cases = countryService.findByDateFrom(cases, from.get());
        if (to.isPresent())
            cases = countryService.findByDateTo(cases, to.get());
        if (sort.isPresent())
            cases = countryService.sortBy(cases, sort.get());
        return cases;
    }

}

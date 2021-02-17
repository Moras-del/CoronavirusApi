package pl.moras.coronavirusdata.services;

import pl.moras.coronavirusdata.model.Case;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CaseService {

    List<Case> findByDateFrom(List<Case> cases, LocalDate from);

    List<Case> findByDateTo(List<Case> cases, LocalDate to);

    List<Case> findByCountry(List<Case> cases, String country);

    List<Case> sortBy(List<Case> cases, Sort sortFunc);

    Optional<List<Case>> findAll();
}

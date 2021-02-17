package pl.moras.coronavirusdata.services;

import org.springframework.stereotype.Service;
import pl.moras.coronavirusdata.model.Case;
import pl.moras.coronavirusdata.repo.Repository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class CaseServiceImpl implements CaseService {

    private Repository repository;

    public CaseServiceImpl(Repository repository){
        this.repository = repository;
    }


    @Override
    public List<Case> findByDateFrom(List<Case> cases, LocalDate from) {
         return filter(cases, aCase->aCase.getRecordDate().isAfter(from.minusDays(1)));
    }

    @Override
    public List<Case> findByDateTo(List<Case> cases, LocalDate to) {
        return filter(cases, aCase -> aCase.getRecordDate().isBefore(to.plusDays(1)));
    }

    @Override
    public List<Case> findByCountry(List<Case> cases, String country) {
        return filter(cases, aCase -> aCase.getCountryName().equalsIgnoreCase(country));
    }

    @Override
    public List<Case> sortBy(List<Case> cases, Sort sortFunc) {
        return cases.parallelStream()
                .sorted(sortFunc)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<List<Case>> findAll() {
        try {
            List<Case> cases = repository.getCases();
            return Optional.of(cases);
        } catch (IOException e) {
            return Optional.empty();
        }
    }

    public List<Case> filter(List<Case> cases, Predicate<Case> predicate) {
        return cases.parallelStream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

}

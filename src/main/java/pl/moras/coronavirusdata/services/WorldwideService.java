package pl.moras.coronavirusdata.services;

import org.springframework.http.ResponseEntity;
import pl.moras.coronavirusdata.models.WorldwideCase;

import java.util.List;

public interface WorldwideService {

    ResponseEntity<List<WorldwideCase>> getAll();
}

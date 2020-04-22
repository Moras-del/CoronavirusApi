package pl.moras.coronavirusdata.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.moras.coronavirusdata.models.WorldwideCase;
import pl.moras.coronavirusdata.repo.Repository;

import java.io.IOException;
import java.util.List;

@Service
public class WorldwideServiceImpl implements WorldwideService {

    private Repository repository;

    public WorldwideServiceImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<List<WorldwideCase>> getAll() {
        try {
            return ResponseEntity.ok(repository.getWorldwideCases());
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}

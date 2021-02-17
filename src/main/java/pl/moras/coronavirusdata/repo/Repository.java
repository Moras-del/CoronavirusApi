package pl.moras.coronavirusdata.repo;

import pl.moras.coronavirusdata.model.Case;

import java.io.IOException;
import java.util.List;

public interface Repository {
    List<Case> getCases() throws IOException;
}

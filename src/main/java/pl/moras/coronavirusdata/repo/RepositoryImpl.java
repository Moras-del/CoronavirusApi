package pl.moras.coronavirusdata.repo;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.moras.coronavirusdata.model.Case;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class RepositoryImpl implements Repository {

    @Value("${file}")
    private String countryFilename;

    @Override
    public List<Case> getCases() throws IOException {
        List<Case> list = new ArrayList<>();
        CSVParser parser = CSVFormat.DEFAULT
                .withDelimiter(",".charAt(0))
                .withFirstRecordAsHeader()
                .parse(new FileReader(countryFilename));
        for (CSVRecord record: parser.getRecords()){
            list.add(buildCase(record));
        }
        return list;
    }

    private Case buildCase(CSVRecord record){

        return Case
                .builder()
                .recordDate(LocalDate.parse(record.get(Consts.DATE.val)))
                .countryName(record.get(Consts.COUNTRY.val))
                .confirmedCases(record.get(Consts.CONFIRMED_CASES.val))
                .recoveredCases(record.get(Consts.RECOVERED_CASES.val))
                .deaths(record.get(Consts.DEATHS.val))
                .province(record.get(Consts.PROVINCE.val))
                .build();
    }

}

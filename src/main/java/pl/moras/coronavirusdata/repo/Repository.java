package pl.moras.coronavirusdata.repo;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import pl.moras.coronavirusdata.Consts;
import pl.moras.coronavirusdata.models.CountryCase;
import pl.moras.coronavirusdata.models.WorldwideCase;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class Repository {

    public List<CountryCase> getCasesPerCountry() throws IOException {
        List<CountryCase> list = new ArrayList<>();
        CSVParser parser = CSVFormat.DEFAULT
                .withDelimiter(",".charAt(0))
                .withFirstRecordAsHeader()
                .parse(new FileReader(Consts.COUNTRY_CSV));
        for (CSVRecord record: parser.getRecords()){
            list.add(buildCountryCase(record));
        }
        return list;
    }

    public List<WorldwideCase> getWorldwideCases() throws IOException {
        List<WorldwideCase> list = new ArrayList<>();
        CSVParser parser = CSVFormat.DEFAULT
                .withDelimiter(",".charAt(0))
                .withFirstRecordAsHeader()
                .parse(new FileReader(Consts.WORLDWIDE_CSV));
        for (CSVRecord record : parser.getRecords()){
            list.add(buildWorldwideCase(record));
        }
        return list;
    }

    private WorldwideCase buildWorldwideCase(CSVRecord record) {
        return WorldwideCase
                .builder()
                .recordDate(LocalDate.parse(record.get(Consts.DATE)))
                .confirmedCases(record.get(Consts.CONFIRMED_CASES))
                .deaths(record.get(Consts.DEATHS))
                .increaseRate(record.get(Consts.INCREASE_RATE))
                .recoveredCases(record.get(Consts.RECOVERED_CASES))
                .build();
    }


    private CountryCase buildCountryCase(CSVRecord record){
        return CountryCase
                .builder()
                .countryName(record.get(Consts.COUNTRY))
                .confirmedCases(record.get(Consts.CONFIRMED_CASES))
                .deaths(record.get(Consts.DEATHS))
                .latitude(Double.parseDouble(record.get(Consts.LATITUDE)))
                .longitude(Double.parseDouble(record.get(Consts.LONGITUDE)))
                .province(record.get(Consts.PROVINCE))
                .recordDate(LocalDate.parse(record.get(Consts.DATE)))
                .recoveredCases(record.get(Consts.RECOVERED_CASES))
                .build();
    }

}

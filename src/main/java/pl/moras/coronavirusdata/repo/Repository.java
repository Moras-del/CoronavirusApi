package pl.moras.coronavirusdata.repo;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import pl.moras.coronavirusdata.models.CountryCase;

import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class Repository {

    public List<CountryCase> getCasesPerCountry() throws Exception {
        List<CountryCase> list = new ArrayList<>();
        CSVParser parse = CSVFormat.DEFAULT
                .withDelimiter(",".charAt(0))
                .withFirstRecordAsHeader()
                .parse(new FileReader("coronavirus.csv"));
        for (CSVRecord record: parse.getRecords()){
            list.add(buildCountryCase(record));
        }
        return list;
    }


    private CountryCase buildCountryCase(CSVRecord record){
        return CountryCase
                .builder()
                .countryName(record.get(CountryCase.COUNTRY))
                .confirmedCases(record.get(CountryCase.CONFIRMED_CASES))
                .deaths(record.get(CountryCase.DEATHS))
                .latitude(Double.parseDouble(record.get(CountryCase.LATITUDE)))
                .longitude(Double.parseDouble(record.get(CountryCase.LONGITUDE)))
                .province(record.get(CountryCase.PROVINCE))
                .recordDate(LocalDate.parse(record.get(CountryCase.DATE)))
                .recoveredCases(record.get(CountryCase.RECOVERED_CASES))
                .build();
    }

}

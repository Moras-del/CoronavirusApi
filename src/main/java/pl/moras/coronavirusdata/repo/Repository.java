package pl.moras.coronavirusdata.repo;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import pl.moras.coronavirusdata.models.CasesRecord;

import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class Repository {

    public List<CasesRecord> getCasesPerCountry() throws Exception {
        List<CasesRecord> list = new ArrayList<>();
        CSVParser parse = CSVFormat.DEFAULT
                .withDelimiter(",".charAt(0))
                .withFirstRecordAsHeader()
                .parse(new FileReader("coronavirus.csv"));
        for (CSVRecord record: parse.getRecords()){
            list.add(buildCountryCase(record));
        }
        return list;
    }


    private CasesRecord buildCountryCase(CSVRecord record){
        return CasesRecord
                .builder()
                .countryName(record.get(CasesRecord.COUNTRY))
                .confirmedCases(record.get(CasesRecord.CONFIRMED_CASES))
                .deaths(record.get(CasesRecord.DEATHS))
                .latitude(Double.parseDouble(record.get(CasesRecord.LATITUDE)))
                .longitude(Double.parseDouble(record.get(CasesRecord.LONGITUDE)))
                .province(record.get(CasesRecord.PROVINCE))
                .recordDate(LocalDate.parse(record.get(CasesRecord.DATE)))
                .recoveredCases(record.get(CasesRecord.RECOVERED_CASES))
                .build();
    }

}

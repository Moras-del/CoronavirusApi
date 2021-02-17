package pl.moras.coronavirusdata.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Builder
public class Case {

    private String countryName;
    private LocalDate recordDate;
    private String province;
    private String confirmedCases;
    private String recoveredCases;
    private String deaths;

}

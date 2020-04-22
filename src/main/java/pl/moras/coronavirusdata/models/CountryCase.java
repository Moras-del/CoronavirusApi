package pl.moras.coronavirusdata.models;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CountryCase {




    private String countryName;
    private LocalDate recordDate;
    private String province;
    private double latitude;
    private double longitude;
    private String confirmedCases;
    private String recoveredCases;
    private String deaths;

}

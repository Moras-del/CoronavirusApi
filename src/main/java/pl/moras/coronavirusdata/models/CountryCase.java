package pl.moras.coronavirusdata.models;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CountryCase {

    public static final String DATE = "Date";
    public static final String COUNTRY = "Country/Region";
    public static final String PROVINCE = "Province/State";
    public static final String LATITUDE = "Lat";
    public static final String LONGITUDE = "Long";
    public static final String CONFIRMED_CASES = "Confirmed";
    public static final String RECOVERED_CASES = "Recovered";
    public static final String DEATHS = "Deaths";


    private String countryName;
    private LocalDate recordDate;
    private String province;
    private double latitude;
    private double longitude;
    private String confirmedCases;
    private String recoveredCases;
    private String deaths;

}

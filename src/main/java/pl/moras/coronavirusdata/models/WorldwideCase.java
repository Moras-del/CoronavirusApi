package pl.moras.coronavirusdata.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class WorldwideCase {

    private LocalDate recordDate;
    private String confirmedCases;
    private String recoveredCases;
    private String deaths;
    private String increaseRate;

}

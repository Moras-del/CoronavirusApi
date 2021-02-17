package pl.moras.coronavirusdata.services;

import pl.moras.coronavirusdata.model.Case;

import java.util.Comparator;

public enum Sort implements Comparator<Case>  {

    deaths{
        @Override
        public int compare(Case c1, Case c2) {
            return toInt(c1.getDeaths())-toInt(c2.getDeaths());
        }
    },
    deathsD{
        @Override
        public int compare(Case c1, Case c2) {
            return toInt(c2.getDeaths())-toInt(c1.getDeaths());
        }
    },
    date{
        @Override
        public int compare(Case c1, Case c2) {
            return c1.getRecordDate().compareTo(c2.getRecordDate());
        }
    },
    dateD{
        @Override
        public int compare(Case c1, Case c2) {
            return c2.getRecordDate().compareTo(c1.getRecordDate());
        }
    },
    cases{
        @Override
        public int compare(Case c1, Case c2) {
            return toInt(c1.getConfirmedCases())-toInt(c2.getConfirmedCases());
        }
    },
    casesD{
        @Override
        public int compare(Case c1, Case c2) {
            return toInt(c2.getConfirmedCases())-toInt(c1.getConfirmedCases());
        }
    },
    recovered{
        @Override
        public int compare(Case c1, Case c2) {
            return toInt(c1.getRecoveredCases())-toInt(c2.getRecoveredCases());
        }
    },
    recoveredD{
        @Override
        public int compare(Case c1, Case c2) {
            return toInt(c2.getRecoveredCases())-toInt(c1.getRecoveredCases());
        }
    };

    int toInt(String val){
        return Integer.valueOf(val);
    }

}

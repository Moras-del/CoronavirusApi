package pl.moras.coronavirusdata.repo;

enum Consts {
    DATE("Date"),
    COUNTRY("Country/Region"),
    PROVINCE("Province/State"),
    CONFIRMED_CASES("Confirmed"),
    RECOVERED_CASES("Recovered"),
    DEATHS("Deaths");
    String val;

    Consts(String val) {
        this.val = val;
    }
}

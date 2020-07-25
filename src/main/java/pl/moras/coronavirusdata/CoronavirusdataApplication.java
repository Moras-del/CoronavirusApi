package pl.moras.coronavirusdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import pl.moras.coronavirusdata.gateways.CountryGateway;
import pl.moras.coronavirusdata.gateways.WorldwideGateway;

@SpringBootApplication
@EnableScheduling
public class CoronavirusdataApplication {

	@Autowired
	private CountryGateway countryGateway;

	@Autowired
	private WorldwideGateway worldwideGateway;

	public static void main(String[] args) {
		SpringApplication.run(CoronavirusdataApplication.class, args);
	}

	@Scheduled(cron = "0 0 * * * *")
	public void getCountryCsv() {
		countryGateway.sendRequest();
	}

	@Scheduled(cron = "0 0 * * * *")
	public void getWorldWideCsv() {
		worldwideGateway.sendRequest();
	}
}

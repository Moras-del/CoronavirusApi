package pl.moras.coronavirusdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import pl.moras.coronavirusdata.gateway.Gateway;

@SpringBootApplication
@EnableScheduling
public class CoronavirusdataApplication {

	@Autowired
	private Gateway gateway;

	public static void main(String[] args) {
		SpringApplication.run(CoronavirusdataApplication.class, args);
	}

	@Scheduled(cron = "0 52 * * * *")
	public void getCountryCsv() {
		gateway.sendRequest();
	}

}

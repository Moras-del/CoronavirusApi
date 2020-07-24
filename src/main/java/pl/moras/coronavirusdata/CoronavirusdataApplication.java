package pl.moras.coronavirusdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.integration.http.outbound.HttpRequestExecutingMessageHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import pl.moras.coronavirusdata.gateways.CountryCases;
import pl.moras.coronavirusdata.gateways.Worldwide;
import pl.moras.coronavirusdata.models.WorldwideCase;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

@SpringBootApplication
@EnableAsync
public class CoronavirusdataApplication {

	@Autowired
	private CountryCases countryCases;

	@Autowired
	private Worldwide worldwide;

	public static void main(String[] args) {
		SpringApplication.run(CoronavirusdataApplication.class, args);
	}

	@Scheduled(cron = "0 0 * * * *")
	public void getCountryCsv() {
		countryCases.getData();
	}

	@Scheduled(cron = "0 0 * * * *")
	public void getWorldWideCsv() {
		worldwide.getData();
	}
}

package pl.moras.coronavirusdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

@SpringBootApplication
@EnableAsync
public class CoronavirusdataApplication {


	public static void main(String[] args) {
		SpringApplication.run(CoronavirusdataApplication.class, args);
	}

	@Scheduled(cron = "0 0 * * * *")
	public void getCountryCsv() {
		try (BufferedInputStream in = new BufferedInputStream(new URL("https://raw.githubusercontent.com/datasets/covid-19/master/data/time-series-19-covid-combined.csv").openStream());
			 FileOutputStream fileOutputStream = new FileOutputStream("countrycases.csv")){
			byte[] buffer = new byte[1024];
			int read;
			while ((read = in.read(buffer, 0, 1024)) != -1)
				fileOutputStream.write(buffer, 0, read);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Scheduled(cron = "0 0 * * * *")
	public void getWorldWideCsv(){
		try(BufferedInputStream in = new BufferedInputStream(new URL("https://raw.githubusercontent.com/datasets/covid-19/master/data/worldwide-aggregated.csv").openStream());
			FileOutputStream fileOutputStream = new FileOutputStream("worldwidecases.csv")){
			byte[] buffer = new byte[1024];
			int read;
			while ((read = in.read(buffer, 0, 1024))!=-1)
				fileOutputStream.write(buffer, 0, read);
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}

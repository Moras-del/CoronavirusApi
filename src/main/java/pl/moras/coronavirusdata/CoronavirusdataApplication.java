package pl.moras.coronavirusdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoronavirusdataApplication {


	public static void main(String[] args) throws Exception {
//		try (BufferedInputStream in = new BufferedInputStream(new URL("https://raw.githubusercontent.com/datasets/covid-19/master/data/time-series-19-covid-combined.csv").openStream());
//			 FileOutputStream fileOutputStream = new FileOutputStream("coronavirus.csv")){
//			 byte[] buffer = new byte[1024];
//			 int read;
//			 while ((read = in.read(buffer, 0, 1024)) != -1)
//			 	fileOutputStream.write(buffer, 0, read);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		SpringApplication.run(CoronavirusdataApplication.class, args);
	}

}

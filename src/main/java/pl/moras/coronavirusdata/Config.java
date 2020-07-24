package pl.moras.coronavirusdata;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath:beans.xml"})
public class Config {
}

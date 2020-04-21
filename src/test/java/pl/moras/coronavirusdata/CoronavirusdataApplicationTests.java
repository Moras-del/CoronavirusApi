package pl.moras.coronavirusdata;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CoronavirusdataApplicationTests {

	@Test
	void contextLoads() {




	}

	@Getter
	@Setter
	@AllArgsConstructor
	class test{
		String Name, Sex, Age, Height, Weight;
	}

}

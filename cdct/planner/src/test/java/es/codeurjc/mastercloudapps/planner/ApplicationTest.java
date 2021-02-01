package es.codeurjc.mastercloudapps.planner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode;
import org.springframework.web.client.RestTemplate;

import es.codeurjc.mastercloudapps.planner.models.LandscapeResponse;

@SpringBootTest
@AutoConfigureStubRunner(ids={"jgarciago2020:toposervice:+:stubs:8080"}, stubsMode = StubsMode.LOCAL)
	public class ApplicationTest {

	@Test
	void verify_topo_service_for_Madrid() {
		RestTemplate restTemplate = new RestTemplate();

		LandscapeResponse response = restTemplate.getForObject("http://localhost:8080/api/topographicdetails/Madrid", LandscapeResponse.class);

		assertEquals("Madrid", response.getId());
		assertEquals("Flat", response.getLandscape());
	}
	
	@Test
	void verify_topo_service_for_BCN() {
		RestTemplate restTemplate = new RestTemplate();

		LandscapeResponse response = restTemplate.getForObject("http://localhost:8080/api/topographicdetails/Barcelona", LandscapeResponse.class);

		assertEquals("Barcelona", response.getId());
		assertEquals("Flat", response.getLandscape());
	}

}

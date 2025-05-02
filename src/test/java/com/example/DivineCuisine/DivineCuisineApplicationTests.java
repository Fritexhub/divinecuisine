package com.example.DivineCuisine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DivineCuisineApplicationTests {
	@LocalServerPort
	private int port;
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testHomePageIsAccessible() {
		String baseUrl = "http://localhost:" + port + "/";
		ResponseEntity<String> response = restTemplate.getForEntity(baseUrl, String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void testLoginAndAccessProfile() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		HttpEntity<String> loginRequest = new HttpEntity<>("username=user@example.com&password=1234", headers);
		ResponseEntity<String> loginResponse = restTemplate.postForEntity("http://localhost:" + port + "/login", loginRequest, String.class);
	}
}

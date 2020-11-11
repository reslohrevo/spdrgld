//package com.eigenholser.outrider.spdrgld;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class SpdrGldApplicationTests {
//
//	@Test
//	void contextLoads() {
//	}
//
//}

/****************************************************************************************
SMOKE TEST
*****************************************************************************************/
//package com.eigenholser.outrider.spdrgld;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.junit.jupiter.api.Test;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//public class SpdrGldApplicationTests {
//
//	@Autowired
//	private SpdrGldController controller;
//
//	@Test
//	public void contextLoads() throws Exception {
//		assertThat(controller).isNotNull();
//	}
//}

/****************************************************************************************
WEB TEST
*****************************************************************************************/
package com.eigenholser.outrider.spdrgld;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpdrGldApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private SpdrGldController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
	
	@Test
	public void singleDateRequestTest() throws Exception {
		String url = "http://localhost:" + port + "/spdrgld/2004-11-18";
		assertThat(this.restTemplate.getForObject(url, String.class))
				.contains("2004");
	}
}
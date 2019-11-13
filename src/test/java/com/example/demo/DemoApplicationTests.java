package com.example.demo;

import javax.annotation.Resource;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.User;

@SpringBootTest
class DemoApplicationTests {

	private static ConfigurableApplicationContext server;
	
	@Resource(name="restTemplate")
	private RestTemplate restTemplate;
	
    @BeforeAll
    public static void startServer() {
    	System.out.println("*********************************");
    	server = SpringApplication.run(DemoApplication.class);
    }

    @AfterAll
    public static void closeServer() {
    	System.out.println("------------------------------------------");
    	server.close();
    }
    
	@Test
	void test01() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, Object> params= new LinkedMultiValueMap<>();
		params.add("type", 1);
		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(params, headers);
		String url="http://127.0.0.1:8080/user2";
		ResponseEntity<User> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, User.class);
		headers = response.getHeaders();
		System.out.println(headers.get("content-type"));
		User body = response.getBody();
		System.out.println(body.toString());
	}

	@Test
	void test02() {
		String url="http://127.0.0.1:8080/user2";
		ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);
		User body = response.getBody();
		System.out.println(body.toString());
	}

	@Test
	void test03() {
		String url="http://127.0.0.1:8080/user2";
		User response = restTemplate.getForObject(url, User.class);
		System.out.println(response.toString());
	}

	@Test
	void test04() {
		String url="http://127.0.0.1:8080/user2";
		String response = restTemplate.getForObject(url, String.class);
		System.out.println(response);
	}

}

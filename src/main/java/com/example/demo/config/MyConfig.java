package com.example.demo.config;

import java.io.IOException;
import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate; 

@Configuration
public class MyConfig {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
    	builder.setConnectTimeout(Duration.ofSeconds(60));
        RestTemplate restTemplate=builder.build();
        restTemplate.getInterceptors().add(new ClientHttpRequestInterceptor() {
			
			@Override
			public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
					throws IOException {
				ClientHttpResponse response = execution.execute(request, body);
				response.getHeaders().set("content-type", "application/json");
				return response;
			}
		});
        return restTemplate;
    }  
}

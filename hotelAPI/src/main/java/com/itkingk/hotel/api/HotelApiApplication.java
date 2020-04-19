package com.itkingk.hotel.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author kingk
 * @date 2020/4/18 19:22
 */
@SpringBootApplication
@EnableEurekaClient
public class HotelApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(HotelApiApplication.class, args);
	}
}

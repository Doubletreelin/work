package com.ifeng.bigtrade.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
//@EnableDiscoveryClient
public class BigtradeZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(BigtradeZuulApplication.class, args);
    }

}

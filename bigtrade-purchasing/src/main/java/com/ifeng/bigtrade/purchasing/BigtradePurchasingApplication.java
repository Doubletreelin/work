package com.ifeng.bigtrade.purchasing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import bigtrade.logger.BigtradeLogger;

@EnableTransactionManagement
@EnableWebMvc
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.ifeng.bigtrade.purchasing.mapper")
@RefreshScope
public class BigtradePurchasingApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(BigtradePurchasingApplication.class, args);
		BigtradeLogger.initServerName("bigtrade-purchasing");
	}
}
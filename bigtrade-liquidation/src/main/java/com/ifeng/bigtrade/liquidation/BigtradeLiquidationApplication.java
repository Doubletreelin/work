package com.ifeng.bigtrade.liquidation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import bigtrade.logger.BigtradeLogger;

@EnableDiscoveryClient
@EnableTransactionManagement
@EnableWebMvc
@SpringBootApplication
@MapperScan("com.ifeng.bigtrade.liquidation.mapper")
@RefreshScope
public class BigtradeLiquidationApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(BigtradeLiquidationApplication.class, args);
		BigtradeLogger.initServerName("bigtrade-liquidation");
	}
}
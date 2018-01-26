package com.ifeng.bigtrade.trade;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import bigtrade.logger.BigtradeLogger;

@EnableTransactionManagement
// 开启Spring事务管理，相当于XMl中的<tx:*>
@EnableWebMvc
@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
@MapperScan("com.ifeng.bigtrade.trade.mapper")
public class BigtradeTradeApplication
{
	public static void main(String[] args)
	{
		/*
		 * SpringApplication 从main方法启动spring应用的类 Spring Boot的默认将设置项目路径直接设为根路径 设置自己的项目路径 -在classpath下的
		 * application.properties 或者 application.yaml 文件中设置即可11
		 */

		SpringApplication.run(BigtradeTradeApplication.class, args);
		BigtradeLogger.initServerName("bigtrade-tradeManage");
		System.out.println("当前版本为1.0.0.2017112801");
	}
}

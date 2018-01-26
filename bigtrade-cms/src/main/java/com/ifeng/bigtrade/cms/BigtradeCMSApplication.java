/*    */ package com.ifeng.bigtrade.cms;
/*    */ 
/*    */ import bigtrade.logger.BigtradeLogger;
/*    */ import java.io.PrintStream;
/*    */ import org.mybatis.spring.annotation.MapperScan;
/*    */ import org.springframework.boot.SpringApplication;
/*    */ import org.springframework.boot.autoconfigure.SpringBootApplication;
/*    */ import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/*    */ import org.springframework.cloud.context.config.annotation.RefreshScope;
/*    */ import org.springframework.transaction.annotation.EnableTransactionManagement;
/*    */ import org.springframework.web.servlet.config.annotation.EnableWebMvc;
/*    */ 
/*    */ @EnableTransactionManagement
/*    */ @EnableWebMvc
/*    */ @SpringBootApplication
/*    */ @EnableDiscoveryClient
/*    */ @RefreshScope
/*    */ @MapperScan({"com.ifeng.bigtrade.cms.mapper"})
/*    */ public class BigtradeCMSApplication
/*    */ {
/*    */   public static void main(String[] args)
/*    */   {
/* 29 */     SpringApplication.run(BigtradeCMSApplication.class, args);
/* 30 */     BigtradeLogger.initServerName("bigtrade-cms");
/* 31 */     System.out.println("当前版本为1.0.0.2017112001");
/*    */   }
/*    */ }

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.BigtradeCMSApplication
 * JD-Core Version:    0.6.2
 */
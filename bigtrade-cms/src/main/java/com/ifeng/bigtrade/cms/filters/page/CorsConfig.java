/*    */ package com.ifeng.bigtrade.cms.filters.page;
/*    */ 
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.web.servlet.config.annotation.CorsRegistration;
/*    */ import org.springframework.web.servlet.config.annotation.CorsRegistry;
/*    */ import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/*    */ 
/*    */ @Configuration
/*    */ public class CorsConfig extends WebMvcConfigurerAdapter
/*    */ {
/*    */   public void addCorsMappings(CorsRegistry registry)
/*    */   {
/* 15 */     registry.addMapping("/**").allowedOrigins(new String[] { "*" }).allowCredentials(true)
/* 16 */       .allowedMethods(new String[] { "GET", "POST", "DELETE", "PUT" })
/* 16 */       .maxAge(3600L);
/*    */   }
/*    */ }

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.filters.page.CorsConfig
 * JD-Core Version:    0.6.2
 */
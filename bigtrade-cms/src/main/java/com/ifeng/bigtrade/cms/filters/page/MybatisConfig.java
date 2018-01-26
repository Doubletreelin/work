/*    */ package com.ifeng.bigtrade.cms.filters.page;
/*    */ 
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import java.util.Properties;
/*    */ import org.springframework.context.annotation.Bean;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ 
/*    */ @Configuration
/*    */ public class MybatisConfig
/*    */ {
/*    */   @Bean
/*    */   public PageHelper pageHelper()
/*    */   {
/* 15 */     PageHelper pageHelper = new PageHelper();
/* 16 */     Properties p = new Properties();
/* 17 */     p.setProperty("offsetAsPageNum", "true");
/* 18 */     p.setProperty("rowBoundsWithCount", "true");
/* 19 */     p.setProperty("reasonable", "true");
/* 20 */     pageHelper.setProperties(p);
/* 21 */     return pageHelper;
/*    */   }
/*    */ }

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.filters.page.MybatisConfig
 * JD-Core Version:    0.6.2
 */
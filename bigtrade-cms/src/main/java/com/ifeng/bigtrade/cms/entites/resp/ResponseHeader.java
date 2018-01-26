/*     */ package com.ifeng.bigtrade.cms.entites.resp;
/*     */ 
/*     */ import java.sql.Timestamp;
/*     */ import java.util.UUID;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ 
/*     */ public class ResponseHeader
/*     */ {
/*     */   private String serviceName;
/*     */   private String sender;
/*     */   private Timestamp createTime;
/*  25 */   private String provider = "bigtrade-cms";
/*     */   private Integer statusCode;
/*     */   private String message;
/*     */   private String id;
/*     */ 
/*     */   public ResponseHeader()
/*     */   {
/*     */   }
/*     */ 
/*     */   public ResponseHeader(HttpServletRequest request, Integer code, String message)
/*     */   {
/*  45 */     this.serviceName = request.getServletPath();
/*  46 */     this.sender = request.getParameter("sender");
/*  47 */     this.createTime = new Timestamp(System.currentTimeMillis());
/*  48 */     this.statusCode = code;
/*  49 */     this.message = message;
/*  50 */     this.id = UUID.randomUUID().toString();
/*     */   }
/*     */ 
/*     */   public String getServiceName()
/*     */   {
/*  55 */     return this.serviceName;
/*     */   }
/*     */ 
/*     */   public void setServiceName(String serviceName)
/*     */   {
/*  60 */     this.serviceName = serviceName;
/*     */   }
/*     */ 
/*     */   public String getSender()
/*     */   {
/*  65 */     return this.sender;
/*     */   }
/*     */ 
/*     */   public void setSender(String sender)
/*     */   {
/*  70 */     this.sender = sender;
/*     */   }
/*     */ 
/*     */   public Timestamp getCreateTime()
/*     */   {
/*  75 */     return this.createTime;
/*     */   }
/*     */ 
/*     */   public void setCreateTime(Timestamp createTime)
/*     */   {
/*  80 */     this.createTime = createTime;
/*     */   }
/*     */ 
/*     */   public String getProvider()
/*     */   {
/*  85 */     return this.provider;
/*     */   }
/*     */ 
/*     */   public void setProvider(String provider)
/*     */   {
/*  90 */     this.provider = provider;
/*     */   }
/*     */ 
/*     */   public Integer getStatusCode()
/*     */   {
/*  95 */     return this.statusCode;
/*     */   }
/*     */ 
/*     */   public void setStatusCode(Integer statusCode)
/*     */   {
/* 100 */     this.statusCode = statusCode;
/*     */   }
/*     */ 
/*     */   public String getMessage()
/*     */   {
/* 105 */     return this.message;
/*     */   }
/*     */ 
/*     */   public void setMessage(String message)
/*     */   {
/* 110 */     this.message = message;
/*     */   }
/*     */ 
/*     */   public String getId()
/*     */   {
/* 115 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(String id)
/*     */   {
/* 120 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 126 */     return "ResponseHeader [serviceName=" + this.serviceName + ",sender=" + this.sender + ",createTime=" + this.createTime + ",provider=" + this.provider + ",statusCode=" + this.statusCode + ",message=" + this.message + ",ID=" + this.id + "]";
/*     */   }
/*     */ }

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.entites.resp.ResponseHeader
 * JD-Core Version:    0.6.2
 */
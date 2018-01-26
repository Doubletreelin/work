/*    */ package com.ifeng.bigtrade.cms.exception;
/*    */ 
/*    */ public class CommonException extends Exception
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String message;
/*    */   private Integer code;
/*    */ 
/*    */   public String getMessage()
/*    */   {
/* 18 */     return this.message;
/*    */   }
/*    */ 
/*    */   public void setMessage(String message)
/*    */   {
/* 23 */     this.message = message;
/*    */   }
/*    */ 
/*    */   public Integer getCode()
/*    */   {
/* 28 */     return this.code;
/*    */   }
/*    */ 
/*    */   public void setCode(Integer code)
/*    */   {
/* 33 */     this.code = code;
/*    */   }
/*    */ 
/*    */   public CommonException(String message, Integer code)
/*    */   {
/* 39 */     this.message = message;
/* 40 */     this.code = code;
/*    */   }
/*    */ 
/*    */   public CommonException()
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.exception.CommonException
 * JD-Core Version:    0.6.2
 */
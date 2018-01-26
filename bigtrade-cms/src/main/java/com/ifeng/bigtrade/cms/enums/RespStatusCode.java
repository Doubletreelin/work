/*    */ package com.ifeng.bigtrade.cms.enums;
/*    */ 
/*    */ public enum RespStatusCode
/*    */ {
/*  8 */   Succ(2000, "操作成功"), Error(3000, "操作异常"), ParamNull(4001, "必填参数为空"), ObjectNull(4002, "请求数据为空"), ParamError(4003, "参数格式错误"), Exception(5000, "访问异常");
/*    */ 
/*    */   private int id;
/*    */   private String name;
/*    */ 
/*    */   public static String getName(int key)
/*    */   {
/* 17 */     for (RespStatusCode c : values())
/*    */     {
/* 19 */       if (c.getId() == key)
/*    */       {
/* 21 */         return c.name;
/*    */       }
/*    */     }
/* 24 */     return null;
/*    */   }
/*    */ 
/*    */   private RespStatusCode(int id, String name)
/*    */   {
/* 29 */     this.id = id;
/* 30 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public int getId()
/*    */   {
/* 35 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setKey(int Id)
/*    */   {
/* 40 */     this.id = Id;
/*    */   }
/*    */ 
/*    */   public String getName()
/*    */   {
/* 45 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setName(String name)
/*    */   {
/* 50 */     this.name = name;
/*    */   }
/*    */ }

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.enums.RespStatusCode
 * JD-Core Version:    0.6.2
 */
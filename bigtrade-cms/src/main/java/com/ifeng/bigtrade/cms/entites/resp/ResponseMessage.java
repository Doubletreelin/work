/*    */ package com.ifeng.bigtrade.cms.entites.resp;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ 
/*    */ public class ResponseMessage
/*    */ {
/*    */   private ResponseHeader header;
/*    */   private HashMap<String, Object> body;
/*    */ 
/*    */   public ResponseMessage(ResponseHeader header, HashMap<String, Object> body)
/*    */   {
/* 19 */     this.header = header;
/* 20 */     this.body = body;
/*    */   }
/*    */ 
/*    */   public ResponseHeader getHeader()
/*    */   {
/* 25 */     return this.header;
/*    */   }
/*    */ 
/*    */   public void setHeader(ResponseHeader header)
/*    */   {
/* 30 */     this.header = header;
/*    */   }
/*    */ 
/*    */   public HashMap<String, Object> getBody()
/*    */   {
/* 35 */     return this.body;
/*    */   }
/*    */ 
/*    */   public void setBody(HashMap<String, Object> body)
/*    */   {
/* 40 */     this.body = body;
/*    */   }
/*    */ }

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.entites.resp.ResponseMessage
 * JD-Core Version:    0.6.2
 */
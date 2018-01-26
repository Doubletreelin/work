/*    */ package com.ifeng.bigtrade.cms.exception;
/*    */ 
/*    */ import com.ifeng.bigtrade.cms.entites.resp.ResponseHeader;
/*    */ import com.ifeng.bigtrade.cms.entites.resp.ResponseMessage;
/*    */ import com.ifeng.bigtrade.cms.enums.RespStatusCode;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.apache.log4j.LogManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import org.springframework.http.HttpStatus;
/*    */ import org.springframework.validation.BindException;
/*    */ import org.springframework.validation.FieldError;
/*    */ import org.springframework.web.bind.annotation.ExceptionHandler;
/*    */ import org.springframework.web.bind.annotation.ResponseStatus;
/*    */ import org.springframework.web.bind.annotation.RestControllerAdvice;
/*    */ 
/*    */ @RestControllerAdvice
/*    */ public class WebExceptionHandler
/*    */ {
/* 23 */   protected Logger logger = LogManager.getLogger(WebExceptionHandler.class);
/*    */ 
/*    */   @ExceptionHandler({Exception.class})
/*    */   @ResponseStatus(HttpStatus.BAD_REQUEST)
/*    */   public ResponseMessage globalException(Exception ex, HttpServletRequest request)
/*    */   {
/* 36 */     ResponseHeader header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.Exception.getId()), ex.getMessage());
/* 37 */     return new ResponseMessage(header, null);
/*    */   }
/*    */ 
/*    */   @ExceptionHandler({CommonException.class})
/*    */   @ResponseStatus(HttpStatus.BAD_REQUEST)
/*    */   public ResponseMessage ClassNotFindException(CommonException ex, HttpServletRequest request)
/*    */   {
/* 51 */     ResponseHeader header = new ResponseHeader(request, ex.getCode(), ex.getMessage());
/* 52 */     return new ResponseMessage(header, null);
/*    */   }
/*    */ 
/*    */   @ExceptionHandler({BindException.class})
/*    */   @ResponseStatus(HttpStatus.BAD_REQUEST)
/*    */   public ResponseMessage BindExceptionException(BindException ex, HttpServletRequest request)
/*    */   {
/* 67 */     String message = "";
/* 68 */     List error = ex.getFieldErrors();
/* 69 */     for (int i = 0; i < error.size(); i++)
/*    */     {
/* 71 */       FieldError e = (FieldError)error.get(i);
/* 72 */       message = message + e.getField() + e.getDefaultMessage() + ",";
/*    */     }
/* 74 */     message = message.substring(0, message.length() - 1);
/* 75 */     return new ResponseMessage(new ResponseHeader(request, Integer.valueOf(RespStatusCode.ParamNull.getId()), message), null);
/*    */   }
/*    */ }

/* Location:           E:\项目\bigtrade项目\cms\bigtrade-cms\BOOT-INF\classes\
 * Qualified Name:     com.ifeng.bigtrade.cms.exception.WebExceptionHandler
 * JD-Core Version:    0.6.2
 */
package com.ifeng.bigtrade.trade.exception;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ifeng.bigtrade.trade.entites.resp.ResponseHeader;
import com.ifeng.bigtrade.trade.entites.resp.ResponseMessage;
import com.ifeng.bigtrade.trade.enums.RespStatusCode;

@RestControllerAdvice
public class WebExceptionHandler
{
	protected Logger logger = LogManager.getLogger(WebExceptionHandler.class);

	/**
	 * 全局异常处理
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseMessage globalException(Exception ex, HttpServletRequest request)
	{
		ResponseHeader header = new ResponseHeader(request, RespStatusCode.Exception.getId(), ex.getMessage());
		return new ResponseMessage(header, null);
	}

	/**
	 * 自定义通用异常处理
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value = CommonException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseMessage ClassNotFindException(CommonException ex, HttpServletRequest request)
	{
		ResponseHeader header = new ResponseHeader(request, ex.getCode(), ex.getMessage());
		return new ResponseMessage(header, null);
	}

	/**
	 * 实体验证异常捕获
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value =
	{ BindException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseMessage BindExceptionException(BindException ex, HttpServletRequest request)
	{
		String message = "";
		List<FieldError> error = ex.getFieldErrors();
		for (int i = 0; i < error.size(); i++)
		{
			FieldError e = error.get(i);
			message = message + e.getField() + e.getDefaultMessage() + ",";
		}
		message = message.substring(0, message.length() - 1);
		return new ResponseMessage(new ResponseHeader(request, RespStatusCode.ParamNull.getId(), message), null);
	}
}

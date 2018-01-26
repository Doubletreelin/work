package com.ifeng.bigtrade.redis.controller;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 关于科目的操作Controller
 * 
 * @author shaolin
 *
 */
@RestController
@RequestMapping("/test")
public class TestController
{
	@RequestMapping(path = "/test")
	@Cacheable(value = "String", key = "'test'")
	public String test() throws Exception
	{
		return "test";
	}

	@RequestMapping(path = "/test2")
	@CachePut(value = "String", key = "'test'")
	public String test2() throws Exception
	{
		return "test2";
	}

	@RequestMapping(path = "/test3")
	// @Cacheable()
	public String test3() throws Exception
	{
		return "test2";
	}
}

package com.ifeng.bigtrade.redis.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(rollbackFor =
{ Exception.class, RuntimeException.class })
public class TestService
{
	
}

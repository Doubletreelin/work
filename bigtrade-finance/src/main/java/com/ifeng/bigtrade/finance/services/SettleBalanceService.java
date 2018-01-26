package com.ifeng.bigtrade.finance.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor =
{ Exception.class, RuntimeException.class })
public class SettleBalanceService
{

}

package com.ifeng.bigtrade.trade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifeng.bigtrade.trade.entites.SystemStatus;
import com.ifeng.bigtrade.trade.mapper.SystemStatusMapper;
import com.ifeng.bigtrade.trade.service.SystemStatusService;

@Transactional(rollbackFor =
{ Exception.class, RuntimeException.class })
@Service
public class SystemStatusServiceImpl implements SystemStatusService
{
	@Autowired
	private SystemStatusMapper systemStatusMapper;

	@Override
	public SystemStatus getSystemStatus() throws Exception
	{
		List<SystemStatus> list = systemStatusMapper.selectByExample(null);
		if (list != null && list.size() == 1)
		{
			return list.get(0);
		}
		return null;
	}

}

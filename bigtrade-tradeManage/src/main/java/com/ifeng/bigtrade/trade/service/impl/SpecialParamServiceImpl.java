package com.ifeng.bigtrade.trade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifeng.bigtrade.trade.entites.SpecialParam;
import com.ifeng.bigtrade.trade.entites.SpecialParamExample;
import com.ifeng.bigtrade.trade.mapper.SpecialParamMapper;
import com.ifeng.bigtrade.trade.service.SpecialParamService;

@Transactional(rollbackFor =
{ Exception.class, RuntimeException.class })
@Service
public class SpecialParamServiceImpl implements SpecialParamService
{
	@Autowired
	private SpecialParamMapper specialParamMapper;

	@Override
	public SpecialParam getCommodityCharge(Long userId, Long cid) throws Exception
	{
		SpecialParamExample example = new SpecialParamExample();
		example.createCriteria().andUserIdEqualTo(userId).andCommodityIdEqualTo(cid);
		List<SpecialParam> list = specialParamMapper.selectByExample(example);
		if (list != null && list.size() == 1)
		{
			return list.get(0);
		} 
		return null;
	}

}

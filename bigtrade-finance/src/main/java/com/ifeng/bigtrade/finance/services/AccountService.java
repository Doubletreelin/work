package com.ifeng.bigtrade.finance.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ifeng.bigtrade.finance.entites.FAccountItem;
import com.ifeng.bigtrade.finance.entites.FAccountItemExample;
import com.ifeng.bigtrade.finance.entites.FAccountItemExample.Criteria;
import com.ifeng.bigtrade.finance.entites.enumf.EAccountLevel;
import com.ifeng.bigtrade.finance.entites.enumf.EDCflag;
import com.ifeng.bigtrade.finance.entites.enumf.ERespCode;
import com.ifeng.bigtrade.finance.entites.enumf.ERespMessage;
import com.ifeng.bigtrade.finance.entites.resp.ResponseHeader;
import com.ifeng.bigtrade.finance.entites.resp.ResponseMessage;
import com.ifeng.bigtrade.finance.filters.PageReq;
import com.ifeng.bigtrade.finance.mapper.FAccountItemMapper;
import com.ifeng.bigtrade.finance.tools.CommUtil;

@Service
@Transactional(rollbackFor =
{ Exception.class, RuntimeException.class })
public class AccountService
{
	@Autowired
	FAccountItemMapper accountMapper;

	/**
	 * 增加凭证
	 * 
	 * @param voucher
	 * @return
	 */
	public int addAccountItem(FAccountItem accountItem)
	{
		return this.accountMapper.insertSelective(accountItem);
	}

	/**
	 * 根据example更新accountItem
	 * 
	 * @param accountItem
	 * @param example
	 * @return
	 */
	public int updateAccountItemByExample(FAccountItem accountItem, FAccountItemExample example)
	{
		return this.accountMapper.updateByExampleSelective(accountItem, example);
	}

	/**
	 * 根据example删除AccountItem
	 * 
	 * @param example
	 * @return
	 */
	public int deleteAccountItemByExample(FAccountItemExample example)
	{
		return this.accountMapper.deleteByExample(example);
	}

	/**
	 * 根据id获取Account
	 * 
	 * @param id
	 * @return FAccount
	 */
	public FAccountItem getAccountById(Long id)
	{
		return this.accountMapper.selectByPrimaryKey(id);
	}

	/**
	 * 根据code获取Account
	 * 
	 * @param code
	 * @return FAccount
	 */
	public FAccountItem getAccountByCode(String code)
	{
		return this.accountMapper.selectAccountByCode(code);
	}

	/**
	 * 根据example获取
	 * 
	 * @param example
	 * @return
	 */
	public List<FAccountItem> getAccountByExample(FAccountItemExample example)
	{
		return this.accountMapper.selectByExample(example);
	}

	/**
	 * 根据条件获取条数
	 * 
	 * @param example
	 * @return
	 */
	public Long getAccountContByExample(FAccountItemExample example)
	{
		return this.accountMapper.countByExample(example);
	}

	/**
	 * 增加科目
	 * 
	 * @param request
	 * @param code 科目代码
	 * @param name 科目姓名
	 * @param dCFlag 借贷方向
	 * @param accountLevel 科目级别
	 * @param canDelete 是否能删除
	 * @param higherCode 上级科目
	 * @return ResponseMessage
	 * @throws Exception
	 */
	public ResponseMessage addAccount(HttpServletRequest request, String code, String name, String dCFlag,
			Integer accountLevel, boolean canDelete, String higherCode) throws Exception
	{
		FAccountItem account = new FAccountItem();
		account.setAddTime(new Date());
		account.setCode(code);
		account.setdCFlag(dCFlag);
		account.setDeleteStatus(false);
		account.setHigherCode(higherCode);
		account.setName(name);
		account.setAccountLevel(accountLevel);
		account.setCanDelete(canDelete);
		this.addAccountItem(account);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("accountItem", account);
		ResponseMessage resp = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ),
				rmap);
		return resp;
	}

	/**
	 * 更新科目
	 * 
	 * @param request
	 * @param code 科目代码
	 * @param name 科目姓名
	 * @param dCFlag 借贷方向
	 * @param accountLevel 科目级别
	 * @param higherCode 上级科目
	 * @return ResponseMessage
	 * @throws Exception
	 */
	public ResponseMessage updateAccount(HttpServletRequest request, Long id, String code, String name, String dCFlag,
			Integer accountLevel, String higherCode) throws Exception
	{
		FAccountItem account = new FAccountItem();// 需要更新的内容
		account.setCode(code);
		account.setName(name);
		account.setdCFlag(dCFlag);
		account.setAccountLevel(accountLevel);
		account.setHigherCode(higherCode);
		FAccountItemExample example = new FAccountItemExample();// 更新条件
		Criteria c = example.createCriteria();
		c.andIdEqualTo(id);
		int count = this.updateAccountItemByExample(account, example);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("count", count);
		ResponseMessage resp = new ResponseMessage(CommUtil.respByCount(request, count), rmap);
		return resp;
	}

	/**
	 * 批量删除科目
	 * 
	 * @param request
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ResponseMessage deleteAccountBatch(HttpServletRequest request, List<Long> id) throws Exception
	{
		int count = this.deleteAccountBatch(id);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("deleteCount", count);
		ResponseMessage resp = new ResponseMessage(CommUtil.respByCount(request, count), rmap);
		return resp;
	}

	/**
	 * 批量删除科目
	 * 
	 * @param request
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteAccountBatch(List<Long> id) throws Exception
	{
		FAccountItemExample example = new FAccountItemExample();
		Criteria c = example.createCriteria();
		c.andIdIn(id);
		c.andCanDeleteEqualTo(true);
		int count = this.accountMapper.deleteByExample(example);
		return count;
	}

	/**
	 * 增加商品的科目
	 * 
	 * @param request
	 * @param systemid
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public ResponseMessage addAccountOfCommodity(HttpServletRequest request, String systemid, String code)
			throws Exception
	{
		FAccountItemExample example = new FAccountItemExample();
		Criteria c = example.createCriteria();
		c.andCodeEqualTo("202" + systemid);
		List<FAccountItem> level2 = this.getAccountByExample(example);
		if (level2 != null && level2.size() > 0)
		{
			FAccountItem account = new FAccountItem();
			account.setAccountLevel(EAccountLevel.level3.getId());
			account.setAddTime(new Date());
			account.setCanDelete(false);
			account.setCode(code);
			account.setdCFlag(EDCflag.C.getCode());
			account.setDeleteStatus(false);
			account.setHigherCode(level2.get(0).getCode() + code);
			account.setName(level2.get(0).getName() + code);
			this.addAccountItem(account);
			HashMap<String, Object> rmap = new HashMap<>();
			rmap.put("account", account);
			ResponseMessage resp = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ),
					rmap);
			return resp;
		} else
		{
			ResponseMessage resp = new ResponseMessage(new ResponseHeader(request, ERespCode.Error, "上级科目不存在"));
			return resp;
		}
	}

	/**
	 * 增加交易会员科目
	 * 
	 * @param request
	 * @param firmno 交易会员账号
	 * @return
	 * @throws Exception
	 */
	public ResponseMessage addAccountItemOfFirm(HttpServletRequest request, String firmno) throws Exception
	{
		FAccountItem account = new FAccountItem();
		account.setAccountLevel(EAccountLevel.level3.getId());
		account.setAddTime(new Date());
		account.setCanDelete(false);
		account.setCode("20100" + firmno);
		account.setdCFlag(EDCflag.C.getCode());
		account.setDeleteStatus(false);
		account.setHigherCode("20100");
		account.setName("应付账款" + firmno);
		this.addAccountItem(account);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("account", account);
		ResponseMessage resp = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ),
				rmap);
		return resp;
	}

	/**
	 * 查询科目信息里诶包
	 * 
	 * @param request
	 * @param code 科目代码
	 * @param name 科目名称
	 * @param dcflag 借贷方向
	 * @param accountlevel 科目级别
	 * @param pagereq 分页参数
	 * @return
	 * @throws Exception
	 */
	public ResponseMessage selectAccount(HttpServletRequest request, String code, String name, String dcflag,
			Integer accountlevel, PageReq pagereq) throws Exception
	{
		// 分页
		PageHelper.startPage(pagereq.getPageNum(), pagereq.getPageSize(), pagereq.getOrderStr());
		// 组织查询条件
		FAccountItemExample example = new FAccountItemExample();
		Criteria c = example.createCriteria();
		if (CommUtil.isNotNull(code))
		{
			c.andCodeEqualTo(code);
		}
		if (CommUtil.isNotNull(name))
		{
			c.andNameEqualTo(name);
		}
		if (CommUtil.isNotNull(dcflag))
		{
			c.andDCFlagEqualTo(dcflag);
		}
		if (CommUtil.isNotNull(accountlevel))
		{
			c.andAccountLevelEqualTo(accountlevel);
		}
		// 查询
		List<FAccountItem> resplist = this.accountMapper.selectByExample(example);
		// 返回
		PageInfo<FAccountItem> page = new PageInfo<>(resplist);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("page", page);
		ResponseMessage resp = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ),
				rmap);
		return resp;
	}

	/**
	 * 根据id获取科目
	 * 
	 * @param request
	 * @param id 用户id
	 * @return
	 * @throws Exception
	 * @author shaolin
	 * @time 2017年9月5日 上午10:51:54
	 */
	public ResponseMessage selectAccountById(HttpServletRequest request, Long id) throws Exception
	{
		FAccountItem account = this.getAccountById(id);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("result", account);
		ResponseMessage resp = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ),
				rmap);
		return resp;
	}
}

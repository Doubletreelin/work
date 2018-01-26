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
import com.ifeng.bigtrade.finance.entites.FLedgerField;
import com.ifeng.bigtrade.finance.entites.FSummary;
import com.ifeng.bigtrade.finance.entites.FSummaryExample;
import com.ifeng.bigtrade.finance.entites.FSummaryExample.Criteria;
import com.ifeng.bigtrade.finance.entites.enumf.ERespCode;
import com.ifeng.bigtrade.finance.entites.enumf.ERespMessage;
import com.ifeng.bigtrade.finance.entites.resp.ResponseHeader;
import com.ifeng.bigtrade.finance.entites.resp.ResponseMessage;
import com.ifeng.bigtrade.finance.filters.PageReq;
import com.ifeng.bigtrade.finance.mapper.FLedgerFieldMapper;
import com.ifeng.bigtrade.finance.mapper.FSummaryMapper;
import com.ifeng.bigtrade.finance.tools.CommUtil;

@Service
@Transactional(rollbackFor =
{ Exception.class, RuntimeException.class })
public class SummaryService
{
	@Autowired
	FSummaryMapper summaryMapper;

	@Autowired
	FLedgerFieldMapper fledgerMapper;

	/**
	 * 增加摘要
	 * 
	 * @param summary
	 * @return
	 */
	public int addSummary(FSummary summary)
	{
		return this.summaryMapper.insertSelective(summary);
	}

	/**
	 * 根据example更新科目
	 * 
	 * @param example
	 * @param summary
	 * @return
	 */
	public int updateSummaryByExample(FSummaryExample example, FSummary summary)
	{
		return this.summaryMapper.updateByExampleSelective(summary, example);
	}

	/**
	 * 根据example删除科目
	 * 
	 * @param example
	 * @return
	 */
	public int deleteSummaryByExample(FSummaryExample example)
	{
		return this.summaryMapper.deleteByExample(example);
	}

	/**
	 * 增加摘要
	 * 
	 * @param request
	 * @param summaryNo 摘要号
	 * @param name 摘要名称
	 * @param ledgerItemId 归入总账项目id
	 * @param dCFlag 借贷方向 D为借方，C为贷方，N为不涉及
	 * @param accountCodeOpp 对方科目代码
	 * @param appendAccount 附加账
	 * @param isUserFuds 是否是用户相关，如果是，则accountCodeOpp必须以20100开头
	 * @param canDelete 是否能删除
	 * @return ResponseMessage
	 * @throws Exception
	 */
	public ResponseMessage addSummary(HttpServletRequest request, String summaryNo, String summary, Long ledgerItemId,
			String dCFlag, String accountCodeOpp, String appendAccount, boolean isUserFunds, boolean canDelete)
			throws Exception
	{

		// 如果是用户相关的，accountCodeOpp这个字段必须是20100开头的
		if (isUserFunds)
		{
			if (!accountCodeOpp.startsWith("20100"))
			{
				return new ResponseMessage(new ResponseHeader(request, ERespCode.ParamError, "对方科目代码必须以20100开头!"));
			}
		}
		// 查询归入总账是否存在
		FLedgerField fLedgerField = fledgerMapper.selectByPrimaryKey(ledgerItemId);
		if (fLedgerField == null)
		{
			return new ResponseMessage(new ResponseHeader(request, ERespCode.ParamError, "归入总账项目不存在!"));
		}
		FSummary fsummary = new FSummary();
		fsummary.setAccountCodeOpp(accountCodeOpp);
		fsummary.setAddTime(new Date());
		fsummary.setAppendAccount(appendAccount);
		fsummary.setCanDelete(canDelete);
		fsummary.setDeleteStatus(false);
		fsummary.setIsUserFunds(isUserFunds);
		fsummary.setFundDCFlag(dCFlag);
		fsummary.setLedger_id(ledgerItemId);
		fsummary.setSummary(summary);
		fsummary.setSummaryNo(summaryNo);
		// 添加摘要
		this.addSummary(fsummary);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("summary", fsummary);
		ResponseMessage resp = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ),
				rmap);
		return resp;
	}

	/**
	 * 更新摘要
	 * 
	 * @param request
	 * @param id 摘要id
	 * @param summaryNo 只要号
	 * @param summary 摘要名称
	 * @param ledgerItemId 归入总账项目id
	 * @param dCFlag 借贷方向
	 * @param accountCodeOpp 对方科目代码
	 * @param appendAccount 附加账
	 * @return
	 * @throws Exception
	 */
	public ResponseMessage updateSummary(HttpServletRequest request, Long id, String summaryNo, String summary,
			Long ledgerItemId, String dCFlag, String accountCodeOpp, String appendAccount) throws Exception
	{
		FSummaryExample example = new FSummaryExample();
		Criteria c = example.createCriteria();
		c.andIdEqualTo(id);
		FSummary fsummary = new FSummary();
		if (fsummary.getIsUserFunds() && accountCodeOpp != null)
		{
			if (!accountCodeOpp.startsWith("20100"))
			{
				return new ResponseMessage(new ResponseHeader(request, ERespCode.ParamError, "对方科目代码必须以20100开头!"));
			}
		}
		if (ledgerItemId != null)
		{
			// 查询归入总账是否存在
			FLedgerField fLedgerField = fledgerMapper.selectByPrimaryKey(ledgerItemId);
			if (fLedgerField == null)
			{
				return new ResponseMessage(new ResponseHeader(request, ERespCode.ParamError, "归入总账项目不存在!"));
			}
		}
		fsummary.setAccountCodeOpp(accountCodeOpp);
		fsummary.setAppendAccount(appendAccount);
		fsummary.setFundDCFlag(dCFlag);
		fsummary.setLedger_id(ledgerItemId);
		fsummary.setSummary(summary);
		fsummary.setSummaryNo(summaryNo);
		int count = this.updateSummaryByExample(example, fsummary);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("count", count);
		ResponseMessage resp = new ResponseMessage(CommUtil.respByCount(request, count), rmap);
		return resp;
	}

	/**
	 * 删除摘要
	 * 
	 * @param request
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ResponseMessage deleteSummaryBatch(HttpServletRequest request, List<Long> id) throws Exception
	{

		FSummaryExample example = new FSummaryExample();
		Criteria c = example.createCriteria();
		c.andIdIn(id);
		c.andCanDeleteEqualTo(true);
		int count = this.deleteSummaryByExample(example);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("deleteCount", count);
		ResponseMessage resp = new ResponseMessage(CommUtil.respByCount(request, count), rmap);
		return resp;
	}

	/**
	 * 查询摘要的列表
	 * 
	 * @param request
	 * @param systemid 系统号
	 * @param summaryno 摘要号
	 * @param order 排序
	 * @param pageNum 当前页
	 * @param pageSize 每页条数
	 * @return
	 */
	public ResponseMessage selectSummary(HttpServletRequest request, String systemid, String summaryno, PageReq pagereq)
	{
		PageHelper.startPage(pagereq.getPageNum(), pagereq.getPageSize(), pagereq.getOrderStr());
		List<HashMap<String, Object>> resplist = this.summaryMapper.selectSummary(systemid, summaryno);
		PageInfo<HashMap<String, Object>> page = new PageInfo<>(resplist);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("page", page);
		ResponseMessage resp = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ),
				rmap);
		return resp;
	}

	/**
	 * 根据id获取摘要
	 * 
	 * @param request
	 * @param id
	 * @return
	 * @author shaolin
	 * @time 2017年9月5日 上午11:13:08
	 */
	public ResponseMessage selectSummaryById(HttpServletRequest request, Long id)
	{
		FSummary summary = this.summaryMapper.selectByPrimaryKey(id);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("result", summary);
		ResponseMessage resp = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ),
				rmap);
		return resp;
	}
}

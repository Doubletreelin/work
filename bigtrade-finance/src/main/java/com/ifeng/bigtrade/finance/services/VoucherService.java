package com.ifeng.bigtrade.finance.services;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ifeng.bigtrade.finance.entites.FAccountItem;
import com.ifeng.bigtrade.finance.entites.FVoucher;
import com.ifeng.bigtrade.finance.entites.FVoucherEntry;
import com.ifeng.bigtrade.finance.entites.FVoucherEntryExample;
import com.ifeng.bigtrade.finance.entites.FVoucherExample;
import com.ifeng.bigtrade.finance.entites.FVoucherExample.Criteria;
import com.ifeng.bigtrade.finance.entites.enumf.ERespCode;
import com.ifeng.bigtrade.finance.entites.enumf.ERespMessage;
import com.ifeng.bigtrade.finance.entites.enumf.EVoucherStatus;
import com.ifeng.bigtrade.finance.entites.resp.ResponseHeader;
import com.ifeng.bigtrade.finance.entites.resp.ResponseMessage;
import com.ifeng.bigtrade.finance.exceptions.MyException;
import com.ifeng.bigtrade.finance.filters.PageReq;
import com.ifeng.bigtrade.finance.mapper.FVoucherEntryMapper;
import com.ifeng.bigtrade.finance.mapper.FVoucherMapper;
import com.ifeng.bigtrade.finance.tools.CommUtil;

import bigtrade.logger.BigtradeLoggerUtil;

@Service
@Transactional(rollbackFor =
{ Exception.class, RuntimeException.class })
public class VoucherService
{
	@Autowired
	private FVoucherMapper voucherMapper;

	@Autowired
	private FVoucherEntryMapper voucherEntryMapper;

	@Autowired
	private AccountService accountService;

	/**
	 * 根据example更新凭证
	 * 
	 * @param example 条件
	 * @param voucher
	 * @return
	 */
	public int updateVoucherByExample(FVoucherExample example, FVoucher voucher)
	{
		return this.voucherMapper.updateByExampleSelective(voucher, example);
	}

	/**
	 * 根据example更新细则
	 * 
	 * @param example 条件
	 * @param voucherentry
	 * @return
	 */
	public int updateVoucherEntryByExample(FVoucherEntryExample example, FVoucherEntry voucherentry)
	{
		return this.voucherEntryMapper.updateByExampleSelective(voucherentry, example);
	}

	/**
	 * 增加凭证
	 * 
	 * @param voucher
	 * @return
	 */
	public int addVoucher(FVoucher voucher)
	{
		return this.voucherMapper.insertSelective(voucher);
	}

	/**
	 * 增加细则
	 * 
	 * @param voucherentry
	 * @return
	 */
	public int addVoucherEntry(FVoucherEntry voucherentry)
	{
		return this.voucherEntryMapper.insertSelective(voucherentry);
	}

	/**
	 * 根据exmpale删除voucher
	 * 
	 * @param example
	 * @return
	 */
	public int deleteVoucherByExample(FVoucherExample example)
	{
		return this.voucherMapper.deleteByExample(example);
	}

	/**
	 * 根据id删除凭证
	 * 
	 * @param request
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteVoucher(List<Long> id) throws Exception
	{
		FVoucherExample example = new FVoucherExample();
		Criteria c = example.createCriteria();
		c.andIdIn(id);
		return this.voucherMapper.deleteByExample(example);
	}

	/**
	 * 录入凭证
	 * 
	 * @param request
	 * @param voucherNo 凭证号
	 * @param summary_id 摘要id
	 * @param contractNo 合同号
	 * @param status 状态
	 * @param inputUser 录入人
	 * @param inputTime 录入时间
	 * @param note 备注
	 * @param oneCode 细则的一方科目代码
	 * @param oneName 细则的一方科目名称
	 * @param oneCAmount 细则的一方贷方金额
	 * @param oneDAmount 细则的一方借方金额
	 * @param otherCode 细则的另一方科目代码
	 * @param otherName 细则的另一方科目名称
	 * @return
	 * @throws Exception
	 */
	public ResponseMessage enterVoucher(HttpServletRequest request, String voucherNo, Long summary_id,
			String contractNo, String status, String inputUser, String inputTime, String note, String oneCode,
			String oneName, BigDecimal oneCAmount, BigDecimal oneDAmount, String otherCode, String otherName,
			BigDecimal otherCAmount, BigDecimal otherDAmount) throws Exception
	{
		// 添加凭证
		FVoucher voucher = new FVoucher();
		voucher.setAddTime(new Date());
		voucher.setContractNo(contractNo);
		voucher.setDeleteStatus(false);
		voucher.setInputTime(inputTime == null ? null : new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(inputTime));
		voucher.setInputUser(inputUser);
		voucher.setNote(note);
		voucher.setSummary_id(summary_id);
		voucher.setStatus(status);
		voucher.setVoucherNo(voucherNo);
		this.addVoucher(voucher);
		// 添加细则
		FVoucherEntry entry1 = new FVoucherEntry();
		entry1.setAccountCode(oneCode);
		entry1.setAccountName(oneName);
		entry1.setAddTime(new Date());
		entry1.setCreditAmount(oneCAmount);
		entry1.setDebitAmount(oneDAmount);
		entry1.setDeleteStatus(false);
		entry1.setVoucher_id(voucher.getId());
		this.addVoucherEntry(entry1);
		// 添加细则2
		FVoucherEntry entry2 = new FVoucherEntry();
		entry2.setAccountCode(otherCode);
		entry2.setAccountName(otherName);
		entry2.setAddTime(new Date());
		entry2.setCreditAmount(otherCAmount);
		entry2.setDebitAmount(otherDAmount);
		entry2.setDeleteStatus(false);
		entry2.setVoucher_id(voucher.getId());
		this.addVoucherEntry(entry2);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("voucher", voucher);
		rmap.put("entry1", entry1);
		rmap.put("entry2", entry2);
		ResponseMessage resp = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ),
				rmap);
		return resp;
	}

	/**
	 * 更新增加的凭证
	 * 
	 * @param request
	 * @param voucherNo 凭证号
	 * @param summary_id 摘要id
	 * @param contractNo 合同号
	 * @param status 状态
	 * @param note 备注
	 * @param oneCode 一方的代码
	 * @param oneName 一方的名称
	 * @param oneCAmount 一方的贷方金额
	 * @param oneDAmount 一方的借方金额
	 * @param otherCode 另一方的代码
	 * @param otherName 另一方的名称
	 * @param otherCAmount 另一方贷方金额
	 * @param otherDAmount 另一方借方金额
	 * @param voucherid 凭证id
	 * @param oneid 一方的id
	 * @param otherid 另一方的id
	 * @return
	 * @throws Exception
	 */
	public ResponseMessage updateVoucherOfEnter(HttpServletRequest request, String voucherNo, Long summary_id,
			String contractNo, String status, String note, String oneCode, String oneName, BigDecimal oneCAmount,
			BigDecimal oneDAmount, String otherCode, String otherName, BigDecimal otherCAmount, BigDecimal otherDAmount,
			Long voucherid, Long oneid, Long otherid) throws Exception
	{
		// 添加凭证
		int count = 0;
		if (CommUtil.isNotNull(voucherid))
		{
			FVoucherExample example = new FVoucherExample();
			Criteria c = example.createCriteria();
			c.andIdEqualTo(voucherid);
			FVoucher voucher = new FVoucher();
			voucher.setContractNo(contractNo);
			voucher.setNote(note);
			voucher.setSummary_id(summary_id);
			voucher.setStatus(status);
			voucher.setVoucherNo(voucherNo);
			count = count + this.updateVoucherByExample(example, voucher);
		}
		if (CommUtil.isNotNull(oneid))
		{
			FVoucherEntry voucherEntry = new FVoucherEntry();
			FVoucherEntryExample example = new FVoucherEntryExample();
			com.ifeng.bigtrade.finance.entites.FVoucherEntryExample.Criteria c = example.createCriteria();
			c.andIdEqualTo(oneid);
			voucherEntry.setAccountCode(oneCode);
			voucherEntry.setAccountName(oneName);
			voucherEntry.setCreditAmount(oneCAmount);
			voucherEntry.setDebitAmount(oneDAmount);
			count = count + this.updateVoucherEntryByExample(example, voucherEntry);
		}
		if (CommUtil.isNotNull(otherid))
		{
			FVoucherEntry voucherEntry = new FVoucherEntry();
			FVoucherEntryExample example = new FVoucherEntryExample();
			com.ifeng.bigtrade.finance.entites.FVoucherEntryExample.Criteria c = example.createCriteria();
			c.andIdEqualTo(otherid);
			voucherEntry.setAccountCode(otherCode);
			voucherEntry.setAccountName(otherName);
			voucherEntry.setCreditAmount(otherCAmount);
			voucherEntry.setDebitAmount(otherDAmount);
			count = count + this.updateVoucherEntryByExample(example, voucherEntry);
		}
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("count", count);
		ResponseMessage resp = new ResponseMessage(CommUtil.respByCount(request, count), rmap);
		return resp;
	}

	/**
	 * 删除凭证
	 * 
	 * @param request
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ResponseMessage deleteVoucher(HttpServletRequest request, List<Long> id) throws Exception
	{
		int entryDeleteCount = this.deleteVoucherEntryByVoucherId(id);
		int deletecount = this.deleteVoucher(id);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("deleteVoucherCount", deletecount);
		rmap.put("deleteEntryCount", entryDeleteCount);
		ResponseMessage resp = new ResponseMessage(CommUtil.respByCount(request, deletecount), rmap);
		return resp;
	}

	/**
	 * 根据voucherid删除细则
	 * 
	 * @param voucherid
	 * @return
	 * @throws Exception
	 */
	public int deleteVoucherEntryByVoucherId(List<Long> voucherid) throws Exception
	{
		FVoucherEntryExample example = new FVoucherEntryExample();
		com.ifeng.bigtrade.finance.entites.FVoucherEntryExample.Criteria c = example.createCriteria();
		c.andVoucher_idIn(voucherid);
		int count = this.voucherEntryMapper.deleteByExample(example);
		return count;
	}

	/**
	 * 根据主键id删除细则
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteVoucherEntryById(List<Long> id) throws Exception
	{
		FVoucherEntryExample example = new FVoucherEntryExample();
		com.ifeng.bigtrade.finance.entites.FVoucherEntryExample.Criteria c = example.createCriteria();
		c.andIdIn(id);
		int count = this.voucherEntryMapper.deleteByExample(example);
		return count;
	}

	/**
	 * 更新凭证状态
	 * 
	 * @param id 更新凭证的id
	 * @param status 更新的状态
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public ResponseMessage updateVoucherStatus(HttpServletRequest request, List<Long> id, String status)
			throws Exception
	{
		FVoucher voucher = new FVoucher();
		voucher.setStatus(status);
		FVoucherExample example = new FVoucherExample();
		Criteria c = example.createCriteria();
		c.andIdIn(id);
		int count = this.updateVoucherByExample(example, voucher);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("count", count);
		ResponseMessage resp = new ResponseMessage(CommUtil.respByCount(request, count), rmap);
		return resp;
	}

	/**
	 * 更新凭证状态
	 * 
	 * @param id 更新凭证的id
	 * @param status 更新的状态
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public ResponseMessage checkVoucher(HttpServletRequest request, List<Long> id, String operator) throws Exception
	{
		FVoucher voucher = new FVoucher();
		voucher.setConfirmUser(operator);
		voucher.setStatus("auditing");
		voucher.setConfirmTime(new Date());
		FVoucherExample example = new FVoucherExample();
		Criteria c = example.createCriteria();
		c.andIdIn(id);
		int count = this.updateVoucherByExample(example, voucher);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("count", count);
		ResponseMessage resp = new ResponseMessage(CommUtil.respByCount(request, count), rmap);
		return resp;
	}

	/**
	 * 审核凭证
	 * 
	 * @param id 更新凭证的id
	 * @return
	 * @throws Exception
	 */
	public ResponseMessage auditVoucher(HttpServletRequest request, Long id, String operator) throws Exception
	{
		FVoucher voucher = new FVoucher();
		voucher.setStatus(EVoucherStatus.audited.getFlag());
		voucher.setAuditTime(new Date());
		voucher.setAuditor(operator);
		FVoucherExample example = new FVoucherExample();
		Criteria c = example.createCriteria();
		c.andIdEqualTo(id);
		int count = this.updateVoucherByExample(example, voucher);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("count", count);
		ResponseMessage resp = new ResponseMessage(CommUtil.respByCount(request, count), rmap);
		return resp;
	}

	/**
	 * 查询当前凭证
	 * 
	 * @param summaryno 摘要号
	 * @param summaryname 摘要名称
	 * @param status 状态
	 * @param inputuser 录入人
	 * @param inputtime 录入时间
	 * @param audittime 审核时间
	 * @param auditor 审核人
	 * @param pagereq 分页信息
	 * @return
	 */
	public ResponseMessage selectCurrentVoucher(HttpServletRequest request, String summaryno, String summaryname,
			String status, String inputuser, String inputtime, String auditor, String audittime, PageReq pagereq)
			throws Exception
	{
		// 分页
		PageHelper.startPage(pagereq.getPageNum(), pagereq.getPageSize(), pagereq.getOrderStr());
		// 查询
		List<HashMap<String, Object>> resplist = this.voucherMapper.selectCurrentVoucher(summaryno, summaryname, status,
				inputuser, inputtime, auditor, audittime);
		// 返回
		PageInfo<HashMap<String, Object>> page = new PageInfo<>(resplist);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("page", page);
		ResponseMessage resp = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ),
				rmap);
		return resp;
	}

	/**
	 * 查询历史凭证
	 * 
	 * @param summaryno 摘要号
	 * @param summaryname 摘要名称
	 * @param inputuser 录入员
	 * @param bdate 凭证归属时间
	 * @param pagereq 分页信息
	 * @return
	 */
	@RequestMapping("/selectHistoryVoucher")
	public ResponseMessage selectHistoryVoucher(HttpServletRequest request, String summaryno, String summaryname,
			String inputuser, String bdate, PageReq pagereq) throws Exception
	{
		// 分页
		PageHelper.startPage(pagereq.getPageNum(), pagereq.getPageSize(), pagereq.getOrderStr());
		// 查询
		List<HashMap<String, Object>> resplist = this.voucherMapper.selectHistoryVoucher(summaryno, summaryname,
				inputuser, bdate);
		// 返回
		PageInfo<HashMap<String, Object>> page = new PageInfo<>(resplist);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("page", page);
		ResponseMessage resp = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ),
				rmap);
		return resp;
	}

	/**
	 * 生成系统的凭证，直接成为audited状态
	 * 
	 * @param request
	 * @param voucherNo 凭证号
	 * @param summary_id 摘要id
	 * @param contractNo 合同号
	 * @param oneCode 一方的科目
	 * @param oneName 一方姓名
	 * @param oneCAmount 一方贷方金额
	 * @param oneDAmount 一方借方金额
	 * @param otherCode 另一方的科目
	 * @param otherName 另一方的姓名
	 * @param otherCAmount 另一方贷方金额
	 * @param otherDAmount 另一方借方金额
	 * @param fundflow_id 流水id
	 * @return
	 * @throws Exception
	 */
	public ResponseMessage createSystemVoucher(HttpServletRequest request, String voucherNo, Long summary_id,
			String contractNo, String oneCode, BigDecimal oneCAmount, BigDecimal oneDAmount, String otherCode,
			BigDecimal otherCAmount, BigDecimal otherDAmount, Long fundflow_id) throws Exception
	{
		// 添加凭证
		FVoucher voucher = new FVoucher();
		voucher.setAddTime(new Date());
		voucher.setContractNo(contractNo);
		voucher.setDeleteStatus(false);
		voucher.setInputTime(new Date());
		voucher.setInputUser("system");
		voucher.setNote("系统自动生成");
		voucher.setSummary_id(summary_id);
		voucher.setStatus("audited");
		voucher.setConfirmTime(new Date());
		voucher.setConfirmUser("system");
		voucher.setAuditTime(new Date());
		voucher.setAuditor("system");
		voucher.setFundFlowId(fundflow_id);
		voucher.setVoucherNo(voucherNo);
		this.addVoucher(voucher);
		// 添加细则
		FAccountItem oneAccount = this.accountService.getAccountByCode("20100" + oneCode);
		if (oneAccount == null)
		{
			throw new MyException("并不存在20100" + oneCode + "的科目", ERespCode.ParamError);
		}
		FVoucherEntry entry1 = new FVoucherEntry();
		entry1.setAccountCode(oneAccount.getCode());
		entry1.setAccountName(oneAccount.getName());
		entry1.setAddTime(new Date());
		entry1.setCreditAmount(oneCAmount);
		entry1.setDebitAmount(oneDAmount);
		entry1.setDeleteStatus(false);
		entry1.setVoucher_id(voucher.getId());
		this.addVoucherEntry(entry1);
		// 添加细则2
		FAccountItem otherAccount = this.accountService.getAccountByCode("20100" + otherCode);
		if (otherAccount == null)
		{
			throw new MyException("并不存在20100" + otherCode + "的科目", ERespCode.ParamError);
		}
		FVoucherEntry entry2 = new FVoucherEntry();
		entry2.setAccountCode(otherAccount.getCode());
		entry2.setAccountName(otherAccount.getName());
		entry2.setAddTime(new Date());
		entry2.setCreditAmount(otherCAmount);
		entry2.setDebitAmount(otherDAmount);
		entry2.setDeleteStatus(false);
		entry2.setVoucher_id(voucher.getId());
		this.addVoucherEntry(entry2);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("voucher", voucher);
		rmap.put("entry1", entry1);
		rmap.put("entry2", entry2);
		ResponseMessage resp = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ),
				rmap);
		return resp;
	}

	/**
	 * 根据凭证id获取细则id
	 * 
	 * @param voucher_id
	 * @return
	 * @author shaolin
	 * @time 2017年9月5日 上午11:10:00
	 */
	public List<FVoucherEntry> selectVoucherEntryByVoucherid(Long voucher_id)
	{
		FVoucherEntryExample example = new FVoucherEntryExample();
		example.createCriteria().andVoucher_idEqualTo(voucher_id);
		return this.voucherEntryMapper.selectByExample(example);
	}

	/**
	 * 根据id获取皮鞥正
	 * 
	 * @param request
	 * @param id
	 * @return
	 * @throws Exception
	 * @author shaolin
	 * @time 2017年9月5日 上午11:10:45
	 */
	public ResponseMessage selectVoucherById(HttpServletRequest request, Long id) throws Exception
	{
		FVoucher voucher = this.voucherMapper.selectByPrimaryKey(id);
		List<FVoucherEntry> entrylist = this.selectVoucherEntryByVoucherid(voucher.getId());
		// 返回
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("result", voucher);
		rmap.put("entrylist", entrylist);
		ResponseMessage resp = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ),
				rmap);
		return resp;
	}

	/**
	 * 将所有编辑状态的凭证提交成待审核状态
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	public ResponseMessage confirmAllVoucher(HttpServletRequest request) throws Exception
	{
		FVoucher voucher = new FVoucher();
		voucher.setStatus(EVoucherStatus.auditing.getFlag());
		FVoucherExample example = new FVoucherExample();
		Criteria c = example.createCriteria();
		c.andStatusEqualTo(EVoucherStatus.editing.getFlag());
		int count = this.updateVoucherByExample(example, voucher);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("count", count);
		ResponseMessage resp = new ResponseMessage(CommUtil.respByCount(request, count), rmap);
		return resp;
	}

	/**
	 * 备份
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 * @author shaolin
	 */
	public ResponseMessage backup(HttpServletRequest request) throws Exception
	{
		BigtradeLoggerUtil.operationLogger.info("时间:" + CommUtil.getNowDateStr() + " " + "财务备份开始");
		this.voucherMapper.backup();
		BigtradeLoggerUtil.operationLogger.info("时间:" + CommUtil.getNowDateStr() + " " + "财务备份结束");
		ResponseMessage resp = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ),
				null);
		return resp;
	}
}

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
import com.ifeng.bigtrade.finance.entites.FVoucherModel;
import com.ifeng.bigtrade.finance.entites.FVoucherModelExample;
import com.ifeng.bigtrade.finance.entites.FVoucherModelExample.Criteria;
import com.ifeng.bigtrade.finance.entites.enumf.ERespCode;
import com.ifeng.bigtrade.finance.entites.enumf.ERespMessage;
import com.ifeng.bigtrade.finance.entites.resp.ResponseHeader;
import com.ifeng.bigtrade.finance.entites.resp.ResponseMessage;
import com.ifeng.bigtrade.finance.filters.PageReq;
import com.ifeng.bigtrade.finance.mapper.FVoucherModelMapper;
import com.ifeng.bigtrade.finance.tools.CommUtil;

@Service
@Transactional(rollbackFor =
{ Exception.class, RuntimeException.class })
public class VoucherModelService
{
	@Autowired
	FVoucherModelMapper modelMapper;

	/**
	 * 增加模板
	 * 
	 * @param voucherModel
	 * @return
	 */
	public int addVoucherModel(FVoucherModel voucherModel)
	{
		return this.modelMapper.insertSelective(voucherModel);
	}

	/**
	 * 根据example更新模板
	 * 
	 * @param example 更新条件
	 * @param voucherModel 更新数据
	 * @return
	 */
	public int updateVoucherModelByExample(FVoucherModelExample example, FVoucherModel voucherModel)
	{
		return this.modelMapper.updateByExampleSelective(voucherModel, example);
	}

	/**
	 * 根据example删除模板
	 * 
	 * @param example 删除条件
	 * @return
	 */
	public int deleteVoucherModelByExample(FVoucherModelExample example)
	{
		return this.modelMapper.deleteByExample(example);
	}

	/**
	 * 删除模板
	 * 
	 * @param request
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteVoucherModel(List<Long> id) throws Exception
	{
		FVoucherModelExample example = new FVoucherModelExample();
		Criteria c = example.createCriteria();
		c.andIdIn(id);
		int count = this.modelMapper.deleteByExample(example);
		return count;
	}

	/**
	 * 增加模板
	 * 
	 * @param request
	 * @param modelCode 模板代码
	 * @param modelName 模板名称
	 * @param debitCode 借方代码
	 * @param creditCode 贷方代码
	 * @param contractNo 合同号 （可空）
	 * @param summaryid 摘要id
	 * @param note 备注 （可空）
	 * @return ResponseMessage
	 * @throws Exception
	 */
	public ResponseMessage addVoucherModel(HttpServletRequest request, String modelCode, String modelName,
			String debitCode, String creditCode, String contractNo, Long summaryid, String note) throws Exception
	{
		FVoucherModel voucherModel = new FVoucherModel();
		voucherModel.setAddTime(new Date());
		voucherModel.setContractNo(contractNo);
		voucherModel.setCreditCode(creditCode);
		voucherModel.setDebitCode(debitCode);
		voucherModel.setDeleteStatus(false);
		voucherModel.setModelCode(modelCode);
		voucherModel.setModelName(modelName);
		voucherModel.setNote(note);
		voucherModel.setSummary_id(summaryid);
		this.addVoucherModel(voucherModel);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("fvoucherModel", voucherModel);
		ResponseMessage resp = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ), rmap);
		return resp;
	}

	/**
	 * 更新模板
	 * 
	 * @param modelCode 模板代码
	 * @param modelName 模板名称
	 * @param debitCode 借方代码
	 * @param creditCode 贷方代码
	 * @param contractNo 合同号
	 * @param summaryid 摘要id
	 * @param note 备注
	 * @return
	 * @throws Exception
	 */
	public ResponseMessage updateVoucherModel(HttpServletRequest request, Long id, String modelCode, String modelName,
			String debitCode, String creditCode, String contractNo, Long summaryid, String note) throws Exception
	{
		FVoucherModel voucherModel = new FVoucherModel();
		voucherModel.setContractNo(contractNo);
		voucherModel.setCreditCode(creditCode);
		voucherModel.setDebitCode(debitCode);
		voucherModel.setModelCode(modelCode);
		voucherModel.setModelName(modelName);
		voucherModel.setNote(note);
		voucherModel.setSummary_id(summaryid);
		FVoucherModelExample example = new FVoucherModelExample();
		Criteria c = example.createCriteria();
		c.andIdEqualTo(id);
		int count = this.updateVoucherModelByExample(example, voucherModel);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("count", count);
		ResponseMessage resp = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ), rmap);
		return resp;
	}

	/**
	 * 删除模板
	 * 
	 * @param request
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ResponseMessage deleteVoucherModel(HttpServletRequest request, List<Long> id) throws Exception
	{
		int count = this.deleteVoucherModel(id);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("deleteCount", count);
		ResponseMessage resp = new ResponseMessage(CommUtil.respByCount(request, count), rmap);
		return resp;
	}

	/**
	 * 查询模板
	 * 
	 * @param request
	 * @param modelCode
	 * @param pagereq
	 * @return
	 * @throws Exception
	 */
	public ResponseMessage selectVoucherModel(HttpServletRequest request, String modelCode, String name,
			PageReq pagereq) throws Exception
	{
		// 分页
		PageHelper.startPage(pagereq.getPageNum(), pagereq.getPageSize(), pagereq.getOrderStr());
		// 组织查询条件
		FVoucherModelExample example = new FVoucherModelExample();
		Criteria c = example.createCriteria();
		if (CommUtil.isNotNull(modelCode))
		{
			c.andModelCodeEqualTo(modelCode);
		}
		if (CommUtil.isNotNull(name))
		{
			c.andModelNameEqualTo(name);
		}
		// 查询
		List<FVoucherModel> resplist = this.modelMapper.selectByExampleWithBLOBs(example);
		// 返回
		PageInfo<FVoucherModel> page = new PageInfo<>(resplist);
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("page", page);
		ResponseMessage resp = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ), rmap);
		return resp;
	}

	/**
	 * 根据id获取模板
	 * 
	 * @param request
	 * @param id
	 * @return
	 * @throws Exception
	 * @author shaolin
	 * @time 2017年9月5日 上午11:17:09
	 */
	public ResponseMessage selectVoucherModelById(HttpServletRequest request, Long id) throws Exception
	{
		FVoucherModel model = this.modelMapper.selectByPrimaryKey(id);
		// 返回
		HashMap<String, Object> rmap = new HashMap<>();
		rmap.put("result", model);
		ResponseMessage resp = new ResponseMessage(new ResponseHeader(request, ERespCode.Succ, ERespMessage.Succ), rmap);
		return resp;
	}
}

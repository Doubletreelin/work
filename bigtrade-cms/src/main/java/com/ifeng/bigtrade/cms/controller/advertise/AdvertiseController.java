package com.ifeng.bigtrade.cms.controller.advertise;

import bigtrade.logger.BigtradeLoggerUtil;
import com.ifeng.bigtrade.cms.entites.advertise.Advertise;
import com.ifeng.bigtrade.cms.entites.advertise.AdvertiseExample;
import com.ifeng.bigtrade.cms.entites.resp.ResponseHeader;
import com.ifeng.bigtrade.cms.entites.resp.ResponseMessage;
import com.ifeng.bigtrade.cms.enums.RespStatusCode;
import com.ifeng.bigtrade.cms.services.advertise.AdvertiseService;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/advertise" })
public class AdvertiseController {

	@Autowired
	private AdvertiseService advertiseService;

	@RequestMapping({ "/add/{belong}" })
	public Object addAdvertising(HttpServletRequest request, HttpServletResponse response, @Validated Advertise ad,
			@PathVariable("belong") String belong) throws Exception {
		BigtradeLoggerUtil.operationLogger.loggerInfoReq("bigtrade-cms", "addAdvertising", "添加轮播广告", null,
				new Object[0]);
		ResponseHeader header = null;
		if ("home".equals(belong)) {
			ad.setBelongTo(Integer.valueOf(Advertise.belongPage.homePage_roll.getId()));
			ad.setPosition(Integer.valueOf(Advertise.belongPage.homePage_roll.getPosition()));
		} else if ("trustee".equals(belong)) {
			ad.setBelongTo(Integer.valueOf(Advertise.belongPage.trusteePage_roll.getId()));
			ad.setPosition(Integer.valueOf(Advertise.belongPage.trusteePage_roll.getPosition()));
		} else if ("appArticle".equals(belong)) {
			ad.setBelongTo(Integer.valueOf(Advertise.belongPage.app_article_roll.getId()));
			ad.setPosition(Integer.valueOf(Advertise.belongPage.app_article_roll.getPosition()));
		} else {
			header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.ParamError.getId()),
					RespStatusCode.ParamError.getName());
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-cms", "addAdvertising", "添加轮播广告", null,
					new Object[] { header.toString() });
			return new ResponseMessage(header, null);
		}
		AdvertiseExample example = new AdvertiseExample();
		example.createCriteria().andBelongToEqualTo(ad.getBelongTo()).andPositionEqualTo(ad.getPosition())
				.andOrderNumEqualTo(ad.getOrderNum());
		List list = this.advertiseService.selectByCondition(example);

		header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.Succ.getId()),
				RespStatusCode.Succ.getName());
		HashMap body = new HashMap();
		Long aid = null;
		if ((list == null) || (list.size() == 0)) {
			aid = this.advertiseService.editAdvertise(ad);
			body.put("aid", aid);
		} else {
			header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.Error.getId()), "该位置广告已存在");
		}
		BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-cms", "addAdvertising", "修改交易日期", null,
				new Object[] { header.toString() });
		return new ResponseMessage(header, body);
	}

	@RequestMapping({ "/delete/{id}" })
	public Object delAdvertising(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Long id)
			throws Exception {
		BigtradeLoggerUtil.operationLogger.loggerInfoReq("bigtrade-cms", "delAdvertising", "删除轮播广告", null,
				new Object[] { id });
		ResponseHeader header = null;
		if (this.advertiseService.delAdvertise(id) == 1) {
			header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.Succ.getId()),
					RespStatusCode.Succ.getName());
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-cms", "delAdvertising", "删除轮播广告", null,
					new Object[] { header.toString() });
			return new ResponseMessage(header, null);
		}

		header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.Error.getId()),
				RespStatusCode.Error.getName());
		BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-cms", "delAdvertising", "删除轮播广告", null,
				new Object[] { header.toString() });
		return new ResponseMessage(header, null);
	}

	@RequestMapping({ "/update/{id}" })
	public Object updateAdvertising(HttpServletRequest request, HttpServletResponse response, @Validated Advertise ad,
			@PathVariable("id") Long id) throws Exception {
		BigtradeLoggerUtil.operationLogger.loggerInfoReq("bigtrade-cms", "updateAdvertising", "编辑轮播广告", null,
				new Object[0]);

		ResponseHeader header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.Succ.getId()),
				RespStatusCode.Succ.getName());
		HashMap body = new HashMap();
		Long aid = null;
		ad.setId(id);
		aid = this.advertiseService.editAdvertise(ad);
		if (aid == null) {
			header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.Error.getId()),
					RespStatusCode.Error.getName());
			BigtradeLoggerUtil.operationLogger.loggerInfoReq("bigtrade-cms", "updateAdvertising", "编辑轮播广告", null,
					new Object[] { header.toString() });
		}
		body.put("aid", aid);
		return new ResponseMessage(header, body);
	}

	@RequestMapping({ "/select/{belongTo}/{position}" })
	public Object getArticle(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("belongTo") Integer belongTo, @PathVariable("position") Integer position) throws Exception {
		AdvertiseExample example = new AdvertiseExample();
		example.createCriteria().andBelongToEqualTo(belongTo).andPositionEqualTo(position);
		example.setOrderByClause("orderNum asc");

		ResponseHeader header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.Succ.getId()),
				RespStatusCode.Succ.getName());
		List list = this.advertiseService.selectByCondition(example);
		if ((list == null) || (list.size() <= 0)) {
			header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.ObjectNull.getId()),
					RespStatusCode.ObjectNull.getName());
		}
		HashMap body = new HashMap();
		body.put("list", list);
		return new ResponseMessage(header, body);
	}

	@RequestMapping({ "/detail/{aid}" })
	public Object getDetail(HttpServletRequest request, HttpServletResponse response, @PathVariable Long aid)
			throws Exception {
		Advertise advertise = this.advertiseService.getDetail(aid);

		ResponseHeader header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.Succ.getId()),
				RespStatusCode.Succ.getName());
		HashMap body = new HashMap();
		body.put("advertise", advertise);
		return new ResponseMessage(header, body);
	}
}
package com.ifeng.bigtrade.cms.controller.article;

import bigtrade.logger.BigtradeLogger;
import bigtrade.logger.BigtradeLoggerUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ifeng.bigtrade.cms.entites.article.Article;
import com.ifeng.bigtrade.cms.entites.article.Article.AuditState;
import com.ifeng.bigtrade.cms.entites.article.Article.ShowState;
import com.ifeng.bigtrade.cms.entites.article.ArticleExample;
import com.ifeng.bigtrade.cms.entites.article.ArticleExample.Criteria;
import com.ifeng.bigtrade.cms.entites.article.ArticleType;
import com.ifeng.bigtrade.cms.entites.article.ArticleWithBLOBs;
import com.ifeng.bigtrade.cms.entites.article.TypeAndModule;
import com.ifeng.bigtrade.cms.entites.resp.ResponseHeader;
import com.ifeng.bigtrade.cms.entites.resp.ResponseMessage;
import com.ifeng.bigtrade.cms.enums.RespStatusCode;
import com.ifeng.bigtrade.cms.exception.CommonException;
import com.ifeng.bigtrade.cms.services.article.ArticleService;
import com.ifeng.bigtrade.cms.services.article.ArticleTypeService;
import com.ifeng.bigtrade.cms.services.article.ModuleService;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/article" })
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private ArticleTypeService typeService;

	@Autowired
	private ModuleService moduleService;
	private static HashMap<String, Integer> hitsMap = new HashMap();

	@RequestMapping({ "/add" })
	public Object addArticle(HttpServletRequest request, HttpServletResponse response,
			@Validated ArticleWithBLOBs articleWithBLOBs) throws Exception {
		BigtradeLoggerUtil.operationLogger.loggerInfoReq("bigtrade-cms", "addArticle", "添加文章", null, new Object[0]);
		Long aid = this.articleService.editArticle(articleWithBLOBs);

		ResponseHeader header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.Succ.getId()),
				RespStatusCode.Succ.getName());
		HashMap body = new HashMap();
		body.put("aid", aid);
		BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-cms", "addArticle", "添加文章", null,
				new Object[] { header.toString() });
		return new ResponseMessage(header, body);
	}

	@RequestMapping({ "/delete" })
	public Object delArticle(HttpServletRequest request, HttpServletResponse response, Long id, Long[] ids)
			throws Exception {
		BigtradeLoggerUtil.operationLogger.loggerInfoReq("bigtrade-cms", "delArticle", "删除文章", null, new Object[0]);
		ResponseHeader header = null;
		if ((id == null) && ((ids == null) || (ids.length <= 0))) {
			header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.ParamNull.getId()),
					RespStatusCode.ParamNull.getName());
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-cms", "delArticle", "删除文章", null,
					new Object[] { header.toString() });
			return new ResponseMessage(header, null);
		}
		if ((this.articleService.delOneArticle(id)) || (this.articleService.delMoreArticle(ids))) {
			header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.Succ.getId()),
					RespStatusCode.Succ.getName());
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-cms", "delArticle", "删除文章", null,
					new Object[] { header.toString() });
			return new ResponseMessage(header, null);
		}

		header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.Error.getId()),
				RespStatusCode.Error.getName());
		BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-cms", "delArticle", "删除文章", null,
				new Object[] { header.toString() });

		return new ResponseMessage(new ResponseHeader(request, Integer.valueOf(RespStatusCode.Error.getId()),
				RespStatusCode.Error.getName()), null);
	}

	@RequestMapping({ "/update" })
	public Object updateArticle(HttpServletRequest request, HttpServletResponse response,
			@Validated ArticleWithBLOBs articleWithBLOBs) throws Exception {
		BigtradeLoggerUtil.operationLogger.loggerInfoReq("bigtrade-cms", "updateArticle", "修改文章", null, new Object[0]);
		ResponseHeader header = null;
		if (articleWithBLOBs.getId() == null) {
			header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.ParamNull.getId()),
					RespStatusCode.ParamNull.getName());
			BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-cms", "updateArticle", "修改文章", null,
					new Object[] { header.toString() });
			return new ResponseMessage(header, null);
		}
		Long aid = this.articleService.editArticle(articleWithBLOBs);

		header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.Succ.getId()),
				RespStatusCode.Succ.getName());
		HashMap body = new HashMap();
		body.put("aid", aid);
		BigtradeLoggerUtil.operationLogger.loggerInfoRsp("bigtrade-cms", "updateArticle", "修改文章", null,
				new Object[] { header.toString(), aid });
		return new ResponseMessage(header, body);
	}

	@RequestMapping({ "/select" })
	public Object getArticle(HttpServletRequest request, HttpServletResponse response,
			ArticleWithBLOBs articleWithBLOBs, Integer pageNum, Integer pageSize) throws Exception {
		PageHelper.startPage(pageNum == null ? 1 : pageNum.intValue(), pageSize == null ? 10 : pageSize.intValue());

		List list = this.articleService.getArticleBycondition(articleWithBLOBs);

		ResponseHeader header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.Succ.getId()),
				RespStatusCode.Succ.getName());
		PageInfo page = new PageInfo(list);
		if ((list == null) || (list.size() <= 0)) {
			header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.ObjectNull.getId()),
					RespStatusCode.ObjectNull.getName());
		}

		HashMap body = new HashMap();
		body.put("page", page);
		return new ResponseMessage(header, body);
	}

	@RequestMapping({ "/get/{aid}" })
	public Object getDetail(HttpServletRequest request, HttpServletResponse response, @PathVariable Long aid)
			throws Exception {
		ArticleWithBLOBs article = this.articleService.getDetail(aid);

		ResponseHeader header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.Succ.getId()),
				RespStatusCode.Succ.getName());
		HashMap body = new HashMap();
		body.put("article", article);
		return new ResponseMessage(header, body);
	}

	@RequestMapping({ "/audit/{aid}" })
	public Object auditArticle(HttpServletRequest request, HttpServletResponse response, @PathVariable("aid") Long aid,
			String remarks, Integer state, Integer uid, String uName, String uIp) throws Exception {
		if ((state == null) || (uid == null) || (StringUtils.isBlank(uName)) || (StringUtils.isBlank(uIp))) {
			throw new CommonException(RespStatusCode.ParamNull.getName(),
					Integer.valueOf(RespStatusCode.ParamNull.getId()));
		}

		boolean flag = false;
		Article.AuditState[] stateStr = Article.AuditState.values();
		for (Article.AuditState sta : stateStr) {
			if (sta.getState() == state.intValue()) {
				flag = true;
				break;
			}
		}
		if (flag) {
			HashMap map = new HashMap();
			map.put("userId", uid);
			map.put("userName", uName);
			map.put("userIp", uIp);
			ObjectMapper objectMapper = new ObjectMapper();
			if (this.articleService.auditArticle(aid, remarks, state, objectMapper.writeValueAsString(map))) {
				return new ResponseMessage(new ResponseHeader(request, Integer.valueOf(RespStatusCode.Succ.getId()),
						RespStatusCode.Succ.getName()), null);
			}

			return new ResponseMessage(new ResponseHeader(request, Integer.valueOf(RespStatusCode.Error.getId()),
					RespStatusCode.Error.getName()), null);
		}

		return new ResponseMessage(new ResponseHeader(request, Integer.valueOf(RespStatusCode.ParamError.getId()),
				RespStatusCode.ParamError.getName()), null);
	}

	@RequestMapping({ "/show/{aid}/{state}" })
	public Object showArticle(HttpServletRequest request, HttpServletResponse response, @PathVariable("aid") Long aid,
			@PathVariable("state") String state) throws Exception {
		Integer showState = Integer.valueOf(Article.ShowState.HIDE.getState());
		if ("all".equals(state)) {
			showState = Integer.valueOf(Article.ShowState.SHOW_ALL.getState());
		} else if ("web".equals(state)) {
			showState = Integer.valueOf(Article.ShowState.SHOW_WEB.getState());
		} else if ("app".equals(state)) {
			showState = Integer.valueOf(Article.ShowState.SHOW_APP.getState());
		}
		ArticleWithBLOBs article = new ArticleWithBLOBs();
		article.setId(aid);
		article.setShowState(showState);
		if (this.articleService.updateSelective(article)) {
			return new ResponseMessage(new ResponseHeader(request, Integer.valueOf(RespStatusCode.Succ.getId()),
					RespStatusCode.Succ.getName()), null);
		}

		return new ResponseMessage(new ResponseHeader(request, Integer.valueOf(RespStatusCode.Error.getId()),
				RespStatusCode.Error.getName()), null);
	}

	@RequestMapping({ "/helpcenter/{mid}" })
	@ResponseBody
	public Object helpcenter(HttpServletRequest request, HttpServletResponse response, @PathVariable("mid") Long mid)
			throws Exception {
		List<TypeAndModule> list = this.moduleService.getTypeId(mid);
		List rlist = new ArrayList();
		ArticleType at = new ArticleType();
		for (TypeAndModule tm : list) {
			at.setId(tm.getTypeId());

			List mainlist = this.typeService.getTypeBycondition(at);
			if ((mainlist != null) && (mainlist.size() > 0)) {
				ArticleType mainType = (ArticleType) mainlist.get(0);

				List alist = this.articleService.selectByType(null, false, mainType.getId(), null);
				mainType.setArticlelist(alist);
				rlist.add(mainType);
			}
		}
		return rlist;
	}

	@RequestMapping({ "/noticecenter/{mid}" })
	@ResponseBody
	public Object notice(HttpServletRequest request, HttpServletResponse response, @PathVariable("mid") Long mid,
			Integer types) throws Exception {
		HashMap map = new HashMap();
		List tlist = new ArrayList();
		PageHelper.startPage(1, types == null ? 3 : types.intValue());
		List list = this.moduleService.getTypeId(mid);
		PageInfo pageInfo = new PageInfo(list);
		List<TypeAndModule> mlist = pageInfo.getList();
		ArticleType at = new ArticleType();
		for (TypeAndModule tm : mlist) {
			at.setId(tm.getTypeId());
			List mainlist = this.typeService.getTypeBycondition(at);
			if ((mainlist != null) && (mainlist.size() > 0)) {
				ArticleType mainType = (ArticleType) mainlist.get(0);
				tlist.add(mainType);
			}
		}
		PageHelper.startPage(1, 10);
		List toplist = this.articleService.selectByType(null, true, null, null);
		pageInfo = new PageInfo(toplist);
		map.put("tlist", tlist);
		map.put("top", pageInfo.getList());
		return map;
	}

	@RequestMapping({ "/{type}/article" })
	@ResponseBody
	public Object getArticle(HttpServletRequest request, HttpServletResponse response, @PathVariable("type") Long type,
			Integer pageNum, Integer pageSize) throws Exception {
		HashMap map = new HashMap();

		PageHelper.startPage(pageNum == null ? 1 : pageNum.intValue(), pageSize == null ? 10 : pageSize.intValue());
		List list = this.articleService.selectByType(null, false, type, null);
		PageInfo pageInfo = new PageInfo(list);
		map.put("pageInfo", pageInfo);
		return map;
	}

	@RequestMapping({ "/{type}/detail" })
	@ResponseBody
	public Object getArticleDetail(HttpServletRequest request, HttpServletResponse response, Long aid, Integer index,
			@PathVariable("type") String type, Long mainId, Integer pageNum, Integer pageSize) throws Exception {
		if ((index == null) && (aid == null)) {
			return "null";
		}
		HashMap map = new HashMap();

		List list = null;
		ArticleWithBLOBs article = null;
		List prelist = null;
		List nextlist = null;
		int preindex = 0;
		int nextindex = 0;
		String url = "";
		if (!"link".equals(type)) {
			preindex = index.intValue() - 1;
			nextindex = index.intValue() + 1;
			url = request.getServletPath() + "?" + request.getQueryString();
			url = url.substring(0, url.lastIndexOf("&index"));
		}
		if (("home".equals(type)) && (mainId != null)) {
			PageHelper.startPage(index.intValue(), 1);
			list = this.articleService.selectByType(null, false, mainId, null);
			PageInfo pageInfohome = new PageInfo(list);
			list = pageInfohome.getList();
			if (pageInfohome.isHasPreviousPage()) {
				PageHelper.startPage(pageInfohome.getPrePage(), 1);
				prelist = this.articleService.selectByType(null, false, mainId, null);
			}
			if (pageInfohome.isHasNextPage()) {
				PageHelper.startPage(pageInfohome.getNextPage(), 1);
				nextlist = this.articleService.selectByType(null, false, mainId, null);
			}
		} else if ("hot".equals(type)) {
			PageHelper.startPage(index.intValue(), 1);
			list = this.articleService.selectByType(null, true, null, null);
			PageInfo pageInfohot = new PageInfo(list);
			list = pageInfohot.getList();
			if (pageInfohot.isHasPreviousPage()) {
				PageHelper.startPage(pageInfohot.getPrePage(), 1);
				prelist = this.articleService.selectByType(null, false, mainId, null);
			}
			if (pageInfohot.isHasNextPage()) {
				PageHelper.startPage(pageInfohot.getNextPage(), 1);
				nextlist = this.articleService.selectByType(null, false, mainId, null);
			}
		} else if ("new".equals(type)) {
			PageHelper.startPage(index.intValue(), 1);
			list = this.articleService.selectByType(null, false, null, null);
			PageInfo pageInfonew = new PageInfo(list);
			list = pageInfonew.getList();
			if (pageInfonew.isHasPreviousPage()) {
				PageHelper.startPage(pageInfonew.getPrePage(), 1);
				prelist = this.articleService.selectByType(null, false, mainId, null);
			}
			if (pageInfonew.isHasNextPage()) {
				PageHelper.startPage(pageInfonew.getNextPage(), 1);
				nextlist = this.articleService.selectByType(null, false, mainId, null);
			}
		} else if ("link".equals(type)) {
			list = this.articleService.selectByType(aid, false, null, null);
		}

		if ((list != null) && (list.size() > 0)) {
			article = (ArticleWithBLOBs) list.get(0);
			ArticleType sub = this.typeService.getTypeById(article.getTypeId());
			ArticleType main = this.typeService.getTypeById(sub.getParentId());
			article.setMainName(main.getName());
			article.setMainId(main.getId());
			map.put("info", article);

			if (hitsMap.get(article.getId().toString()) != null) {
				Integer hits = (Integer) hitsMap.get(article.getId().toString());
				Integer localInteger1 = hits;
				Integer localInteger2 = hits = Integer.valueOf(hits.intValue() + 1);
				if (hits.intValue() == 100) {
					ArticleWithBLOBs withBLOBs = new ArticleWithBLOBs();
					withBLOBs.setId(Long.valueOf(Long.parseLong(article.getId().toString())));
					withBLOBs.setHits(hits);
					this.articleService.updateSelective(withBLOBs);
					hitsMap.put(article.getId().toString(), Integer.valueOf(0));
				} else {
					hitsMap.put(article.getId().toString(), hits);
				}
			} else {
				hitsMap.put(article.getId().toString(), Integer.valueOf(1));
			}

			if ((prelist != null) && (prelist.size() > 0)) {
				String preurl = url + "&index=" + preindex;
				article.setPretitle(((ArticleWithBLOBs) prelist.get(0)).getTitle());
				article.setPreId(((ArticleWithBLOBs) prelist.get(0)).getId());
				article.setPreurl(preurl);
			} else {
				article.setPretitle("no");
				preindex = 0;
			}
			if ((nextlist != null) && (nextlist.size() > 0)) {
				String nexturl = url + "&index=" + nextindex;
				article.setNexttitle(((ArticleWithBLOBs) nextlist.get(0)).getTitle());
				article.setNextid(((ArticleWithBLOBs) nextlist.get(0)).getId());
				article.setNexturl(nexturl);
			} else {
				article.setNexttitle("no");
				nextindex = 0;
			}
		}

		if (!"link".equals(type)) {
			PageHelper.startPage(pageNum == null ? 1 : pageNum.intValue(), pageSize == null ? 10 : pageSize.intValue());
			List nlist = this.articleService.selectByType(null, false, null, null);
			PageInfo pageInfo = new PageInfo(nlist);
			map.put("nlist", pageInfo.getList());
		}
		map.put("mainId", mainId);
		map.put("preindex", Integer.valueOf(preindex));
		map.put("nextindex", Integer.valueOf(nextindex));

		return map;
	}

	@RequestMapping({ "/app/select" })
	public Object getAppArticle(HttpServletRequest request, HttpServletResponse response, Integer pageNum,
			Integer pageSize) throws Exception {
		ArticleExample example = new ArticleExample();
		example.or().andAuditStateEqualTo(Integer.valueOf(Article.AuditState.audited.getState()))
				.andDeleteStatusEqualTo(Boolean.valueOf(false))
				.andShowStateEqualTo(Integer.valueOf(Article.ShowState.SHOW_ALL.getState()))
				.andPublishTimeLessThanOrEqualTo(new Date());

		example.or().andAuditStateEqualTo(Integer.valueOf(Article.AuditState.audited.getState()))
				.andDeleteStatusEqualTo(Boolean.valueOf(false))
				.andShowStateEqualTo(Integer.valueOf(Article.ShowState.SHOW_APP.getState()))
				.andPublishTimeLessThanOrEqualTo(new Date());

		example.setOrderByClause("publishTime desc");
		PageHelper.startPage(pageNum == null ? 1 : pageNum.intValue(), pageSize == null ? 10 : pageSize.intValue());
		List list = this.articleService.getArticleByExample(example);

		ResponseHeader header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.Succ.getId()),
				RespStatusCode.Succ.getName());
		PageInfo page = new PageInfo(list);
		if ((list == null) || (list.size() <= 0)) {
			header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.ObjectNull.getId()),
					RespStatusCode.ObjectNull.getName());
		}

		HashMap body = new HashMap();
		body.put("page", page);
		return new ResponseMessage(header, body);
	}
}
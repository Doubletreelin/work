package com.ifeng.bigtrade.cms.controller.article;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ifeng.bigtrade.cms.entites.article.ArticleType;
import com.ifeng.bigtrade.cms.entites.resp.ResponseHeader;
import com.ifeng.bigtrade.cms.entites.resp.ResponseMessage;
import com.ifeng.bigtrade.cms.enums.RespStatusCode;
import com.ifeng.bigtrade.cms.exception.CommonException;
import com.ifeng.bigtrade.cms.services.article.ArticleTypeService;
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
@RequestMapping({ "/articletype" })
public class ArticleTypeController {

	@Autowired
	private ArticleTypeService typeService;

	@RequestMapping({ "/addmain", "/addsub" })
	public Object addArticle(HttpServletRequest request, HttpServletResponse response,
			@Validated ArticleType articleType) throws Exception {
		String uri = request.getRequestURI();
		if (uri.contains("addsub")) {
			if (articleType.getParentId() == null) {
				throw new CommonException(RespStatusCode.ParamNull.getName(),
						Integer.valueOf(RespStatusCode.ParamNull.getId()));
			}
			if (!this.typeService.getMainType(articleType.getParentId())) {
				throw new CommonException("主栏目不存在", Integer.valueOf(RespStatusCode.ParamError.getId()));
			}
		} else {
			articleType.setParentId(Long.valueOf(0L));
		}

		Long atid = this.typeService.editType(articleType);
		ResponseHeader header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.Succ.getId()),
				RespStatusCode.Succ.getName());
		HashMap body = new HashMap();
		body.put("atid", atid);
		return new ResponseMessage(header, body);
	}

	@RequestMapping({ "/delete/main/{tids}" })
	public Object delMain(HttpServletRequest request, HttpServletResponse response, @PathVariable("tids") Long[] tids)
			throws Exception {
		if ((tids != null) && (tids.length > 0) && (this.typeService.delMainType(tids))) {
			return new ResponseMessage(new ResponseHeader(request, Integer.valueOf(RespStatusCode.Succ.getId()),
					RespStatusCode.Succ.getName()), null);
		}

		return new ResponseMessage(new ResponseHeader(request, Integer.valueOf(RespStatusCode.ParamNull.getId()),
				RespStatusCode.ParamNull.getName()), null);
	}

	@RequestMapping({ "/update/main", "/update/sub" })
	public Object updateArticle(HttpServletRequest request, HttpServletResponse response,
			@Validated ArticleType articleType) throws Exception {
		if (articleType.getId() == null) {
			throw new CommonException(RespStatusCode.ParamNull.getName() + "id",
					Integer.valueOf(RespStatusCode.ParamNull.getId()));
		}
		String uri = request.getRequestURI();
		if (uri.contains("/update/sub")) {
			if (articleType.getParentId() == null) {
				throw new CommonException(RespStatusCode.ParamNull.getName() + "parentId",
						Integer.valueOf(RespStatusCode.ParamNull.getId()));
			}
			if (!this.typeService.getMainType(articleType.getParentId())) {
				throw new CommonException("主栏目不存在", Integer.valueOf(RespStatusCode.ParamError.getId()));
			}
		} else {
			articleType.setParentId(Long.valueOf(0L));
		}
		Long atid = this.typeService.editType(articleType);
		ResponseHeader header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.Succ.getId()),
				RespStatusCode.Succ.getName());
		HashMap body = new HashMap();
		body.put("atid", atid);
		return new ResponseMessage(header, body);
	}

	@RequestMapping({ "/select/main" })
	public Object getArticle(HttpServletRequest request, HttpServletResponse response, ArticleType articleType,
			Integer pageNum, Integer pageSize) throws Exception {
		PageHelper.startPage(pageNum == null ? 1 : pageNum.intValue(), pageSize == null ? 10 : pageSize.intValue());

		List list = this.typeService.getTypeBycondition(articleType);
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

	@RequestMapping({ "/delete/sub/{tids}" })
	public Object delSub(HttpServletRequest request, HttpServletResponse response, @PathVariable("tids") Long[] tids)
			throws Exception {
		if ((tids != null) && (tids.length > 0) && (this.typeService.delSubType(tids))) {
			return new ResponseMessage(new ResponseHeader(request, Integer.valueOf(RespStatusCode.Succ.getId()),
					RespStatusCode.Succ.getName()), null);
		}

		return new ResponseMessage(new ResponseHeader(request, Integer.valueOf(RespStatusCode.ParamNull.getId()),
				RespStatusCode.ParamNull.getName()), null);
	}

	@RequestMapping({ "/select/sub/{pid}" })
	public Object getSub(HttpServletRequest request, HttpServletResponse response, @PathVariable("pid") Long pid,
			Integer pageNum, Integer pageSize) throws Exception {
		PageHelper.startPage(pageNum == null ? 1 : pageNum.intValue(), pageSize == null ? 10 : pageSize.intValue());
		List list = this.typeService.getSubType(pid);
		PageInfo page = new PageInfo(list);
		ResponseHeader header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.Succ.getId()),
				RespStatusCode.Succ.getName());
		if ((list == null) || (list.size() <= 0)) {
			header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.ObjectNull.getId()),
					RespStatusCode.ObjectNull.getName());
		}

		HashMap body = new HashMap();
		body.put("page", page);
		return new ResponseMessage(header, body);
	}
}
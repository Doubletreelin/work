package com.ifeng.bigtrade.cms.controller.article;

import com.ifeng.bigtrade.cms.entites.article.ArticleType;
import com.ifeng.bigtrade.cms.entites.resp.ResponseHeader;
import com.ifeng.bigtrade.cms.entites.resp.ResponseMessage;
import com.ifeng.bigtrade.cms.enums.RespStatusCode;
import com.ifeng.bigtrade.cms.exception.CommonException;
import com.ifeng.bigtrade.cms.services.article.ArticleTypeService;
import com.ifeng.bigtrade.cms.services.article.ModuleService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/module" })
public class ModuleController {

	@Autowired
	private ModuleService moduleService;

	@Autowired
	private ArticleTypeService typeService;

	@RequestMapping({ "/get" })
	public Object getAllModule(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List list = this.moduleService.findAll();

		ResponseHeader header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.Succ.getId()),
				RespStatusCode.Succ.getName());
		if ((list == null) || (list.size() <= 0)) {
			header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.ObjectNull.getId()),
					RespStatusCode.ObjectNull.getName());
		}
		HashMap body = new HashMap();
		body.put("list", list);
		return new ResponseMessage(header, body);
	}

	@RequestMapping({ "/update/{mid}" })
	public Object updateModule(HttpServletRequest request, HttpServletResponse response, @PathVariable("mid") Long mid,
			String name, Long[] tids) throws Exception {
		if ((StringUtils.isBlank(name)) || (tids == null) || (tids.length <= 0)) {
			throw new CommonException(RespStatusCode.ParamNull.getName(),
					Integer.valueOf(RespStatusCode.ParamNull.getId()));
		}
		this.moduleService.updModule(mid, name, tids);

		ResponseHeader header = new ResponseHeader(request, Integer.valueOf(RespStatusCode.Succ.getId()),
				RespStatusCode.Succ.getName());
		return new ResponseMessage(header, null);
	}

	@RequestMapping({ "/edit/{mid}" })
	public Object editModule(HttpServletRequest request, HttpServletResponse response, @PathVariable("mid") Long mid)
			throws Exception {
		List<ArticleType> alist = this.typeService.getMainTypeByMid(null);
		List<ArticleType> mlist = this.typeService.getMainTypeByMid(mid);
		for (Iterator localIterator1 = mlist.iterator(); localIterator1.hasNext();) {
			ArticleType at = (ArticleType) localIterator1.next();

			for (ArticleType articleType : alist) {
				if (articleType.getId().longValue() == at.getId().longValue()) {
					alist.remove(articleType);
					break;
				}
			}
		}
		ArticleType at;
		HashMap body = new HashMap();
		body.put("alist", alist);
		body.put("mlist", mlist);

		return new ResponseMessage(new ResponseHeader(request, Integer.valueOf(RespStatusCode.Succ.getId()),
				RespStatusCode.Succ.getName()), body);
	}
}
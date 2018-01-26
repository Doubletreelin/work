package com.ifeng.bigtrade.cms.services.article.impl;

import com.ifeng.bigtrade.cms.entites.article.ArticleExample;
import com.ifeng.bigtrade.cms.entites.article.ArticleExample.Criteria;
import com.ifeng.bigtrade.cms.entites.article.ArticleType;
import com.ifeng.bigtrade.cms.entites.article.ArticleTypeExample;
import com.ifeng.bigtrade.cms.entites.article.TypeAndModuleExample;
import com.ifeng.bigtrade.cms.enums.RespStatusCode;
import com.ifeng.bigtrade.cms.exception.CommonException;
import com.ifeng.bigtrade.cms.mapper.article.ArticleMapper;
import com.ifeng.bigtrade.cms.mapper.article.ArticleTypeMapper;
import com.ifeng.bigtrade.cms.mapper.article.TypeAndModuleMapper;
import com.ifeng.bigtrade.cms.services.article.ArticleTypeService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = { Exception.class, RuntimeException.class })
@Service
public class ArticleTypeServiceImpl implements ArticleTypeService {

	@Autowired
	private ArticleTypeMapper typeMapper;

	@Autowired
	private ArticleMapper articleMapper;

	@Autowired
	private TypeAndModuleMapper typeAndModuleMapper;

	public Long editType(ArticleType at) throws Exception {
		int i = 0;
		at.setDeleteStatus(Boolean.valueOf(false));
		if (at.getId() == null) {
			at.setAddTime(new Date());
			i = this.typeMapper.insert(at);
		} else {
			i = this.typeMapper.updateByPrimaryKeySelective(at);
		}
		if (i == 1) {
			return at.getId();
		}

		throw new CommonException("添加/修改文章栏目" + RespStatusCode.Error.getName(),
				Integer.valueOf(RespStatusCode.Error.getId()));
	}

	public boolean delSubType(Long[] ids) throws Exception {
		List tids = Arrays.asList(ids);
		ArticleExample articleExample = new ArticleExample();
		articleExample.createCriteria().andTypeIdIn(tids);

		this.articleMapper.deleteByExample(articleExample);

		ArticleTypeExample example = new ArticleTypeExample();
		example.createCriteria().andIdIn(tids);
		if (this.typeMapper.deleteByExample(example) == ids.length) {
			return true;
		}

		throw new CommonException("传入的栏目数与删除的栏目条数不等", Integer.valueOf(RespStatusCode.Error.getId()));
	}

	public boolean delMainType(Long[] tids) throws Exception {
		List ids = Arrays.asList(tids);
		ArticleTypeExample example = new ArticleTypeExample();
		example.createCriteria().andParentIdIn(ids);

		List<ArticleType> list = this.typeMapper.selectByExample(example);
		if ((list != null) && (list.size() > 0)) {
			List tlist = new ArrayList();
			for (ArticleType articleType : list) {
				tlist.add(articleType.getId());
			}
			ArticleExample articleExample = new ArticleExample();
			articleExample.createCriteria().andTypeIdIn(tlist);

			this.articleMapper.deleteByExample(articleExample);

			this.typeMapper.deleteByExample(example);
		}

		TypeAndModuleExample tmExample = new TypeAndModuleExample();
		tmExample.createCriteria().andTypeIdIn(ids);
		this.typeAndModuleMapper.deleteByExample(tmExample);
		ArticleTypeExample mExample = new ArticleTypeExample();
		mExample.createCriteria().andIdIn(ids);

		if (this.typeMapper.deleteByExample(mExample) == tids.length) {
			return true;
		}

		throw new CommonException("传入的栏目数与删除的栏目条数不等", Integer.valueOf(RespStatusCode.Error.getId()));
	}

	public List<ArticleType> getTypeBycondition(ArticleType at) throws Exception {
		return this.typeMapper.selectByCondition(at);
	}

	public boolean getMainType(Long id) throws Exception {
		ArticleTypeExample example = new ArticleTypeExample();
		example.createCriteria().andIdEqualTo(id).andParentIdEqualTo(Long.valueOf(0L));
		List list = this.typeMapper.selectByExample(example);
		if ((list != null) && (list.size() == 1)) {
			return true;
		}
		return false;
	}

	public List<ArticleType> getSubType(Long pid) throws Exception {
		ArticleTypeExample example = new ArticleTypeExample();
		example.createCriteria().andParentIdEqualTo(pid);
		return this.typeMapper.selectByExample(example);
	}

	public ArticleType getTypeById(Long subid) throws Exception {
		return this.typeMapper.selectByPrimaryKey(subid);
	}

	public List<ArticleType> getMainTypeByMid(Long mid) throws Exception {
		return this.typeMapper.selectMaintype(mid);
	}

	public ArticleType getWithSubtype(Long mainid) throws Exception {
		ArticleType mainType = this.typeMapper.selectByPrimaryKey(mainid);
		List sublist = getSubType(mainid);
		mainType.setSublist(sublist);
		return mainType;
	}
}
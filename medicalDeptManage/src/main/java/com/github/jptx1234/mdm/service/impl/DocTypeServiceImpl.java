package com.github.jptx1234.mdm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.jptx1234.mdm.dao.DocTypeDao;
import com.github.jptx1234.mdm.model.DocType;
import com.github.jptx1234.mdm.service.DocTypeService;


@Service("docTypeService")
public class DocTypeServiceImpl implements DocTypeService {
	
	@Autowired
	private DocTypeDao docTypeDao;

	@Override
	public int count(DocType example) {
		int count = docTypeDao.count(example);
		return count;
	}

	@Override
	public List<DocType> list(DocType example, int pageNum, int pageSize) {
		int start = pageSize * (pageNum - 1);
		List<DocType> list = docTypeDao.listByPage(example, start, pageSize);
		
		return list;
	}

	@Override
	public int delete(List<Integer> idList) {
		return docTypeDao.delete(idList);
	}

	@Override
	public void add(DocType stuffPackType) {
		
		docTypeDao.insert(stuffPackType);
	}

	@Override
	public int countBlur(String kw) {
		return docTypeDao.countBlur(kw);
	}

	@Override
	public List<DocType> listBlur(String kw, Integer page, Integer pageSize) {
		int start = pageSize * (page - 1);
		return docTypeDao.listBlur(kw, start, pageSize);
	}

}

package com.github.jptx1234.mdm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.jptx1234.mdm.dao.DocInstanceDao;
import com.github.jptx1234.mdm.model.DocInstance;
import com.github.jptx1234.mdm.service.DocInstanceService;


@Service("docInstanceService")
public class DocInstanceServiceImpl implements DocInstanceService {
	
	@Autowired
	private DocInstanceDao docInstanceDao;

	@Override
	public int count(DocInstance example) {
		int count = docInstanceDao.count(example);
		return count;
	}

	@Override
	public List<DocInstance> list(DocInstance example, int pageNum, int pageSize) {
		int start = pageSize * (pageNum - 1);
		List<DocInstance> list = docInstanceDao.listByPage(example, start, pageSize);
		
		return list;
	}

	@Override
	public int delete(List<Integer> idList) {
		return docInstanceDao.delete(idList);
	}

	@Override
	public void add(DocInstance stuffPackType) {
		
		docInstanceDao.insert(stuffPackType);
	}

	@Override
	public int countBlur(String kw, Integer doc_type_id) {
		return docInstanceDao.countBlur(kw, doc_type_id);
	}

	@Override
	public List<DocInstance> listBlur(String kw, Integer page, Integer pageSize, Integer doc_type_id) {
		int start = pageSize * (page - 1);
		return docInstanceDao.listBlur(kw, doc_type_id, start, pageSize);
	}

	@Override
	public DocInstance getOne(Integer id) {
		DocInstance example = new DocInstance();
		example.setId(id);
		List<DocInstance> list = docInstanceDao.listByPage(example, 0, 0);
		if(list == null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

}

package com.github.jptx1234.mdm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.jptx1234.mdm.dao.StuffPackDecomposeDao;
import com.github.jptx1234.mdm.model.StuffPackDecompose;
import com.github.jptx1234.mdm.service.StuffPackDecomposeService;


@Service("stuffPackDecomposeService")
public class StuffPackDecomposeServiceImpl implements StuffPackDecomposeService {
	
	@Autowired
	private StuffPackDecomposeDao stuffPackDecomposeDao;

	@Override
	public int count(StuffPackDecompose example) {
		int count = stuffPackDecomposeDao.count(example);
		return count;
	}

	@Override
	public List<StuffPackDecompose> list(StuffPackDecompose example, int pageNum, int pageSize) {
		int start = pageSize * (pageNum - 1);
		List<StuffPackDecompose> list = stuffPackDecomposeDao.listByPage(example, start, pageSize);
		
		return list;
	}

	@Override
	public int delete(List<Integer> idList) {
		return stuffPackDecomposeDao.delete(idList);
	}

	@Override
	public void add(StuffPackDecompose stuffPackType) {
		
		stuffPackDecomposeDao.insert(stuffPackType);
	}

	@Override
	public int countBlur(String kw) {
		return stuffPackDecomposeDao.countBlur(kw);
	}

	@Override
	public List<StuffPackDecompose> listBlur(String kw, Integer page, Integer pageSize) {
		int start = pageSize * (page - 1);
		return stuffPackDecomposeDao.listBlur(kw, start, pageSize);
	}

}

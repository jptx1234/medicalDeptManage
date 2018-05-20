package com.github.jptx1234.mdm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.jptx1234.mdm.dao.StuffPackDao;
import com.github.jptx1234.mdm.model.StuffPack;
import com.github.jptx1234.mdm.service.StuffPackService;

@Service("stuffPackService")
public class StuffPackServiceImpl implements StuffPackService {
	
	@Autowired
	private StuffPackDao stuffPackDao;

	@Override
	public int count(StuffPack example) {
		int count = stuffPackDao.count(example);
		return count;
	}

	@Override
	public List<StuffPack> list(StuffPack example, int pageNum, int pageSize) {
		int start = pageSize * (pageNum - 1);
		List<StuffPack> list = stuffPackDao.listByPage(example, start, pageSize);
		
		return list;
	}

	@Override
	public int delete(List<Integer> idList) {
		return stuffPackDao.delete(idList);
	}

	@Override
	public void add(StuffPack stuffPackType) {
		
		stuffPackDao.insert(stuffPackType);
	}

	@Override
	public int countBlur(String kw) {
		return stuffPackDao.countBlur(kw);
	}

	@Override
	public List<StuffPack> listBlur(String kw, Integer page, Integer pageSize) {
		int start = pageSize * (page - 1);
		return stuffPackDao.listBlur(kw, start, pageSize);
	}

}

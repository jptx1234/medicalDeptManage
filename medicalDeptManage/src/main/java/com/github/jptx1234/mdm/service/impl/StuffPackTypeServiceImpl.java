package com.github.jptx1234.mdm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.jptx1234.mdm.dao.StuffPackTypeDao;
import com.github.jptx1234.mdm.model.StuffPackType;
import com.github.jptx1234.mdm.service.StuffPackTypeService;

@Service("stuffPackTypeService")
public class StuffPackTypeServiceImpl implements StuffPackTypeService {
	
	@Autowired
	private StuffPackTypeDao stuffPackTypeDao;

	@Override
	public int count(StuffPackType example) {
		int count = stuffPackTypeDao.count(example);
		return count;
	}

	@Override
	public List<StuffPackType> list(StuffPackType example, int pageNum, int pageSize) {
		return null;
	}

}

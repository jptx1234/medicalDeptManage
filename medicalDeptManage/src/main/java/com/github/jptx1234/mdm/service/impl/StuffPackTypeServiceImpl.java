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
		int start = pageSize * (pageNum - 1);
		List<StuffPackType> list = stuffPackTypeDao.listByPage(example, start, pageSize);
		
		return list;
	}

	@Override
	public int delete(List<Integer> idList) {
		return stuffPackTypeDao.delete(idList);
	}

	@Override
	public void add(StuffPackType stuffPackType) {
		String stuffPackTypeName = stuffPackType.getPackTypeName();
		if(stuffPackTypeName != null) {
			StuffPackType example = new StuffPackType();
			example.setPackTypeName(stuffPackTypeName);
			List<StuffPackType> list = stuffPackTypeDao.listByPage(example, 0, 10);
			if(list != null && list.size() > 0) {
				throw new RuntimeException("类别名称【"+stuffPackTypeName+"】已存在");
			}
		}
		
		stuffPackTypeDao.insert(stuffPackType);
	}

	@Override
	public int countBlur(String kw) {
		return stuffPackTypeDao.countBlur(kw);
	}

	@Override
	public List<StuffPackType> listBlur(String kw, Integer page, Integer pageSize) {
		int start = pageSize * (page - 1);
		return stuffPackTypeDao.listBlur(kw, start, pageSize);
	}

}

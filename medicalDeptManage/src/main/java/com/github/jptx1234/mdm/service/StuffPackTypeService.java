package com.github.jptx1234.mdm.service;

import java.util.List;

import com.github.jptx1234.mdm.model.StuffPackType;

public interface StuffPackTypeService {

	int count(StuffPackType example);

	List<StuffPackType> list(StuffPackType example, int pageNum, int pageSize);

	int delete(List<Integer> idList);

	void add(StuffPackType stuffPackType);

	int countBlur(String kw);

	List<StuffPackType> listBlur(String kw, Integer page, Integer pageSize);

}

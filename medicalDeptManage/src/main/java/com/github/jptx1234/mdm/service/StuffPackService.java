package com.github.jptx1234.mdm.service;

import java.util.List;

import com.github.jptx1234.mdm.model.StuffPack;

public interface StuffPackService {

	int count(StuffPack example);

	List<StuffPack> list(StuffPack example, int pageNum, int pageSize);

	int delete(List<Integer> idList);

	void add(StuffPack stuffPackType);

	int countBlur(String kw, Integer packTypeId);

	List<StuffPack> listBlur(String kw, Integer page, Integer pageSize, Integer packTypeId);

}

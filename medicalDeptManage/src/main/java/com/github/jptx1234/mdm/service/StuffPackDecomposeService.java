package com.github.jptx1234.mdm.service;

import java.util.List;

import com.github.jptx1234.mdm.model.StuffPackDecompose;


public interface StuffPackDecomposeService {

	int count(StuffPackDecompose example);

	List<StuffPackDecompose> list(StuffPackDecompose example, int pageNum, int pageSize);

	int delete(List<Integer> idList);

	void add(StuffPackDecompose stuffPackType);

	int countBlur(String kw, Integer packId);

	List<StuffPackDecompose> listBlur(String kw, Integer page, Integer pageSize, Integer packId);

}

package com.github.jptx1234.mdm.service;

import java.util.List;

import com.github.jptx1234.mdm.model.DocType;



public interface DocTypeService {

	int count(DocType example);

	List<DocType> list(DocType example, int pageNum, int pageSize);

	int delete(List<Integer> idList);

	void add(DocType stuffPackType);

	int countBlur(String kw);

	List<DocType> listBlur(String kw, Integer page, Integer pageSize);

}

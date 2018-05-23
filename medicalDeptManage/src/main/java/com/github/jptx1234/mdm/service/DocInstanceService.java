package com.github.jptx1234.mdm.service;

import java.util.List;

import com.github.jptx1234.mdm.model.DocInstance;



public interface DocInstanceService {

	int count(DocInstance example);

	List<DocInstance> list(DocInstance example, int pageNum, int pageSize);

	int delete(List<Integer> idList);

	void add(DocInstance docInstance);

	int countBlur(String kw);

	List<DocInstance> listBlur(String kw, Integer page, Integer pageSize);

}

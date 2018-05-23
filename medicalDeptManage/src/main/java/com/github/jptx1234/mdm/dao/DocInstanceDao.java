package com.github.jptx1234.mdm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.jptx1234.mdm.model.DocInstance;


public interface DocInstanceDao {

	int count(DocInstance example);

	List<DocInstance> listByPage(@Param("example") DocInstance example, @Param("start") int start, @Param("size") int size);

	int delete(List<Integer> idList);

	void insert(DocInstance docInstance);

	int countBlur(@Param("kw") String kw);

	List<DocInstance> listBlur(@Param("kw") String kw, @Param("start") int start, @Param("size") int pageSize);

}

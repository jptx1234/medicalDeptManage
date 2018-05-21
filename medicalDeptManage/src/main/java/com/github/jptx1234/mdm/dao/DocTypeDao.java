package com.github.jptx1234.mdm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.jptx1234.mdm.model.DocType;


public interface DocTypeDao {

	int count(DocType example);

	List<DocType> listByPage(@Param("example") DocType example, @Param("start") int start, @Param("size") int size);

	int delete(List<Integer> idList);

	void insert(DocType stuffPack);

	int countBlur(@Param("kw") String kw);

	List<DocType> listBlur(@Param("kw") String kw, @Param("start") int start, @Param("size") int pageSize);

}

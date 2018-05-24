package com.github.jptx1234.mdm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.jptx1234.mdm.model.StuffPackDecompose;


public interface StuffPackDecomposeDao {

	int count(StuffPackDecompose example);

	List<StuffPackDecompose> listByPage(@Param("example") StuffPackDecompose example, @Param("start") int start, @Param("size") int size);

	int delete(List<Integer> idList);

	void insert(StuffPackDecompose stuffPack);

	int countBlur(@Param("kw") String kw, @Param("packId")Integer packId);

	List<StuffPackDecompose> listBlur(@Param("kw") String kw, @Param("start") int start, @Param("size") int pageSize, @Param("packId") Integer packId);

}
